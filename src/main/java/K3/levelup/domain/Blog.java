package K3.levelup.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blog")
public class Blog {
    @Id @GeneratedValue
    private Long id;
    private String blogUrl;
    private Integer contentsCount; //Integer?
    //blog interface 만들고 type 별 블로그 객체 만들어서 글 유효 확인 method 만들면 좋을 듯
    private String type; // 블로그 타입(티스토리인지, velog인지 등)
    private String description; //블로그 설명?
//    private Long user; 블로그에서 유저를 참조할 일은 없을 것 같음
    private ArrayList<Long> contentArray;

    public void appendContentId(long id) {
        this.contentArray.add(id);
    }

    public void addContentsCount(int n) {
        this.contentsCount += n;
    }
}
