import MySQLdb

class DatabaseHelper(object):


    def db_config(self,db_name):
        db_host = "mobile-staging.cwxvzubmfq3d.eu-west-1.rds.amazonaws.com"
        db = MySQLdb.connect(db_host, "root", "mobilestaging123", db_name)
        return db

    # def sql_executer(self,sql):
    #     cur =self.db_config("mydb")
    #     cur.execute(sql)
    #     return cur.fetchall()
    #
    # def kkb_getter(self,product_id):
    #     sql = "select count(*) as total from kkb_data where is_active = 1"
    #     self.sql_executer(sql)

    def kkb_setter(self, udid, product_id):
        try:
            sql = "INSERT INTO `kkb_data` (`udid`, `product_id`) VALUES " \
                  "('{udid}', '{pid}') ".format(udid=udid, pid= product_id)
            db = self.db_config("mydb")
            print sql
            cursor = db.cursor()
            cursor.execute(sql)
            db.commit()
        except RuntimeError:
            print "Error"










