import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_squared_error

# Load historical options data
data = pd.read_csv('historical_options_data.csv')

# Feature selection and preprocessing
features = data[['strike_price', 'expiration_date', 'implied_volatility', 'underlying_price']]
target = data['option_price']

# Train-test split
X_train, X_test, y_train, y_test = train_test_split(features, target, test_size=0.2, random_state=42)

# Model training
model = RandomForestRegressor(n_estimators=100, random_state=42)
model.fit(X_train, y_train)

# Prediction
predictions = model.predict(X_test)

# Evaluate the model
mse = mean_squared_error(y_test, predictions)
print(f'Mean Squared Error: {mse}')

# Save the model for future use
import joblib
joblib.dump(model, 'option_pricing_model.pkl')
