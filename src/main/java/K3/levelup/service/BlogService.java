package K3.levelup.service;

import K3.levelup.domain.Blog;
import K3.levelup.repository.blog.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository memoryBlogRepository;

    //정상 실행 확인 위한 return 필요한지?
    public void saveContent(Long id, Long contentId) {
        Blog blog = memoryBlogRepository.findById(id).get(); //optional type이라 get()으로 user 꺼냄
        if(blog != null) {
            blog.appendContentId(contentId);
            blog.addContentsCount(1);
        }
    }
}
