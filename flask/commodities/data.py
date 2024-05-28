import numpy as np
from keras.models import load_model
from sklearn.preprocessing import MinMaxScaler
import pandas as pd
from .histdata import fetch_historical_data_recent
import requests

class CommodityData:
    def __init__(self, num_futures, action):
        self.num_futures = num_futures
        self.trading_price = self.fetch_current_trading_price()
        self.action = action

    def fetch_current_trading_price(self):
        url = "https://data.nasdaq.com/api/v3/datasets/TFGRAIN/CORN/data.json"
        params = {
            "order": "desc",  # Order by descending date
            "limit": 1,
        }
        response = requests.get(url, params=params)
        
        if response.status_code == 200:
            data = response.json().get('dataset_data').get('data')
            current_price = data[0][1]  # Assuming 'Cash Price' is the second column
            return current_price
        else:
            raise Exception(f"Failed to fetch current trading price: {response.status_code}")

    def evaluate_commodity(self):
        # Load the LSTM model
        model = load_model('path_to_your_model/corn_futures_lstm_model.h5')

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

        return score

