package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "links")
public class Links extends AbstractEntity {

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "site_name")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star star;

    public Links() {
    }

    public Links(String linkName, String siteName, Star star) {
        super();
        this.linkName = linkName;
        this.siteName = siteName;
        this.star = star;
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

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }
}

