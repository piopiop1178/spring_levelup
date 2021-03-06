package K3.levelup.config.auth.dto;

import K3.levelup.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
//세션에 저장하기 위해서는 직렬화 필요?? -> 엔티티에 직렬화를 구현한다면 자식엔티티들도 포함되어 성능 이슈 발생할 수 있음
//세션을 위한 user의 dto 생성
public class SessionUser implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String blogUrl;
    private int exp;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
