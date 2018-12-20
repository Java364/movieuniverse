package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.util.ControllerHateoasUtil;
import academy.softserve.movieuniverse.dto.userreview.UserReviewDTO;
import academy.softserve.movieuniverse.dto.userreview.UserReviewRequest;
import academy.softserve.movieuniverse.entity.UserReview;
import academy.softserve.movieuniverse.service.UserReviewService;
import academy.softserve.movieuniverse.service.mapper.UserReviewDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user-review")
public class  UserReviewController {
    private UserReviewService userReviewService;
    private UserReviewDtoMapper userReviewDtoMapper;

    public UserReviewController(UserReviewService userReviewService, UserReviewDtoMapper userReviewDtoMapper) {
        this.userReviewService = userReviewService;
        this.userReviewDtoMapper = userReviewDtoMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserReviewDTO> createUserReview(@RequestBody UserReviewRequest userReviewRequest) {
        UserReview userReview = userReviewDtoMapper.mapToEntity(userReviewRequest);
        userReviewService.saveUserReview(userReview);
        UserReviewDTO userReviewDTO = userReviewDtoMapper.mapToDTO(userReview);
        return ResponseEntity.created(ControllerHateoasUtil.createLocationHeaderUri(userReviewDTO)).body(userReviewDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReviewDTO> updateUserReview(@PathVariable("id") Long userReviewId,
                                                          @RequestBody UserReviewRequest userReviewRequest) {
        UserReview userReview = userReviewDtoMapper.mapToEntity(userReviewRequest);
        UserReview updatedUser = userReviewService.updateUserReview(userReviewId, userReview);
        UserReviewDTO userReviewDTO = userReviewDtoMapper.mapToDTO(updatedUser);
        return ResponseEntity.created(ControllerHateoasUtil.createLocationHeaderUri(userReviewDTO)).body(userReviewDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserReview(@PathVariable("id") Long userReviewId) {
        userReviewService.deleteUserReviewById(userReviewId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public List<UserReviewDTO> findAllByUserId(@PathVariable Long id){
        return  userReviewDtoMapper.mapToDtoList(userReviewService.findAllByUser(id));
    }
}
