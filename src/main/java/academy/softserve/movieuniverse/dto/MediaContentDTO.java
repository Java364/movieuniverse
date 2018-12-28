package academy.softserve.movieuniverse.dto;

import java.util.ArrayList;
import java.util.List;

public class MediaContentDTO {
    private PosterDTO posterDTO;
    private List<Long> trailer = new ArrayList<Long>();
    private Long galleryId;

    public PosterDTO getPosterDTO() {
        return posterDTO;
    }

    public void setPosterDTO(PosterDTO posterDTO) {
        // this.posterDTO = posterDTO;
    }

    public List<Long> getTrailer() {
        return trailer;
    }

    public void setTrailer(List<Long> trailer) {
        this.trailer = trailer;
    }

    public Long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    }
}
