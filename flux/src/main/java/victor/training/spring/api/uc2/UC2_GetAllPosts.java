package victor.training.spring.api.uc2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import victor.training.spring.sql.Post;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC2_GetAllPosts {
  //In the Web part this was a Hibernate repo which doesn't support reactive style (because of its nature).
  //So in order to use SQL-DB in a reactive application, you need to use a reactive api for example `org.springframework.data.r2dbc.repository.R2dbcRepository`
  // For sake of simplicity an instance of such repo is already added, see `victor.training.spring.sql` package and import the corresponding repo here.

  //TODO: see `victor.training.spring.sql` package and import the corresponding repo here
  // Pay attention to what interface is used there
//  private final PostRepo postRepo;

  /* TODO: migrate the part below
  public record GetPostsResponse(long id, String title) {
    GetPostsResponse(Post post) {
      this(post.id(), post.title());
    }
  }
  @GetMapping("posts")
  public List<GetPostsResponse> getAllPosts() {
    return postRepo.findAll().stream().map(GetPostsResponse::new).toList();
  }
  */

}
