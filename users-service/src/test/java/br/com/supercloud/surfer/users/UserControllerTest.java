package br.com.supercloud.surfer.users;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class,
        FeignAutoConfiguration.class})
public class UserControllerTest {

    @Captor
    ArgumentCaptor<Pageable> pageableCaptor;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserConfiguration userConfiguration;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void evaluatesPageableParameter() throws Exception {
        // Arrange and Act
        mockMvc.perform(get("/users")
                .param("page", "5")
                .param("size", "10")
                .param("sort", "id,desc")   // <-- no space after comma!
                .param("sort", "first_name,asc")) // <-- no space after comma!
                .andExpect(status().isOk());

        // Assert
        verify(userRepository).findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
                eq(""), eq(""), pageableCaptor.capture());
        PageRequest pageable = (PageRequest) pageableCaptor.getValue();
        assertThat(pageable.getPageNumber(), is(5));
        assertThat(pageable.getPageSize(), is(10));
        Sort sort = pageable.getSort();
        assertThat(sort.getOrderFor("first_name").getDirection(), is(Direction.ASC));
        assertThat(sort.getOrderFor("id").getDirection(), is(Direction.DESC));
    }
}
