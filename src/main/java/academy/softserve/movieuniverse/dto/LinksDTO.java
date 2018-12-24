package academy.softserve.movieuniverse.dto;


import academy.softserve.movieuniverse.entity.Links;
import org.springframework.hateoas.ResourceSupport;

public class LinksDTO extends ResourceSupport {

    private String linkName;
    private Links.SocialNetworkingSites socialNetworkingSite;
    private Long starID;
    private Boolean isRemoved;

    public LinksDTO() {
    }


    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Links.SocialNetworkingSites getSocialNetworkingSite() {
        return socialNetworkingSite;
    }

    public void setSocialNetworkingSite(Links.SocialNetworkingSites socialNetworkingSite) {
        this.socialNetworkingSite = socialNetworkingSite;
    }

    public Long getStarID() {
        return starID;
    }

    public void setStarID(Long starID) {
        this.starID = starID;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
