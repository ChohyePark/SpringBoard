package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.MemberDTO;
import kh.spring.repositories.MemberDAO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	
		@Autowired
		private HttpSession session;
	
		@Autowired
		private MemberDAO dao;
	
		@Autowired
		private PasswordEncryptor encryptor;
		
		
		@RequestMapping("signup")
		public String singup() {
			return "member/signup";
		}
	
		@RequestMapping("joinProc")
		public String joinProc (MemberDTO dto) {
			String pw = encryptor.encryptPassword(dto.getPw());
			dto.setPw(pw);
			int result = dao.insert(dto);
			return "redirect:/";
		}
		
		
		@RequestMapping("update")
		public String update (MemberDTO dto) {
				dao.update(dto);
				return "member/memberInfo";
		}
		
//		
//		@ResponseBody 
//		@RequestMapping(value = "idCheck", produces = "text/html; charset = utf8")
//		public String idCheck(String id) {
//			boolean result = dao.isId(id);
//			return String.valueOf(result);
//		}
//	
//		@ResponseBody
//		@RequestMapping("login")
//		public String login (String id, String pw) {
//			MemberDTO dto = dao.selectById(id, pw);
//			System.out.println(dto.getContact());
//			boolean result = encryptor.checkPassword(pw, dto.getPw());
//			if (result) {
//				session.setAttribute("loginID", id);
//			} 
//			return String.valueOf(result);	
//		}
//		
		@RequestMapping("logout")
		public String logout () {
			session.invalidate();
			return "redirect:/";	
		}
//		
//		
//		@RequestMapping("memberInfo") 
//		public String memberInfo (String loginID, Model model) {
//			MemberDTO dto = dao.selectById(loginID);
//			model.addAttribute("dto", dto);
//			return "member/mypage";
//		}
//		
//		
//		
//		
//		@ExceptionHandler(Exception.class)
//		public String exceptionHandler (Exception e) {
//			e.printStackTrace();
//			return "redirect:/";	
//		}
//		
		
		
		
}
