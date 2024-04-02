package study.with.sa.backend.service;

import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardListRequestDto;
import study.with.sa.backend.dto.BoardRequestDto;

public interface BoardService {
    ApiResponse create(BoardRequestDto boardRequestDto);
    ApiResponse readAll();
    ApiResponse readOne(Long id);
    ApiResponse update(BoardRequestDto boardRequestDto);
    ApiResponse delete(Long id);
    ApiResponse addViews(Long id);
    ApiResponse boardList(BoardListRequestDto boardListRequestDto);
}
