package kh.spring.dto;

public class FilesDTO {

	private Long parent_id;
	private int id;
	private String oriName;
	private String sysName;
	
	
	public FilesDTO () {}

	

	public FilesDTO(Long parent_id, int id, String oriName, String sysName) {
		this.parent_id = parent_id;
		this.id = id;
		this.oriName = oriName;
		this.sysName = sysName;
	}



	public Long getParent_id() {
		return parent_id;
	}


	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOriName() {
		return oriName;
	}


	public void setOriName(String oriName) {
		this.oriName = oriName;
	}


	public String getSysName() {
		return sysName;
	}


	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	

	
	
}
