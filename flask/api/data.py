import numpy as np
from keras.models import load_model
from sklearn.preprocessing import MinMaxScaler
import pandas as pd
import json

# Update the file path to match your directory structure
FUTURES_DATA_PATH = 'flask/api/Futures_Data.json'

def fetch_historical_data_recent():
    with open(FUTURES_DATA_PATH, 'r') as f:
        data = json.load(f)
    df = pd.DataFrame(data['dataset']['data'], columns=data['dataset']['column_names'])
    df['Date'] = pd.to_datetime(df['Date'])
    df = df.sort_values(by='Date').tail(10)  # Get the 10 most recent data points
    return df

class CommodityData:
    def __init__(self, num_futures, action):
        self.num_futures = num_futures
        self.trading_price = self.fetch_current_trading_price()
        self.action = action

    def fetch_current_trading_price(self):
        with open(FUTURES_DATA_PATH, 'r') as f:
            data = json.load(f)
        current_price = data['dataset']['data'][-1][1]  # Assuming 'Cash Price' is the second column
        return current_price

    def evaluate_commodity(self):
        # Load the LSTM model
        model = load_model('flask/api/corn_futures_lstm_model.h5')

        # Fetch the 10 most recent historical data points
        historical_data = fetch_historical_data_recent()

        # Prepare the data
        historical_data = historical_data[['Date', 'Cash Price']]
        historical_data['Timestamp'] = historical_data['Date'].apply(lambda x: x.timestamp())

        # Scale the data
        scaler = MinMaxScaler(feature_range=(0, 1))
        scaled_data = scaler.fit_transform(historical_data[['Timestamp', 'Cash Price']])
        
        # Create sequences
        seq_length = 10  # Use the same sequence length as during training
        last_sequence = scaled_data[-seq_length:]

        # Add the new input data
        new_data = np.array([[self.trading_price, self.num_futures]])
        new_scaled_data = scaler.transform(new_data)
        
        # Extend the sequence with the new data
        extended_sequence = np.append(last_sequence, new_scaled_data, axis=0)

        # Ensure the sequence length matches the input shape for the model
        if len(extended_sequence) > seq_length:
            extended_sequence = extended_sequence[-seq_length:]

        # Reshape data for LSTM model input
        X = extended_sequence.reshape((1, seq_length, 2))

        # Make prediction
        prediction = model.predict(X)
        predicted_price = prediction[0][0]

        # Calculate score based on action
        score = (predicted_price - self.trading_price) * self.num_futures
        if self.action == 'sell':
            score = -score  # Invert the score for sell actions, assuming a positive score is good for buy

        return self.trading_price, predicted_price, score

# Tester code
if __name__ == "__main__":
    num_futures = 100  # Number of futures to buy/sell
    action = 'buy'  # Action: 'buy' or 'sell'

    # Create an instance of CommodityData
    commodity_data = CommodityData(num_futures, action)

    # Evaluate commodity
    trading_price, predicted_price, score = commodity_data.evaluate_commodity()

    # Print the result
    print(f"Current Trading Price: {trading_price}")
    print(f"Predicted Trading Price: {predicted_price}")
    print(f"Evaluation Score: {score}")
