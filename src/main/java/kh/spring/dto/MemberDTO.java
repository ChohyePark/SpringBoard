package kh.spring.dto;

public class MemberDTO {

	private Long seq ;
	private String id;
	private String pw;
	private String name;
	private String contact;
	private String email;
	private String zipcode;
	private String address1;
	private String address2;
	
	
	public MemberDTO() {}

	
	public MemberDTO(Long seq, String id, String pw, String name, String contact, String email, String zipcode,
			String address1, String address2) {
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}



	public Long getSeq() {
		return seq;
	}


	public void setSeq(Long seq) {
		this.seq = seq;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	

	
}
