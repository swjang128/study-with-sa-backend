package study.with.sa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.with.sa.backend.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
