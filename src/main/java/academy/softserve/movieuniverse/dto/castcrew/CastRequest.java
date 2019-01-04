package academy.softserve.movieuniverse.dto.castcrew;

public class CastRequest {
    private Long starId;
    private String character;

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
