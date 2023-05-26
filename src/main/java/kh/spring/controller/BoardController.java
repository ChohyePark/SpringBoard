package kh.spring.controller;

import java.io.File;
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
import kh.spring.services.BoardService;
import kh.spring.services.FileService;

@Controller
@RequestMapping("/board/")
public class BoardController {


	@Autowired
	private HttpSession session;
	
	@Autowired 
	private BoardService boardService;
		
	@Autowired
	private FileService fileService;


	
	
	@RequestMapping("write") 
	public String write () {
		return "board/writeForm";
	}
	
	
	@RequestMapping("insert")
	public String insert (BoardDTO dto,MultipartFile[] files) throws Exception{
		Long parent_seq = boardService.insert(dto);
		String realPath = session.getServletContext().getRealPath("upload");
		fileService.insert(realPath,files,parent_seq);	
		return "redirect:list";
	}
	
	
	
	@RequestMapping("delete")
	public String delete (Long id) {
		boardService.delete(id);
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
		boardService.update(dto);	
		return "redirect:list";
	}
	
	
	@RequestMapping("list")
	public String list (Model model) {
		List<BoardDTO> list = boardService.selectAll();
		model.addAttribute("boards",list);
		return "board/listForm";	
	}
	
	@RequestMapping("view")
	public String view (Long id,Model model) {
		List<FilesDTO> files = fileService.selectById(id);
		BoardDTO dto = boardService.selectById(id);
		model.addAttribute("files",files);
		model.addAttribute("dto",dto);
		return "board/viewForm";
	} 
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler (Exception e) {
		e.printStackTrace();
		return "redirect:/";	
	}
	
	
}
