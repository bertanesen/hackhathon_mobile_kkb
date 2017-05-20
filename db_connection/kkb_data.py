import MySQLdb

class DatabaseHelper(object):


    def db_config(self,db_name):
        db_host = "mobile-staging.cwxvzubmfq3d.eu-west-1.rds.amazonaws.com"
        db = MySQLdb.connect(db_host, "root", "mobilestaging123", db_name)
        cursor = db.cursor()
        return  cursor

    def sql_executer(self,sql):
        cur =self.db_config("mydb")
        cur.execute(sql)
        return cur.fetchAll()

    def kkb_getter(self,product_id):
        sql = ""
        data = self.sql_executer(sql)

    def kkb_setter(self, udid, product_id):
        sql = ""
        data = self.sql_executer(sql)









