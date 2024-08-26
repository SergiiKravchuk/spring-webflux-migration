package victor.training.spring.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Document("author-flux")//changing the default document name to create a new document in MongoDB
public record Author(
  @Id
  Long id,
  String name,
  String bio,
  LocalDateTime createdAt) {

  public Author(Long id, String name, String bio) {
    this(id, name, bio, now());
  }
}
