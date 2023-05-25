package kh.spring.repositories;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.FilesDTO;

@Repository
public class FilesDAO {
	
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public int insert (String oriName, String sysName) {
		Map<String, String> file = new HashMap();
		file.put("oriName", oriName);
		file.put("sysName", sysName);
		return mybatis.insert("Files.insert",file);
	}

	

}
