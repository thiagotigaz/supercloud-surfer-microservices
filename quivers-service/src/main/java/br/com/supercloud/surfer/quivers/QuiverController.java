package br.com.supercloud.surfer.quivers;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quivers")
@RequiredArgsConstructor
public class QuiverController {

    private final QuiverRepository quiverRepository;

    @GetMapping("/{id}")
    ResponseEntity<Quiver> findById(@PathVariable Long id) {
        Optional<Quiver> quiver = quiverRepository.findById(id);
        return quiver.isPresent() ? ResponseEntity.of(quiver) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<List<Quiver>> findByUserId(@PathVariable Long userId) {
        List<Quiver> quivers = quiverRepository.findByUserId(userId);
        return quivers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(quivers);
    }

}
