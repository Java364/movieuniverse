package academy.softserve.movieuniverse.dto;

public class StarProfessionDTO {

    private long id;

    //    private StarDTO starDTO;
    private StarProfessionDTO professionDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StarProfessionDTO() {
    }

    public StarProfessionDTO getProfessionDTO() {
        return professionDTO;
    }

    public void setProfessionDTO(StarProfessionDTO professionDTO) {
        this.professionDTO = professionDTO;
    }
}
