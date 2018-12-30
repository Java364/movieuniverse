package academy.softserve.movieuniverse.entity;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Links extends AbstractEntity {

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "socialNetwork")
    @Enumerated(EnumType.STRING)
    private SocialNetworkingSites socialNetworkingSite;

    @ManyToOne /* (cascade = CascadeType.ALL) */
    @JoinColumn(name = "star_id")
    private Star star;

    public Links() {
    }

    public Links(String linkName, SocialNetworkingSites socialNetworkingSite, Star star) {
        this.linkName = linkName;
        this.socialNetworkingSite = socialNetworkingSite;
        this.star = star;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public SocialNetworkingSites getSocialNetworkingSite() {
        return socialNetworkingSite;
    }

    public void setSocialNetworkingSite(SocialNetworkingSites socialNetworkingSite) {
        this.socialNetworkingSite = socialNetworkingSite;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public enum SocialNetworkingSites {
        FACEBOOK, INSTAGRAM, TWITTER

    }
}
