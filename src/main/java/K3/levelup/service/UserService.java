package K3.levelup.service;

import K3.levelup.domain.User;
import K3.levelup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository memoryUserRepository;

    //정상 실행 확인 위한 return 필요한지?
    public void setBlogUrl(Long id, String blogUrl) {
        User user = memoryUserRepository.findById(id).get(); //optional type이라 get()으로 user 꺼냄

        if(user != null) {
            user.registerBlogUrl(blogUrl);
        }

    }
}
