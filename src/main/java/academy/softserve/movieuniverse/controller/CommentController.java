package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.dto.userreview.CommentRequest;
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
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;
    private CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping
    public ResponseEntity<Resources<CommentDTO>> showAll() {
        List<Comment> comments = commentService.findAll();
        List<CommentDTO> commentDTOS = commentMapper.mapToDTOList(comments);
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(commentDTOS));
    }

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.mapToEntity(commentRequest);
        commentService.save(comment);
        CommentDTO commentDTO = commentMapper.mapToDTO(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable("id") Long commentId,
            @RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.mapToEntity(commentRequest);
        Comment updatedUser = commentService.update(commentId, comment);
        CommentDTO commentDTO = commentMapper.mapToDTO(updatedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long commentId) {
        commentService.deleteById(commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public List<CommentDTO> findAllByUserId(@PathVariable Long id) {
        return commentMapper.mapToDTOList(commentService.findAllByUser(id));
    }
}
