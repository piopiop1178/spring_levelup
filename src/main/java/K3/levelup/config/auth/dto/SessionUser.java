package K3.levelup.config.auth.dto;

import K3.levelup.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
//세션에 저장하기 위해서는 직렬화 필요?? -> 엔티티에 직렬화를 구현한다면 자식엔티티들도 포함되어 성능 이슈 발생할 수 있음
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
