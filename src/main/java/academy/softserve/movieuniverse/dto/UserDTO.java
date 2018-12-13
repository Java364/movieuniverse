package academy.softserve.movieuniverse.dto;


import java.util.List;

public class UserDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private Long birthday;
    private Long entryCreationDate;
    private Long entryLastUpdate;
    private Boolean isRemoved;
    private List<UserReviewDto> userReviewDtoList;
    private List<MovieMarkDTO> movieMarkDTOList;
}
