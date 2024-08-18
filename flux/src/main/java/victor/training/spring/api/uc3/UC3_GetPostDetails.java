package victor.training.spring.api.uc3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import victor.training.spring.api.uc3.UC3_GetPostDetails.GetPostDetailsResponse.CommentResponse;
import victor.training.spring.sql.Comment;
import victor.training.spring.sql.Post;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC3_GetPostDetails {
  //In the Web part this was a Hibernate repo which doesn't support reactive style (because of its nature).
  //So in order to use SQL-DB in a reactive application, you need to use a reactive api for example `org.springframework.data.r2dbc.repository.R2dbcRepository`
  // For sake of simplicity an instance of such repo is already added, see `victor.training.spring.sql` package and import the corresponding repo here.

  //TODO: see `victor.training.spring.sql` package and import the corresponding repos here
  // Pay attention to what interface is used there
//  private final PostRepo postRepo;
//  private final CommentRepo commentRepo;

  public record GetPostDetailsResponse(long id, String title, String body, List<CommentResponse> comments) {
    GetPostDetailsResponse(Post post, List<CommentResponse> comments) {
      this(post.id(), post.title(), post.body(), comments);
    }

    public record CommentResponse(String text, String name) {
      CommentResponse(Comment comment) {
        this(comment.comment(), comment.name());
      }
    }
  }

  /* TODO: migrate the part below
  @GetMapping("posts/{postId}")
  public GetPostDetailsResponse getPostDetails(@PathVariable long postId) {
    Post post = postRepo.findById(postId).orElseThrow();
    List<CommentResponse> comments = commentRepo.findByPostId(postId).stream()
        .map(CommentResponse::new)
        .toList();
    return new GetPostDetailsResponse(post, comments);
  }
  */

}
