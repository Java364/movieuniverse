package academy.softserve.movieuniverse.dto;

import java.util.Objects;

public class UserProfileDTO {
    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private long birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDTO that = (UserProfileDTO) o;
        return birthday == that.birthday &&
                Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, lastName, firstName, birthday);
    }

    @Override
    public String toString() {
        return "UserProfileDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
