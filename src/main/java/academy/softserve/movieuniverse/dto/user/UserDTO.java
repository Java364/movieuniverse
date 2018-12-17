package academy.softserve.movieuniverse.dto.user;


import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.dto.UserReviewDto;

import java.util.List;

public class UserDTO implements UserShortInfo, UserShortInfoWithPassword, UserFullInfo, UserLoginInfo{
    private Long id;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private Long birthday;
    private Long entryCreationDate;
    private Long entryLastUpdate;
    private Boolean isRemoved;

    public UserDTO() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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


}
