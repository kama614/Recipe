package dto;

public class Recipe {

	private Integer id;
	private String name;
	private String detail;
	private String url;
	private String images;
	
	public Recipe(Integer id, String name, String detail, String url, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.url = url;
		this.images = photo;
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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	
}
