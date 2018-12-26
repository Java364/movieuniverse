package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.util.ControllerHateoasUtil;
import academy.softserve.movieuniverse.dto.comment.CommentDTO;
import academy.softserve.movieuniverse.dto.comment.CommentRequest;
import academy.softserve.movieuniverse.entity.Comment;
import academy.softserve.movieuniverse.service.CommentService;

import academy.softserve.movieuniverse.service.mapper.CommentMapper;

import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comment")

public class CommentController {
    private CommentService commentService;
    private CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> showById(@PathVariable Long id){
      return ResponseEntity.status(HttpStatus.OK)
              .body(commentMapper.mapToDTO(commentService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> showAll() {
        List<Comment> comments = commentService.findAll();
        List<CommentDTO> commentDTOS = commentMapper.mapToDTOList(comments);
        return ResponseEntity.status(HttpStatus.OK).body(commentDTOS);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.mapToEntity(commentRequest);
        commentService.save(comment);
        CommentDTO commentDTO = commentMapper.mapToDTO(comment);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable("id") Long commentId,
                                                          @RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.mapToEntity(commentRequest);
        Comment updatedUser = commentService.update(commentId, comment);
        CommentDTO commentDTO = commentMapper.mapToDTO(updatedUser);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long commentId) {
        commentService.deleteById(commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public List<CommentDTO> findAllByUserId(@PathVariable Long id){
        return  commentMapper.mapToDTOList(commentService.findAllByUser(id));
    }
}
