package academy.softserve.movieuniverse.dto.star;

public interface CreditDTO {
    Long getId();

    String getFirstName();

    String getLastName();

    void setId(Long id);

    void setFirstName(String firstName);

    void setLastName(String lastName);
}
