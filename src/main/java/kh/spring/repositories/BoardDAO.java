package kh.spring.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	
	
	public int insert (BoardDTO dto) {
		String sql = "insert into board values(board_seq.nextval,?,?,?,0,sysdate)";
		return jdbc.update(sql,dto.getWriter(),dto.getTitle(),dto.getContents());	
	}
	
	public int delete (Long id) {
		String sql = "delete from board where seq = ?";
		return jdbc.update(sql,id);
	}
	
	public int update (BoardDTO dto) {
		String sql = "update board set title = ? , contents = ? where seq = ?";
		return jdbc.update(sql, dto.getTitle(), dto.getContents(), dto.getSeq());
	}
	
	public List<BoardDTO> selectAll () {
		String sql = "select * from board";
		return jdbc.query(sql,new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	public BoardDTO selectById (Long id) {
		String sql = "select * from board where seq = ?";
		return jdbc.queryForObject(sql,new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class),id);	
	}

	
	
	
}
