# histdata.py

import requests
import pandas as pd

def fetch_historical_data():
    url = "http://data.nasdaq.com/api/v3/datasets/TFGRAIN/CORN.json"
    response = requests.get(url)
    
    if response.status_code == 200:
        data = response.json()['dataset']
        df = pd.DataFrame(data['data'], columns=data['column_names'])
        df['Date'] = pd.to_datetime(df['Date'])
        df = df.sort_values(by='Date')
        return df
    else:
        raise Exception(f"Failed to fetch data: {response.status_code}")

def fetch_historical_data_recent():
    url = "https://data.nasdaq.com/api/v3/datasets/TFGRAIN/CORN/data.json"
    params = {
        "order": "desc",  # Order by descending date
        "limit": 10,      # Fetch 10 most recent data points
    }
    response = requests.get(url, params=params)
    
    if response.status_code == 200:
        data = response.json().get('dataset_data').get('data')
        df = pd.DataFrame(data, columns=['Date', 'Cash Price', 'Basis', 'Fall Price', 'Fall Basis'])
        df['Date'] = pd.to_datetime(df['Date'])
        df = df.sort_values(by='Date')
        return df
    else:
        raise Exception(f"Failed to fetch data: {response.status_code}")
