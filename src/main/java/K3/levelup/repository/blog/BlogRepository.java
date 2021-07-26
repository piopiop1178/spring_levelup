package K3.levelup.repository.blog;

import K3.levelup.domain.Blog;

import java.util.List;
import java.util.Optional;


public interface BlogRepository {
    Blog save(Blog blog);
    Optional<Blog> findById(Long id);
    Optional<Blog> findByUrl(String url);
    List<Blog> findAll();
}
