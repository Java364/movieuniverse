package academy.softserve.movieuniverse.dto.star;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = StarDTO.class)
public interface CreditDTO {
    Long getId();

    String getFirstName();

    String getLastName();

    void setId(Long id);

    void setFirstName(String firstName);

    void setLastName(String lastName);
}