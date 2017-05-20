from flask import request, url_for
from flask.ext.api import FlaskAPI, status, exceptions
from kkb_data import DatabaseHelper
from modules import *

app = FlaskAPI(__name__)


@app.route('/kkb/set_data', methods=['POST'])
def kkb_set_api():
    if request.method == 'POST':
        content = request.get_json()
        udid = content["udid"]
        pid = content["product_id"]
        if udid is not None and pid is not None:
            DatabaseHelper().kkb_setter(udid,pid)
        return content

@app.route('/kkb/get_data', methods=['POST'])
def kkb_get_api():
    if request.method == 'POST':
        content = request.get_json()
        pid = content["product_id"]
        if pid is not None:
            result = DatabaseHelper().kkb_getter(pid)
            return json.dumps({"count": str(result)})


@app.route('/kkb/update_data', methods=['POST'])
def kkb_update_api():
    if request.method == 'POST':
        content = request.get_json()
        udid = content["udid"]
        pid = content["product_id"]
        duration = content["session_duration"]
        if udid is not None and pid is not None and duration is not None:
            DatabaseHelper().kkb_update(udid, pid, duration)
        return content



if __name__ == "__main__":
    app.run(debug=True)