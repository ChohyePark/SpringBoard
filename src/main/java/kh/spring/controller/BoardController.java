package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.repositories.BoardDAO;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardDAO dao;
	
	
	@RequestMapping("write") 
	public String write () {
		return "board/writeForm";
	}
	
	
	@RequestMapping("insert")
	public String insert (BoardDTO dto) {
		dao.insert(dto);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete (Long id) {
		dao.delete(id);
		return "redirect:list";
	}
	
	
	@RequestMapping("modify")
	public String modify (Long id, String writer,Model model) {
		model.addAttribute("id",id);
		model.addAttribute("writer",writer);
		return "board/modifyForm";
	}
	
	
	@RequestMapping("update")
	public String update (BoardDTO dto) {
		System.out.println(dto.getTitle());
		System.out.println(dto.getSeq());
		dao.update(dto);	
		return "redirect:list";
	}
	
	
	@RequestMapping("list")
	public String list (Model model) {
		List<BoardDTO> list = dao.selectAll();
		model.addAttribute("boards",list);
		return "board/listForm";	
	}
	
	@RequestMapping("view")
	public String view (Long id,Model model) {
		BoardDTO dto = dao.selectById(id);
		model.addAttribute("dto",dto);
		return "board/viewForm";
	} 
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler (Exception e) {
		e.printStackTrace();
		return "redirect:/";	
	}
	
	
}
