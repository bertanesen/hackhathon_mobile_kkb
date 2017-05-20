import redis
class RedisHelper(object):

    def redis_init(self):
        return redis.StrictRedis(host='localhost', port=6379, db=0)

    def redis_set_data(self,key,value):
        self.redis_init().set(key,value)

    def redis_get_data(self,key):
        self.redis_init().get(key)

    def redis_counter(self,product_id):
        self.redis_init().incr(product_id)
        print self.redis_get_data(product_id)