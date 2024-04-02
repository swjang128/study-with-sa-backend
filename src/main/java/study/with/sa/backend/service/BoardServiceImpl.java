package study.with.sa.backend.service;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.with.sa.backend.dto.BoardCreateDto;
import study.with.sa.backend.repository.BoardRepository;

@Service
@Slf4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;

    @Override
    public ResponseEntity<Object> create(BoardCreateDto boardCreateDto) {
        return ResponseEntity.ok(boardRepository.save(boardCreateDto.entity()));
    }

    @Override
    @Description("게시물 전체 조회")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(boardRepository.findAll());
    }

    @Override
    @Description("특정 게시물 조회")
    public ResponseEntity<Object> findOne(Long id) {
        return ResponseEntity.ok(boardRepository.findById(id));
    }

    @Override
    @Description("특정 게시물 수정")
    public ResponseEntity<Object> update() {
        return null;
    }

    @Override
    @Description("특정 게시물 삭제")
    public ResponseEntity<Object> delete() {
        return null;
    }
}
