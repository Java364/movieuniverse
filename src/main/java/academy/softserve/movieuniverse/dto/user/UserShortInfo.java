package academy.softserve.movieuniverse.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserDTO.class)
public interface UserShortInfo {

    String getEmail();

    void setEmail(String email);

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    String getPassword();

    void setPassword(String password);


}
