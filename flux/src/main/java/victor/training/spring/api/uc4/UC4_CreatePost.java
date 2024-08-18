package victor.training.spring.api.uc4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import victor.training.spring.sql.Comment;
import victor.training.spring.sql.Post;

import static java.time.LocalDateTime.now;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC4_CreatePost {
  //In the Web part this was a Hibernate repo which doesn't support reactive style (because of its nature).
  //So in order to use SQL-DB in a reactive application, you need to use a reactive api for example `org.springframework.data.r2dbc.repository.R2dbcRepository`
  // For sake of simplicity an instance of such repo is already added, see `victor.training.spring.sql` package and import the corresponding repo here.

  //TODO: see `victor.training.spring.sql` package and import the corresponding repos here
  // Pay attention to what interface is used there
//  private final PostRepo postRepo;
//  private final CommentRepo commentRepo;

  public record CreatePostRequest(String title, String body, Long authorId) {
    Post toPost() {
      return new Post().title(title).body(body).authorId(authorId);
    }
  }

  /* TODO: migrate the part below
  @PostMapping("posts")
  @PreAuthorize("isAuthenticated()")
  @Transactional
  public void createPost(@RequestBody CreatePostRequest request) {
    Post post = postRepo.save(request.toPost());
    commentRepo.save(createInitialComment(post.id(), request.title()));
    sendPostCreatedEvent("Post created: " + post.id());
  }

  private static Comment createInitialComment(long postId, String postTitle) {
    String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
    return new Comment(postId, "Posted on " + now() + ": " + postTitle, loggedInUser);
  }

  private final RabbitTemplate rabbitTemplate;
  private void sendPostCreatedEvent(String message) {
    log.info("Sending message: " + message);
    rabbitTemplate.convertAndSend("post-created-event", message);
  }
   */
}
