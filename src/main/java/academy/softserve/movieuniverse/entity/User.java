package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends Person {

    @Size(max = 25, message = "Email size < 25")
    /*@Email*/
    @Column(name = "email", unique = true, length = 25)
    private String email;

    @Size(max = 60, message = "Password size < 60")
    @Column(name = "password", length = 60)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "commentator", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MovieMark> movieMarks = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        super();
    }

    public List<MovieMark> getMovieMarks() {
        return movieMarks;
    }

    public void setMovieMarks(List<MovieMark> movieMarks) {
        this.movieMarks = movieMarks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        String[] split = this.email.split("@");
        return split[0];
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password)
                && Objects.equals(comments, user.comments) && Objects.equals(movieMarks, user.movieMarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, comments, movieMarks);
    }

    @Override
    public String toString() {
        return "User{" + "email='" + email + '\'' + ", password='" + password + '\'' + ", comments=" + comments
                + ", movieMarks=" + movieMarks + '}';
    }
}
