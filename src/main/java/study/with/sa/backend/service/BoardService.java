package study.with.sa.backend.service;

import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardCreateDto;

public interface BoardService {
    ApiResponse<Object> create(BoardCreateDto boardCreateDto);
    ApiResponse<Object> findAll();
    ApiResponse<Object> findOne(Long id);
    ApiResponse<Object> update();
    ApiResponse<Object> delete();
}
