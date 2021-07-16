package K3.levelup.controller;

import K3.levelup.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user") //user로 시작되는 url에 맵핑
public class ProfileController {
    private final HttpSession httpSession;

    @GetMapping("")
    public String profile(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "userdetail";
    }

    //블로그 등록
    //url 어떻게 설정하는 게 좋을지?
    //등록하고 userdetail 페이지로 redirect? 값만 변경할 수 있는지?
//    @PostMapping("/blog")
//    public String registerBlog(String url) {
//        //폼 내부의 url 받고 blog 객체 생성
//        // user 내부에 추가 -> user entity 변경 필요 - 블로그에서 유저를 참조하는게 맞는지?? 고민 필요
//
//    }
}
