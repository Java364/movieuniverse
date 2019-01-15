package academy.softserve.movieuniverse.dto.star;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = StarDTO.class)
public interface StarCreateInfo {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Long getBirthday();

    void setBirthday(Long birthday);

    String getBiography();

    void setBiography(String biography);

    Double getGrowth();

    void setGrowth(Double growth);

    String getCityOfBirth();

    void setCityOfBirth(String cityOfBirth);
}
