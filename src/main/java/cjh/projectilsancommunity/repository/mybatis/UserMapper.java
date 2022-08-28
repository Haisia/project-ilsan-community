package cjh.projectilsancommunity.repository.mybatis;

import cjh.projectilsancommunity.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * MyBatis 의 매핑 XML 을 호출하기 위한 Mapper 인터페이스
 * User 클래스와 관련된 기능을 매핑해준다.
 */

@Mapper
public interface UserMapper {
    void saveUser(User user);
    void deleteUser(String id);
    void deleteAll();
    void updateUser(User user);
    Optional<User> selectUser(String id); // 결과가 null 일 수도 있어서 optional 사용
    Optional<User> loginUser(@Param("id") String id, @Param("pwd") String pwd);
}
