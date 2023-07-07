package a.b.c.com.kos.mem.dao;

import java.util.List;
import java.util.Map;

import a.b.c.com.common.CommandMap;

public interface KosMemberMapDAO {
	
	 List<Map<String, Object>>  kosMemberMapSelectAll(Map<String, Object> param);
}
