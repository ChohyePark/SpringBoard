package kh.spring.repositories;



import org.jasypt.util.password.PasswordEncryptor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {

	
//	@Autowired
//	private JdbcTemplate jdbc;
	
	@Autowired
	private SqlSessionTemplate mybatis;
	

	
	public int insert(MemberDTO dto) {
		return mybatis.insert("Members.insert",dto);
	}
	
	public int update (MemberDTO dto) {
		return mybatis.update("Members.update",dto);
	}
		
	
//	public boolean isId (String id) {
//		String sql = "select count (*) from member where id = ?";
//		return jdbc.queryForObject(sql,boolean.class,id);
//	}
//	
//	
//	public MemberDTO selectById (String id, String pw) {
//		String sql = "select pw from member where id = ? ";
//		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),id);
//	}
//	
//	public MemberDTO selectById (String id) {
//		String sql = "select seq,id,name,contact,email,zipcode,address1,address2 from member where id = ? ";
//		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),id);
//	}

}
