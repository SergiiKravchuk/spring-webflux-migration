package victor.training.spring.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import victor.training.spring.sql.Post;
import victor.training.spring.sql.PostRepo;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GetAllPosts { // #2
  private final PostRepo postRepo;

  public record GetPostsResponse(String id, String title) {
    GetPostsResponse(Post post) {
      this(post.getId(), post.getTitle());
    }
  }
  @GetMapping("posts")
  public List<GetPostsResponse> getAllPosts() {
    return postRepo.findAll().stream().map(GetPostsResponse::new).toList();
  }
}
