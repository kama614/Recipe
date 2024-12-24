package dto;

public class Recipe {

	private Integer id;
	private String name;
	private String detail;
	private String url;
	private String photo;
	
	public Recipe(Integer id, String name, String detail, String url, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.url = url;
		this.photo = photo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
