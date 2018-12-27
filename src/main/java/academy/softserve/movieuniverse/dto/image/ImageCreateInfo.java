package academy.softserve.movieuniverse.dto.image;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = ImageDTO.class)
public interface ImageCreateInfo {

    String getName();

    void setName(String name);

    String getImageUrl();

    void setImageUrl(String imageUrl);
}
