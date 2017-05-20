from flask import request, url_for
from flask.ext.api import FlaskAPI, status, exceptions
from kkb_data import DatabaseHelper

app = FlaskAPI(__name__)


@app.route('/kkb/set_data', methods=['POST'])
def kkb_set_api():
    if request.method == 'POST':
        content = request.get_json()
        udid = content["udid"]
        print udid
        pid = content["product_id"]
        print pid
        if udid is not None and pid is not None:
            DatabaseHelper().kkb_setter(udid,pid)
        return content

@app.route('/kkb/get_data', methods=['POST'])
def kkb_get_api():
    if request.method == 'POST':
        content = request.get_json()
        udid = content["udid"]
        print udid
        pid = content["product_id"]
        print pid
        if udid is not None and pid is not None:
            DatabaseHelper().kkb_getter(udid,pid)
        return content

@app.route('/kkb/update_data', methods=['POST'])
def kkb_update_api():
    if request.method == 'POST':
        content = request.get_json()
        udid = content["udid"]
        print udid
        pid = content["product_id"]
        print pid
        duration = content["session_duration"]
        print duration
        if udid is not None and pid is not None and duration is not None:
            DatabaseHelper().kkb_update(udid, pid, duration)
        return content



if __name__ == "__main__":
    app.run(debug=True)