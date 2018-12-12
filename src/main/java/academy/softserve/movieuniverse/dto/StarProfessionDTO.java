package academy.softserve.movieuniverse.dto;

public class StarProfessionDTO {

    private long id;
    private long starProfessionId;
    private long starId;

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
}
