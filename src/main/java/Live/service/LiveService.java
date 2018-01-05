package Live.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Live.dao.LiveRedisDao;
import Live.model.LiveRedis;

@Service
public class LiveService {
	
	@Autowired
	LiveRedisDao liveRedisDao;
	
	public List<LiveRedis> getAll() {
		return liveRedisDao.getAll();
	}
	
	public void save(LiveRedis live) {
		liveRedisDao.put(live.getKeyName(), live, -1);
	}

}
