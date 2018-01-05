package Live.dao;

import org.springframework.stereotype.Repository;

import Live.model.UserRedis;

@Repository
public class UserRedisDao extends IRedisDao<UserRedis> {
	
	private static final String REDIS_KEY = "liveDemo.model.UserRedis";

	@SuppressWarnings("static-access")
	@Override
	protected String getRedisKey() {
		return this.REDIS_KEY;
	}

}
