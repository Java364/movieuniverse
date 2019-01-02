package academy.softserve.movieuniverse.dto.castcrew;

import academy.softserve.movieuniverse.dto.ProfessionDTO;

public class CrewDTO extends Credit {
    private ProfessionDTO professionDTO;

    public ProfessionDTO getProfessionDTO() {
        return professionDTO;
    }

    public void setProfessionDTO(ProfessionDTO professionDTO) {
        this.professionDTO = professionDTO;
    }
}
