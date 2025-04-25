package com.deepak.gcp.backend.repository;

import com.deepak.gcp.backend.entity.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void testSaveUser(){
        User user = userRepository.getReferenceById(1L);
        System.out.println(user);

    }


}
