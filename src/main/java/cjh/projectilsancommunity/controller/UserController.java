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
    // 회원등록이 되고, (  )페이지로 이동합니다.
    @PostMapping("/user/signup")
    public String userSignUp(@ModelAttribute User user){
        userService.saveUser(user);

        return "redirect:/";
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
