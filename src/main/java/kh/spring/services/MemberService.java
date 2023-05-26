package kh.spring.services;

import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dto.MemberDTO;
import kh.spring.repositories.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private PasswordEncryptor encryptor;
	
	
	public void insert(MemberDTO dto) {
		String pw = encryptor.encryptPassword(dto.getPw());
		dto.setPw(pw);
		memberDAO.insert(dto);
	}


	public void update(MemberDTO dto) {
		memberDAO.update(dto);
	}


	public boolean isId(String id) {
		return memberDAO.isId(id);
	}


	public MemberDTO selectById(String loginID) {
		return memberDAO.selectById(loginID);
	}

	public boolean login (String id, String pw) {
		MemberDTO dto = memberDAO.selectById(id);
		boolean result = encryptor.checkPassword(pw, dto.getPw());
		return result;
	}
	
	
	
	
}
