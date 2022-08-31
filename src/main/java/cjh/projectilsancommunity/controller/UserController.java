package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.domain.User;
import cjh.projectilsancommunity.repository.UserRepository;
import cjh.projectilsancommunity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

/**
 * User 도매인의 기능을
 * 사용자가 사용할 수 있도록 도와주는 클래스
 */

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // 홈페이지에서 "회원가입" 버튼 클릭 시, 회원가입 폼으로 이동합니다.
    @GetMapping("/user/signup")
    public String userSignUpForm() {
        return "userSignUp";
    }

    // 회원가입 페이지에서 정보를 입력 후, "회원가입" 버튼을 클릭 시,
    // 중복 ID를 체크 후, 알맞는 페이지로 이동합니다.
    @PostMapping("/user/signup")
    public String userSignUp(@ModelAttribute User user) {
        if (userService.saveUser(user))
            return "redirect:/";   // 회원가입 성공 페이지
        else {
            return "redirect:/";    // 회원가입 실패 페이지
        }
    }

//    // 회원가입 성공 페이지
//    @GetMapping("/userSignUpSuccess")
//    public String userSignUpSuccess() {
//        return "userSignUpSuccess";
//    }
//
//    // 회원가입 실패 페이지
//    @GetMapping("/userSignUpFail")
//    public String userSignUpFail() {
//        return "userSignUpFail";
//    }




    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String userLoginForm(){
        return "login";
    }

    // 로그인 시도
    @PostMapping("/login")
    public String userLogin(String id, String pwd, HttpServletRequest request, HttpServletResponse response) {
        // id 와 pwd 가 일치하는 계정 존재 시,
        // 세션에 id, pwd, name, email 저장
        User user = userService.loginUser(id, pwd);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("pwd", user.getPwd());
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            System.out.println("로그인 성공 / id : " + id);
            return "redirect:/";

        } else {
            System.out.println("로그인 실패");
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request) {
        if (loginCheck(request)) {
            System.out.println("로그아웃을 합니다 / id : " + request.getSession().getAttribute("id"));
            request.getSession().invalidate();
        } else {
            System.out.println("로그인을 먼저 해주세요");
        }
        return "redirect:/";

    }

    // 로그인이 되어있는지 확인
    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id") != null;
    }


//    @GetMapping("/user/test")
//    public String test(){
//        User user = new User();
//        user.setId("testtttt");
//        user.setPwd("123");
//        user.setName("ddd");
//        user.setEmail("aaa@aaa.com");
//        user.setBirth(new Date());
//        user.setSns("fdfd");
//        System.out.println("user.toString() = " + user.toString());
//
//        userService.saveUser(user);
////        userRepository.saveUser(user);
//        return "redirect:/";
////        return userRepository.selectUser("test");
//    }


}
