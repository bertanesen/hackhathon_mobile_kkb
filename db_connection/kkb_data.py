from modules import *
from redis_helper import RedisHelper

class DatabaseHelper(object):


    def db_config(self,db_name):
        db_host = "mobile-staging.cwxvzubmfq3d.eu-west-1.rds.amazonaws.com"
        db = MySQLdb.connect(db_host, "root", "mobilestaging123", db_name)
        return db

    def kkb_setter(self, udid, product_id):
            sql = "INSERT INTO `kkb_data` (`udid`, `product_id`) VALUES " \
                  "('{udid}', '{pid}') ".format(udid=udid, pid= product_id)
            db = self.db_config("mydb")
            cursor = db.cursor()
            cursor.execute(sql)
            db.commit()
            RedisHelper().redis_counter(product_id)


    def kkb_getter(self, product_id,show_type):
            if show_type == 0:
                sql = "SELECT * from kkb_data where product_id = '{prod_id}' and  is_active=1".format(prod_id=product_id)
                db = self.db_config("mydb")
                cursor = db.cursor()
                cursor.execute(sql)
                row = cursor.rowcount
                if int(row) == 0:
                    return json.dumps({'Error' : 'No user Found'})
                return int(row)
            else:
                year = datetime.datetime.now().strftime('%Y')
                month = datetime.datetime.now().strftime('%m')
                day = datetime.datetime.now().strftime('%d')
                key = "{}-{}_{}_{}".format(product_id, year, month, day)
                return RedisHelper().redis_init().get(key)

    def kkb_update(self, udid, product_id, session_duration):
        try:
            time_now =datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')

            sql = "UPDATE `kkb_data` SET `session_duration` = {session_d}, is_active = 0, updated_date = '{updated}' " \
                  "where udid= '{udid}' and " \
                  "product_id = '{product_id}' order by id desc LIMIT 1".format(session_d = session_duration,
                                                     updated = time_now,
                                                     udid = udid,
                                                     product_id = product_id)
            db = self.db_config("mydb")
            cursor = db.cursor()
            cursor.execute(sql)
            db.commit()
        except:
            raise Exception("Update Function Error")









