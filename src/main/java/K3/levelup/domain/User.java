package K3.levelup.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter //임시, 추후에 비즈니스 로직으로 변경
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String provider;
    private String name;
    private String email;
    //tmp
    private String blogUrl;

    //일단 기본적인 것만
    //추후 등록 블로그, 레벨, 경험치 등 필요

    public User update(String name) {
        this.name = name;

        return this;
    }

    public void registerBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
}
