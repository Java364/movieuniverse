package academy.softserve.movieuniverse.dto.user;

import java.time.LocalDateTime;

public interface UserFullInfo {

    Long getUserId();

    void setUserId(Long id);

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

    LocalDateTime getEntryCreationDate();

    void setEntryCreationDate(LocalDateTime entryCreationDate);

    LocalDateTime getEntryLastUpdate();

    void setEntryLastUpdate(LocalDateTime entryLastUpdate);

    Boolean getRemoved();

    void setRemoved(Boolean removed);

}
