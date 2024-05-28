from flask import Blueprint, request, jsonify, send_file
from ..commodities.data import CommodityData
from ..commodities.graph_gen import plot_corn_futures
import os

commodities_api = Blueprint('commodities_api', __name__)

@commodities_api.route('/calculate_score', methods=['POST'])
def calculate_score():
    data = request.get_json()
    num_futures = data.get('num_futures')
    action = data.get('action')
    
    if num_futures is None or action not in ['buy', 'sell']:
        return jsonify({"error": "Invalid input"}), 400

    commodity_data = CommodityData(num_futures, action)
    score = commodity_data.evaluate_commodity()
    
    return jsonify({"score": score})

@commodities_api.route('/generate_graph', methods=['POST'])
def generate_graph():
    data = request.get_json()
    num_historical_points = data.get('num_historical_points')
    num_predicted_points = data.get('num_predicted_points')
    
    if num_historical_points is None or num_predicted_points is None:
        return jsonify({"error": "Invalid input"}), 400

    filename = 'corn_futures_plot.png'
    plot_corn_futures(num_historical_points, num_predicted_points, filename)
    
    return send_file(os.path.join('flask/commodities/images', filename), mimetype='image/png')

