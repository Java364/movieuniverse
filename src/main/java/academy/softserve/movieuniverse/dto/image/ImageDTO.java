package academy.softserve.movieuniverse.dto.image;

import org.springframework.hateoas.ResourceSupport;

public class ImageDTO extends ResourceSupport implements ImageCreateInfo{


    private String name;
    private String imageUrl;

    public ImageDTO() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
