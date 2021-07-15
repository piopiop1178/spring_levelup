package K3.levelup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter //임시, 추후에 비즈니스 로직으로 변경
@Entity
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String provider;
    private String name;
    private String email;

    //일단 기본적인 것만
    //추후 등록 블로그, 레벨, 경험치 등 필요

    public User update(String name) {
        this.name = name;

        return this;
    }
}
