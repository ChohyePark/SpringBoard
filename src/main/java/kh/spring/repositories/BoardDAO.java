package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public Long insert (BoardDTO dto) {
		mybatis.insert("Board.insert",dto);
		return dto.getSeq();
	}
	
	
	public void delete (Long id) {
		mybatis.delete("Board.delete",id);
	}
	
	
	public void update (BoardDTO dto) {
		mybatis.update("Board.update",dto);

	}
	
	public List<BoardDTO> selectAll () {
		return mybatis.selectList("Board.selectAll");
	}
	
	public BoardDTO selectById (Long id) {
		return mybatis.selectOne("Board.selectById",id);
	}

	
	
	
}
