package academy.softserve.movieuniverse.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserDTO.class)
public interface UserShortInfo {

    Long getId();

    void setId(Long id);

    String getEmail();

    void setEmail(String email);

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Long getBirthday();

    void setBirthday(Long birthday);
}
