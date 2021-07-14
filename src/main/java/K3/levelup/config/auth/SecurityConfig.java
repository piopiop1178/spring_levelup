package K3.levelup.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;

@RequiredArgsConstructor //자동 의존 주입
@EnableWebSecurity //spring security 설정 활성화 -> 좀 더 알아보기
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//위 포함 두줄 h2 console 사용 위해 disble -> h2 db 사용 안할 시 제거?
                //*** csrf, header frame 설정 관련
                .and()
                    .authorizeRequests()//URL별 권한 관리 설정 옵션의 시작점
                    .antMatchers("/", "/css/**", "images/**",
                            "/js/**", "h2-console/**").permitAll()
                    .anyRequest().authenticated() //위에 설정한 url 제외 모두 로그인한 사용자에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 성공시 redirect
                .and()
                    .oauth2Login()//OAuth2 로그인 기능 설정 옵션 시작점
                        .userInfoEndpoint()//OAuth2 로그인 성공 이후 사용자 정보 가져올 때 설정 담당
                            .userService(customOAuth2UserService); //소셜 로그인 성공 시 유저 정보 관련 사용할 UserService 구현체 등록

    }
}
