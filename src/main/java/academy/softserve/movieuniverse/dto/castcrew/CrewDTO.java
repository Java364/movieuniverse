package academy.softserve.movieuniverse.dto.castcrew;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CrewDTO extends Credit {
    @JsonProperty("profession")
    private ProfessionDTO professionDTO;

    public ProfessionDTO getProfessionDTO() {
        return professionDTO;
    }

    public void setProfessionDTO(ProfessionDTO professionDTO) {
        this.professionDTO = professionDTO;
    }
}
