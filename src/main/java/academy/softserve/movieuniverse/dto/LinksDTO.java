package academy.softserve.movieuniverse.dto;

import academy.softserve.movieuniverse.entity.Links;

public class LinksDTO {
    private Long id;
    private String linkName;
    private Links.SocialNetworkingSites socialNetworkingSite;

    private Long created;
    private Long updated;
    private String self;
    private String star;

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

    public Links.SocialNetworkingSites getSocialNetworkingSite() {
        return socialNetworkingSite;
    }

    public void setSocialNetworkingSite(Links.SocialNetworkingSites socialNetworkingSite) {
        this.socialNetworkingSite = socialNetworkingSite;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
