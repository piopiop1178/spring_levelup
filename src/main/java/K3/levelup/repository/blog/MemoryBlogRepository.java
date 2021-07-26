package K3.levelup.repository.blog;

import K3.levelup.domain.Blog;
import K3.levelup.domain.User;
import K3.levelup.repository.blog.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBlogRepository implements BlogRepository {
    private static Map<Long, Blog> repo = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Blog save(Blog blog) {
        blog.setId(++sequence);
        repo.put(blog.getId(), blog);
        return blog;
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return Optional.ofNullable(repo.get(id));
    }

    @Override
    public Optional<Blog> findByUrl(String url) {
        return Optional.ofNullable(repo.get(url));
    }

    @Override
    public List<Blog> findAll() {
        return new ArrayList<>(repo.values());
    }

    public void clearRepo() {
        repo.clear();
    }
}
