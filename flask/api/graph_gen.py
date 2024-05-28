import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from keras.models import load_model
from sklearn.preprocessing import MinMaxScaler
from datetime import datetime, timedelta
from .histdata import fetch_historical_data

def plot_corn_futures(num_historical_points, num_predicted_points, filename):
    # Load the LSTM model
    model = load_model('api/corn_futures_lstm_model.h5')

    # Fetch the required number of historical data points
    historical_data = fetch_historical_data()[-num_historical_points:]

    # Prepare the data
    historical_data = historical_data[['Date', 'Cash Price']]
    historical_data['Timestamp'] = historical_data['Date'].apply(lambda x: x.timestamp())

    # Scale the data
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_data = scaler.fit_transform(historical_data[['Timestamp', 'Cash Price']])

    # Create sequences
    seq_length = 10  # Use the same sequence length as during training
    last_sequence = scaled_data[-seq_length:]

    # Generate predictions
    predictions_scaled = []
    for _ in range(num_predicted_points):
        # Reshape data for LSTM model input
        X = last_sequence.reshape((1, seq_length, 2))

        # Make prediction
        predicted_price_scaled = model.predict(X)[0][0]

        # Append prediction to the list
        predictions_scaled.append(predicted_price_scaled)

        # Update the sequence with the new prediction
        new_timestamp = historical_data['Timestamp'].iloc[-1] + 86400 * (len(predictions_scaled))
        new_data = np.array([[new_timestamp, predicted_price_scaled]])
        last_sequence = np.append(last_sequence, new_data, axis=0)[-seq_length:]

    # Convert predictions to a DataFrame for easier handling
    prediction_timestamps = [historical_data['Timestamp'].iloc[-1] + 86400 * (i + 1) for i in range(num_predicted_points)]
    predictions_df = pd.DataFrame(predictions_scaled, columns=['Scaled_Price'])
    predictions_df['Timestamp'] = prediction_timestamps

    # Inverse transform predictions to get the actual price values
    extended_scaled_data = np.vstack((scaled_data, predictions_df[['Timestamp', 'Scaled_Price']]))
    extended_data = scaler.inverse_transform(extended_scaled_data)

    # Extract the historical and predicted prices
    historical_prices = extended_data[:num_historical_points, 1]
    predicted_prices = extended_data[num_historical_points:, 1]

    # Create a date range for predictions
    last_date = historical_data['Date'].iloc[-1]
    prediction_dates = [last_date + timedelta(days=i) for i in range(1, num_predicted_points + 1)]

    # Plot the results
    plt.figure(figsize=(14, 7))

    # Plot historical prices
    plt.plot(historical_data['Date'], historical_prices, label='Historical Prices', color='blue')

    # Plot predicted prices
    plt.plot(prediction_dates, predicted_prices, label='Predicted Prices', color='red', linestyle='--')

    # Add labels and title
    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.title('Corn Futures Prices')
    plt.legend()

    # Improve layout
    plt.xticks(rotation=45)
    plt.grid(True)
    plt.tight_layout()

    # Save plot to file
    plt.savefig('api/images/' + filename)
    plt.close()

if __name__ == "__main__":
    plot_corn_futures(25, 5, 'test.png')
