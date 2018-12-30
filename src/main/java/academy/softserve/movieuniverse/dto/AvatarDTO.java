package academy.softserve.movieuniverse.dto;

public class AvatarDTO {
	private Long id;
    private Long created;
    private Long updated;
    private String self;
    private String image;
    private String name;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public Long getUpdated() {
		return updated;
	}
	public void setUpdated(Long updated) {
		this.updated = updated;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
