package br.com.supercloud.surfer.quivers;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuiverRepository extends JpaRepository<Quiver, Long> {

    List<Quiver> findByUserId(Long userId);
}
