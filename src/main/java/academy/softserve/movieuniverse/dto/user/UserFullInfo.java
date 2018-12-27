package academy.softserve.movieuniverse.dto.user;

import java.time.LocalDateTime;

public interface UserFullInfo {

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Long getBirthday();

    void setBirthday(Long birthday);

    Long getEntryCreationDate();

    void setEntryCreationDate(Long entryCreationDate);

    Long getEntryLastUpdate();

    void setEntryLastUpdate(Long entryLastUpdate);

    Boolean getRemoved();

    void setRemoved(Boolean removed);

}
