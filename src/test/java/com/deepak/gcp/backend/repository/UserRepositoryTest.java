package com.deepak.gcp.backend.repository;

import com.deepak.gcp.backend.entity.User;
import com.deepak.gcp.backend.helper.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @Rollback(value = false)
    public void testSaveUser(){
        User user = userRepository.getReferenceById(2L);
        user.setPassword(new BCryptPasswordEncoder().encode("Deepak"));
        System.out.println(user);
    }

}
