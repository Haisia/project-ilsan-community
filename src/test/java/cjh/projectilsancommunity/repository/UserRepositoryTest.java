package cjh.projectilsancommunity.repository;

import cjh.projectilsancommunity.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Autowired
    private DataSource ds;

    @Test
    public void DBTest() {
        assertNotNull(ds);
    }


//    @Test
//    void saveUser() {
//        UserRepository userRepository;
//        User user = new User();
//
//        user.setId("asd");
//        user.setPwd("123");
//        user.setName("ddd");
//        user.setEmail("aaa@aaa.com");
//        user.setBirth(new Date());
//        user.setSns("fdfd");
//        System.out.println("user.toString() = " + user.toString());
//        userRepository.saveUser(user);
//    }

}