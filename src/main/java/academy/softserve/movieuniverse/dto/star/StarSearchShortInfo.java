package academy.softserve.movieuniverse.dto.star;

public interface StarSearchShortInfo {
    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Long getBirthday();

    void setBirthday(Long birthday);
}
