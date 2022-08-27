package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.domain.User;
import cjh.projectilsancommunity.repository.UserRepository;
import cjh.projectilsancommunity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
//@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 홈페이지에서 "회원가입" 버튼 클릭 시, 회원가입 폼으로 이동합니다.
    @GetMapping("/user/signup")
    public String userSignUpForm(){
        return "userSignUp";
    }

    // 회원가입 페이지에서 정보를 입력 후, "회원가입" 버튼을 클릭 시,
    // 중복 ID를 체크 후, 알맞는 페이지로 이동합니다.
    @PostMapping("/user/signup")
    public String userSignUp(@ModelAttribute User user){
        if(userService.saveUser(user))
            return "redirect:/userSignUpSuccess";   // 회원가입 성공 페이지
        else{
            return "redirect:/userSignUpFail";    // 회원가입 실패 페이지
        }
    }

    // 회원가입 성공 페이지
    @GetMapping("/userSignUpSuccess")
    public String userSignUpSuccess(){
        return "userSignUpSuccess";
    }

    // 회원가입 실패 페이지
    @GetMapping("/userSignUpFail")
    public String userSignUpFail(){
        return "userSignUpFail";
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
