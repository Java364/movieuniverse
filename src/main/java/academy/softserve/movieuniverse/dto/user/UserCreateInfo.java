package academy.softserve.movieuniverse.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserDTO.class)
public interface UserCreateInfo {

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    /*String getConfirmPassword();

    void setConfirmPassword(String confirmPassword);*/

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);


}
