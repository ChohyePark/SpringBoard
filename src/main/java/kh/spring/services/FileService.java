package kh.spring.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.FilesDTO;
import kh.spring.repositories.FilesDAO;

@Service
public class FileService {


	
	@Autowired
	private FilesDAO filesDAO;

	public List<FilesDTO> selectById(Long id) {
		return filesDAO.selectById(id);
	}
	
	public void insert(String realPath, MultipartFile[] files, Long parent_seq) throws Exception {
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
				filesDAO.insert(new FilesDTO(parent_seq, 0, oriName, sysName));
			}
		}
	}
}