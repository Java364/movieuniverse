package academy.softserve.movieuniverse.dto;


public class ProfessionDTO {
    private Long id;
    private String professionType;

    public ProfessionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessionType() {
        return professionType;
    }

    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }
}
