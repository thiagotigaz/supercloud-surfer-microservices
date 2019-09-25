package br.com.supercloud.surfer.boards;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/boards"})
@RequiredArgsConstructor
public class BoardController {

    private final BoardConfiguration boardConfiguration;
    private final BoardRepository boardRepository;

    @GetMapping("/config")
    BoardConfiguration config() {
        return boardConfiguration;
    }

    @GetMapping("/{id}")
    ResponseEntity<Board> findById(@PathVariable Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.isPresent() ? ResponseEntity.of(board) : ResponseEntity.notFound().build();
    }
}
