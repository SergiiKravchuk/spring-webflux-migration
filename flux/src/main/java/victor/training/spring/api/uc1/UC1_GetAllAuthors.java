package victor.training.spring.api.uc1;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import victor.training.spring.mongo.Author;
import victor.training.spring.mongo.AuthorReactiveRepo;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC1_GetAllAuthors {
  private final AuthorReactiveRepo authorRepo; // MongoDB
//  private final ContactApi contactApi;    //TODO: just uncomment when you're done with migration of this class

  @PostConstruct
  public void insertInitialDataInMongo() {
    log.info("Insert in Mongo");
    //TODO: just uncomment when you're done with migration of this class
//    authorRepo.save(new Author(1000L, "John DOE", "Long description"))
//        .block(); // ok at startup
  }

  public record GetAuthorsResponse(long id, String name, String email, String bio) {
    GetAuthorsResponse(Author author, String email) {
      this(author.id(), author.name(),email, author.bio());
    }
  }

  /* TODO: migrate the part below
  @GetMapping("authors")
  public List<GetAuthorsResponse> getAllAuthors() {
    return authorRepo.findAll().stream().map(author -> new GetAuthorsResponse(author, contactApi.fetchEmail(author.id()))).collect(Collectors.toList());
  }

  @Component
  @RequiredArgsConstructor
  public static class ContactApi {
    private final RestTemplate restTemplate;
    @Cacheable("contact-email")
    public String fetchEmail(long authorId) {
      log.info("Retrieving email for author {}", authorId);
      String uri = "http://localhost:9999/contact/" + authorId + "/email";
      return restTemplate.getForObject(uri, String.class);
    }
  }
  */
}
