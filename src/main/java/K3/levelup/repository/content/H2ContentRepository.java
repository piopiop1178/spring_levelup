package K3.levelup.repository.content;

import K3.levelup.domain.BlogPost;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface H2ContentRepository extends JpaRepository<BlogPost, Long>, ContentRepository {
}
