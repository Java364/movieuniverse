package academy.softserve.movieuniverse.dto.user;

import academy.softserve.movieuniverse.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO implements UserShortInfo, UserCreateInfo, UserFullInfo {
    private Long id;
    private String email;
    private String password;
    /* private String confirmPassword; */
    private String firstName;
    private String lastName;
    private Role role;
    private Long birthday;
    private Long entryCreationDate;
    private Long entryLastUpdate;
    private Boolean isRemoved;
    private String self;
    private String users;
    private String comments;
    private String movieMarks;

    public UserDTO() {
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * public String getConfirmPassword() { return confirmPassword; }
     * 
     * 
     * public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Long getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @Override
    public Long getEntryCreationDate() {
        return entryCreationDate;
    }

    @Override
    public void setEntryCreationDate(Long entryCreationDate) {
        this.entryCreationDate = entryCreationDate;
    }

    @Override
    public Long getEntryLastUpdate() {
        return entryLastUpdate;
    }

    @Override
    public void setEntryLastUpdate(Long entryLastUpdate) {
        this.entryLastUpdate = entryLastUpdate;
    }

    @Override
    public Boolean getRemoved() {
        return isRemoved;
    }

    @Override
    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMovieMarks() {
        return movieMarks;
    }

    public void setMovieMarks(String movieMarks) {
        this.movieMarks = movieMarks;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\''
                + ", confirmPassword='" + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", birthday=" + birthday + ", entryCreationDate=" + entryCreationDate + ", entryLastUpdate="
                + entryLastUpdate + ", isRemoved=" + isRemoved + ", self='" + self + '\'' + ", users='" + users + '\''
                + ", comments='" + comments + '\'' + ", movieMarks='" + movieMarks + '\'' + '}';
    }
}
