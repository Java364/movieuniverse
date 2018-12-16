package academy.softserve.movieuniverse.dto.user;

public interface UserShortInfoWithPassword {
    Long getId();

    void setId(Long id);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getConfirmPassword();

    void setConfirmPassword(String confirmPassword);

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Long getBirthday();

    void setBirthday(Long birthday);
}
