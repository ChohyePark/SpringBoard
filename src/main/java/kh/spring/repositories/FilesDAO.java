package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.FilesDTO;

@Repository
public class FilesDAO {
	
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public int insert (FilesDTO dto) {
		return mybatis.insert("Files.insert",dto);
	}

	public List<FilesDTO> selectById (Long id) {
		return mybatis.selectList("Files.selectById",id);
	}
	

}
