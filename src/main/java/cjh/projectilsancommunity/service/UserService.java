package cjh.projectilsancommunity.service;

import cjh.projectilsancommunity.domain.User;
import cjh.projectilsancommunity.repository.UserRepository;
import cjh.projectilsancommunity.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    // 동일한 id를 가진 유저가 있는지 확인 후,
    // 없으면 회원등록
    public void saveUser(User user){
        userRepository.saveUser(user);
    }
}
