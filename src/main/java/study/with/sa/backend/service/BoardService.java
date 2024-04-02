package study.with.sa.backend.service;

import org.springframework.http.ResponseEntity;
import study.with.sa.backend.dto.BoardCreateDto;

public interface BoardService {
    ResponseEntity<Object> create(BoardCreateDto boardCreateDto);
    ResponseEntity<Object> findAll();
    ResponseEntity<Object> findOne(Long id);
    ResponseEntity<Object> update();
    ResponseEntity<Object> delete();
}
