package kh.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dto.BoardDTO;
import kh.spring.repositories.BoardDAO;

@Service
public class BoardService {

	@Autowired 
	private BoardDAO boardDAO;
	
	
	public Long insert(BoardDTO dto) {
		return boardDAO.insert(dto);
	}


	public void delete(Long id) {
		boardDAO.delete(id);	
	}


	public void update(BoardDTO dto) {
		boardDAO.update(dto);	
	}


	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}


	public BoardDTO selectById(Long id) {
		return boardDAO.selectById(id);
	}
	
	
}
