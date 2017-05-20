import redis
from modules import *
class RedisHelper(object):

    def redis_init(self):
        return redis.StrictRedis(host='localhost', port=6379, db=0)

    def redis_counter(self,product_id):
        year = datetime.datetime.now().strftime('%Y')
        month = datetime.datetime.now().strftime('%m')
        day = datetime.datetime.now().strftime('%d')
        key = "{}-{}_{}_{}".format(product_id, year, month, day)
        self.redis_init().incr(key)