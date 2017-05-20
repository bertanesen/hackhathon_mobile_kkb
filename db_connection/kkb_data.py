import MySQLdb
import datetime
import json

class DatabaseHelper(object):


    def db_config(self,db_name):
        db_host = "mobile-staging.cwxvzubmfq3d.eu-west-1.rds.amazonaws.com"
        db = MySQLdb.connect(db_host, "root", "mobilestaging123", db_name)
        return db

    def kkb_setter(self, udid, product_id):
        try:
            sql = "INSERT INTO `kkb_data` (`udid`, `product_id`) VALUES " \
                  "('{udid}', '{pid}') ".format(udid=udid, pid= product_id)
            db = self.db_config("mydb")
            cursor = db.cursor()
            cursor.execute(sql)
            db.commit()
        except RuntimeError:
            print "Set Error"

    def kkb_getter(self, product_id):
        try:
            sql = "SELECT * from kkb_data where product_id = '{prod_id}' and  is_active=1".format(prod_id=product_id)
            db = self.db_config("mydb")
            cursor = db.cursor()
            cursor.execute(sql)
            row = cursor.rowcount
            if int(row) == 0:
                return json.dumps({'Error' : 'No user Found'})
            return int(row)
        except RuntimeError:
            print "Get Error"

    def kkb_update(self, udid, product_id, session_duration):
        try:
            time =datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')

            sql = "UPDATE `kkb_data` SET `session_duration` = {session_d}, is_active = 0, updated_date = '{updated}' " \
                  "where udid= '{udid}' and " \
                  "product_id = '{product_id}'".format(session_d = session_duration,
                                                     updated = time,
                                                     udid = udid,
                                                     product_id = product_id)
            print sql
            db = self.db_config("mydb")
            cursor = db.cursor()
            cursor.execute(sql)
            db.commit()
        except RuntimeError:
            print "Error"









