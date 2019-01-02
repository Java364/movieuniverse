package academy.softserve.movieuniverse.dto.castcrew;

public class CastDTO {
    private Long starId;
    private String firstName;
    private String lastName;
    private String self;
    private String character;
    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
}
