package academy.softserve.movieuniverse.dto.castcrew;

import academy.softserve.movieuniverse.dto.star.CreditDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CastDTO {
    @JsonProperty("star")
    private CreditDTO creditDTO;
    private String character;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
