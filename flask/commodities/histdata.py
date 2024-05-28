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

# Fetch data
if __name__ == "__main__":
    data = fetch_historical_data()
    print(data.head())
