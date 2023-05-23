package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.repositories.BoardDAO;

@Controller
public class TestController {

	@Autowired
	private BoardDAO dao;

	@RequestMapping("/test")
	public String test(Model model) {
		List<BoardDTO> boards = dao.selectAll();
		model.addAttribute("boards",boards);
		return "board/test";
	}

}
