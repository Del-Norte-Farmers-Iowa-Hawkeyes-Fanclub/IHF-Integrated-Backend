# imports from flask
import os
from sqlite3 import OperationalError
from flask import redirect, render_template, request, url_for  # import render_template from "public" flask libraries
from flask_login import current_user, login_user, logout_user
from flask.cli import AppGroup

# import "objects" from "this" project
from __init__ import app, db, login_manager  # Key Flask objects 

# API endpoints
from api.players import player_api
from api.monte_carlo_controller import monte_carlo_api
from api.user import user_api
from api.commodities import commodities_api  # Import the new commodities controller
# database Initialization functions
from model.jokes import initJokes
from model.users import User, initUsers
# server only Views
from views.algorithm.algorithm import algorithm_views 
from views.projects.projects import project_views

# Initialize the SQLAlchemy object to work with the Flask app instance
db.init_app(app)

# register URIs for api endpoints
# register URIs for api endpoints
app.register_blueprint(player_api)
app.register_blueprint(monte_carlo_api)
app.register_blueprint(user_api)
app.register_blueprint(commodities_api)
# register URIs for server pages
app.register_blueprint(algorithm_views) 
app.register_blueprint(project_views) 

@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))

@app.route('/init')
def init():
    initUsers()
    return "ayyyyy"

# app context processor
@app.context_processor
def inject_user():
    return dict(current_user=current_user)

@app.errorhandler(404)  # catch for URL not found
def page_not_found(e):
    # note that we set the 404 status explicitly
    return render_template('404.html'), 404

@app.route('/')  # connects default URL to index() function
def index():
    print("Home:", current_user)
    return render_template("index.html")

# returns render template for table
@app.route('/table/')  # connects /table/ URL
def table():
    return render_template("table.html")

@app.route('/login/')  # connects /table/ URL
def login_page():
    return render_template("login.html")

# first request for first backend, second request for second backend
@app.route('/login', methods=['POST'])
def login():
    # authenticate user
    user = User.query.filter_by(_uid=request.form['username']).first()
    if user and user.is_password(request.form['password']):
        login_user(user)
        print("Logged in:", current_user)
        return redirect(url_for('index'))
    else:
        return 'Invalid username or password'
    
@app.route('/logout')
def logout():
    logout_user()
    return redirect(url_for('index'))

@app.route('/check_db')
def check_db():
    db_path = os.path.join(app.instance_path, '../sqlite.db')
    db_file_exists = os.path.exists('../sqlite.db')

    return {
        "db_file_exists": db_file_exists,
    }


# Create an AppGroup for custom commands
custom_cli = AppGroup('custom', help='Custom commands')

# Define a command to run the data generation functions
@custom_cli.command('generate_data')
def generate_data():
    initJokes()
    initUsers()

# Register the custom command group with the Flask application
# Register the custom command group with the Flask application
app.cli.add_command(custom_cli)
        
# this runs the flask application on the development server
if __name__ == "__main__":
    # change name for testing
    app.run(debug=True, host="0.0.0.0", port="8086")


## new app router
## first commit on new repo
## I can't run main.py ROHIN can you run it once I commit 
## new commit new commit
## testing commit debugging
