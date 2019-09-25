package br.com.supercloud.surfer.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void returnsPage() {
        // database is initialized with script "data.sql"
        assertThat(
                userRepository
                        .findAll(PageRequest.of(0, 10))
                        .getContent()
                        .size()
        ).isEqualTo(10);
    }

}
