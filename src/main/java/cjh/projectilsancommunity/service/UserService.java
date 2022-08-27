package cjh.projectilsancommunity.service;

import cjh.projectilsancommunity.domain.User;
import cjh.projectilsancommunity.repository.UserRepository;
import cjh.projectilsancommunity.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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
}
