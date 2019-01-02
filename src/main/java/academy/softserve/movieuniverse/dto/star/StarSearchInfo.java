package academy.softserve.movieuniverse.dto.star;

public interface StarSearchInfo {
    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Long getBirthday();

    void setBirthday(Long birthday);

    String getProfessions();

    void setProfessions(String professions);

    String getAvatar();

    void setAvatar(String avatar);

    String getBiography();

    void setBiography(String biography);

    String getSelf();

    void setSelf(String self);
}
