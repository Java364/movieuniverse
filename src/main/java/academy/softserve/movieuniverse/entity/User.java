package academy.softserve.movieuniverse.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends Person {
    private String email;
    private String password;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<UserReview> userReviews = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    public User setUserReviews(List<UserReview> userReviews) {
        this.userReviews = userReviews;
        return this;
    }
}
