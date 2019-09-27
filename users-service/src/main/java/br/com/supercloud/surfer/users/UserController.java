package br.com.supercloud.surfer.users;

import br.com.supercloud.surfer.users.model.QuiverBean;
import br.com.supercloud.surfer.users.proxy.QuiverServiceProxy;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/users", "/surfers"})
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final UserConfiguration userConfiguration;
    private final QuiverServiceProxy quiverServiceProxy;

    @GetMapping("/config")
    UserConfiguration config() {
        return userConfiguration;
    }

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? ResponseEntity.of(user) : ResponseEntity.notFound().build();
    }

    @GetMapping
    Page<User> find(
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "") String lastName,
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "firstName", direction = Sort.Direction.ASC)
            }) Pageable pageable) {
        return userRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
                firstName, lastName, pageable);
    }

    @GetMapping("/{id}/quivers")
    ResponseEntity<List<QuiverBean>> findUserQuivers(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            List<QuiverBean> quiverBeans = quiverServiceProxy.retrieveQuivers(id);
            log.info("Retrieved quivers: {}", quiverBeans);
            return ResponseEntity.ok(quiverBeans);
        }
        return ResponseEntity.badRequest().build();
    }
}
