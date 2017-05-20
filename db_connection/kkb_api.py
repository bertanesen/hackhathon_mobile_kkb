from flask.ext.api import FlaskAPI

app = FlaskAPI(__name__)

@app.route('/example/')
def example():
    return {'hello': 'world'}