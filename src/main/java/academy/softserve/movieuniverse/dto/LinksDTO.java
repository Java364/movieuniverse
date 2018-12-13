package academy.softserve.movieuniverse.dto;


import academy.softserve.movieuniverse.entity.Star;

import java.util.Optional;

public class LinksDTO {
    private Long id;
    private String linkName;
    private String siteName;
    private Long starid;

    public LinksDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Long getStarid() {
        return starid;
    }

    public void setStarid(Long starid) {
        this.starid = starid;
    }
    /* public void setStarid(Optional<Star> starid) {
        this.starid = starid;
    }*/

    /*public void setStarid(Star star) {
    }*/
}
