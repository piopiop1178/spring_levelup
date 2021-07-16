package K3.levelup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class BlogPost {
    private Long id;
    private Blog blog; // 블로그 id 외래키로 참조
    private String url;

}
