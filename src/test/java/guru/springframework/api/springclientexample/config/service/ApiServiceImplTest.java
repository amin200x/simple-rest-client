package guru.springframework.api.springclientexample.config.service;

import guru.springframework.api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService appService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsers() {
        List<User> users = appService.getUsers(1);

        assertEquals(1, users.size());
        System.out.println(users.get(0).getName().getLast());
    }
}