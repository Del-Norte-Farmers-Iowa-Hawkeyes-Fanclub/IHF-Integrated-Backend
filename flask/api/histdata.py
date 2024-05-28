import json
import pandas as pd

def fetch_historical_data():
    with open('flask/api/Futures_Data.json') as f:
        data = json.load(f)
    
    df = pd.DataFrame(data['dataset']['data'], columns=data['dataset']['column_names'])
    df['Date'] = pd.to_datetime(df['Date'])
    df = df.sort_values(by='Date')
    return df

def fetch_historical_data_recent():
    with open('flask/api/Futures_Data.json') as f:
        data = json.load(f)
    
    df = pd.DataFrame(data['dataset']['data'], columns=data['dataset']['column_names'])
    df['Date'] = pd.to_datetime(df['Date'])
    df = df.sort_values(by='Date').tail(10)
    return df[['Date', 'Cash Price', 'Basis', 'Fall Price', 'Fall Basis']]
