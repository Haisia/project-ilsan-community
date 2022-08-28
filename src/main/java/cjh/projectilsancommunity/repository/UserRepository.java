package cjh.projectilsancommunity.repository;

import cjh.projectilsancommunity.domain.User;
import cjh.projectilsancommunity.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    @Autowired
    private SqlSession session;
    private final UserMapper userMapper;

    public User saveUser(User user) {
        userMapper.saveUser(user);
        return user;
    }

    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }

    public void deleteAll() {
        userMapper.deleteAll();
    }

    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }

    public Optional<User> selectUser(String id) {
        return userMapper.selectUser(id);
    }

    // 아이디 비번 해당 User 리턴
    public Optional<User> loginUser(String id, String pwd) {
        return userMapper.loginUser(id, pwd);
    }
}
