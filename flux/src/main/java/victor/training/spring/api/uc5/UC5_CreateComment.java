package victor.training.spring.api.uc5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import victor.training.spring.sql.Comment;
import victor.training.spring.sql.Post;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC5_CreateComment {
  //In the Web part this was a Hibernate repo which doesn't support reactive style (because of its nature).
  //So in order to use SQL-DB in a reactive application, you need to use a reactive api for example `org.springframework.data.r2dbc.repository.R2dbcRepository`
  // For sake of simplicity an instance of such repo is already added, see `victor.training.spring.sql` package and import the corresponding repo here.

  //TODO: see `victor.training.spring.sql` package and import the corresponding repos here
//  private final PostRepo postRepo;
//  private final CommentRepo commentRepo;

//  private final RestTemplate restTemplate;

  public record CreateCommentRequest(String comment, String name) {
  }

  /* TODO: migrate the part below
  @PostMapping("posts/{postId}/comments")
  public void createComment(@PathVariable long postId, @RequestBody CreateCommentRequest request) {
    Post post = postRepo.findById(postId).orElseThrow();
    boolean safe = isSafe(post.body(), request.comment());
    boolean unlocked = isUnlocked(post.authorId());
    if (safe && unlocked) {
      commentRepo.save(new Comment(post.id(), request.comment(), request.name()));
    } else {
      throw new IllegalArgumentException("Comment Rejected");
    }
  }

  private boolean isUnlocked(long authorId) {
    String url = "http://localhost:9999/author/" + authorId + "/comments";
    String result = restTemplate.getForObject(url, String.class);
    return Boolean.parseBoolean(result);
  }

  private boolean isSafe(String postBody, String comment) {
    record Request(String body, String comment) {
    }
    String url = "http://localhost:9999/safety-check";
    String result = restTemplate.postForObject(url, new Request(postBody, comment), String.class);
    return "OK".equals(result);
  }

   */
}
