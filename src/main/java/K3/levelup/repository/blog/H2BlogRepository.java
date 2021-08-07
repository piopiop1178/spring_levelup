package K3.levelup.repository.blog;

import K3.levelup.domain.Blog;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface H2BlogRepository extends JpaRepository<Blog, Long>, BlogRepository {
}
