package academy.softserve.movieuniverse.dto;

public class StarProfessionDTO {

    private long id;
    private long starProfessionId;
    private long starId;
    private String starName;
    private String starProfession;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStarProfessionId() {
        return starProfessionId;
    }

    public void setStarProfessionId(long starProfessionId) {
        this.starProfessionId = starProfessionId;
    }

    public long getStarId() {
        return starId;
    }

    public void setStarId(long starId) {
        this.starId = starId;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getStarProfession() {
        return starProfession;
    }

    public void setStarProfession(String starProfession) {
        this.starProfession = starProfession;
    }
}
