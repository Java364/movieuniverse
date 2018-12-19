package academy.softserve.movieuniverse.dto.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO extends ResourceSupport implements UserShortInfo, UserCreateInfo, UserFullInfo, UserLoginInfo {
    private Long userId;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private Long birthday;
    private LocalDateTime entryCreationDate;
    private LocalDateTime entryLastUpdate;
    private Boolean isRemoved;

    public UserDTO() {
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

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
    public LocalDateTime getEntryCreationDate() {
        return entryCreationDate;
    }

    @Override
    public void setEntryCreationDate(LocalDateTime entryCreationDate) {
        this.entryCreationDate = entryCreationDate;
    }

    @Override
    public LocalDateTime getEntryLastUpdate() {
        return entryLastUpdate;
    }

    public void setEntryLastUpdate(LocalDateTime entryLastUpdate) {
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


}
