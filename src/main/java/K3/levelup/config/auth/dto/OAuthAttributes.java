package K3.levelup.config.auth.dto;

import K3.levelup.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String provider;
    private String name;
    private String email;

    //이 값들을 갖고 어던 서비스로 로그인했는지 확인
    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes, registrationId);
        }
        return ofGoogle(userNameAttributeName, attributes, registrationId);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes, String registrationId) {
        return OAuthAttributes.builder()
                .provider(registrationId)
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName,
                                           Map<String, Object> attributes, String registrationId) {

        //네이버 api 응답 형태가 달라 response에서 정보를 꺼내야됨
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .provider(registrationId)
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
        }

    public User toEntity() {
        return User.builder()
                .provider(provider)
                .name(name)
                .email(email)
                .build();
    }
}
