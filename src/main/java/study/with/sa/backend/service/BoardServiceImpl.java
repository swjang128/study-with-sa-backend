package study.with.sa.backend.service;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardCreateDto;
import study.with.sa.backend.entity.Board;
import study.with.sa.backend.repository.BoardRepository;

import java.util.Collections;

@Service
@Slf4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;

    @Override
    public ApiResponse<Object> create(BoardCreateDto boardCreateDto) {
        // 파라미터를 entity로 변환하고 테이블에 save
        return ApiResponse.success(boardRepository.save(boardCreateDto.entity()));
    }

    @Override
    @Description("게시물 전체 조회")
    public ApiResponse<Object> findAll() {
        return ApiResponse.success(boardRepository.findAll());
    }

    @Override
    public ApiResponse<Object> findOne(Long id) {
        return ApiResponse.success(boardRepository.findById(id));
    }

    @Override
    public ApiResponse<Object> update() {
        return null;
    }

    @Override
    public ApiResponse<Object> delete() {
        return null;
    }
}
