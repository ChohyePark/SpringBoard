package kh.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.repositories.BoardDAO;
import kh.spring.repositories.FilesDAO;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private FilesDAO filesDAO;
	
	@RequestMapping("write") 
	public String write () {
		return "board/writeForm";
	}
	
	
	@RequestMapping("insert")
	public String insert (BoardDTO dto,MultipartFile[] files) throws Exception{
		String realPath = session.getServletContext().getRealPath("upload");
		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
			realPathFile.mkdir();
		if (files != null) {
			for (MultipartFile file : files) {
				if (file.isEmpty()) {
					break;
				}
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID() + "_" + oriName;
				file.transferTo(new File(realPath + "/" + sysName));
					filesDAO.insert(oriName,sysName);
			}
		}
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
