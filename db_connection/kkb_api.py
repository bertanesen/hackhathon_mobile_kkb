from flask import request, url_for
from flask.ext.api import FlaskAPI, status, exceptions
from kkb_data import DatabaseHelper

app = FlaskAPI(__name__)


@app.route('/kkb/data', methods=['POST'])
def kkb_set_api():
    if request.method == 'POST':
        content = request.get_json()
        return content
        udid = content["udid"]
        pid = content["product_id"]
        if udid is not None and pid is not None:
            DatabaseHelper().kkb_setter(udid,pid)



if __name__ == "__main__":
    app.run(debug=True)