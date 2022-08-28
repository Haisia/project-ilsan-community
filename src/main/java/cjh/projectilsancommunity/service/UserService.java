package cjh.projectilsancommunity.service;

import cjh.projectilsancommunity.domain.User;
import cjh.projectilsancommunity.repository.UserRepository;
import cjh.projectilsancommunity.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * User 도매인과 관련된 서비스를
 * 재공해 주는 클래스
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    // 동일한 id를 가진 유저가 있는지 확인 후,
    // 없으면 회원등록 후 true 반환, 있으면 false 반환
    public boolean saveUser(User user){
        Optional<User> checkId = userRepository.selectUser(user.getId());
        try{
            checkId.get();
            return false;
        }catch(NoSuchElementException e){
            userRepository.saveUser(user);
            return true;
        }
    }

    // ID 와 PWD 가 일치하는 유저가 존재하면 로그인
    public User loginUser(String id, String pwd){
        Optional<User> tryLogin = userRepository.loginUser(id, pwd);
        try{
            return tryLogin.get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

}
