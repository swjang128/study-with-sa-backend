package study.with.sa.backend.service;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Version;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardListRequestDto;
import study.with.sa.backend.dto.BoardRequestDto;
import study.with.sa.backend.repository.BoardRepository;

@Service
@Slf4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;

    @Override
    public ApiResponse create(BoardRequestDto boardRequestDto) {
        return ApiResponse.success(boardRepository.save(boardRequestDto.create()));
    }

    @Override
    @Description("게시물 전체 조회")
    public ApiResponse readAll() {
        return ApiResponse.success(boardRepository.findAll());
    }

    @Override
    @Description("특정 게시물 조회")
    public ApiResponse readOne(Long id) {
        return ApiResponse.success(boardRepository.findById(id));
    }

    @Override
    @Description("특정 게시물 수정")
    public ApiResponse update(BoardRequestDto boardRequestDto) {
        return ApiResponse.success(boardRepository.save(boardRequestDto.update()));
    }

    @Override
    @Description("특정 게시물 삭제")
    public ApiResponse delete(Long id) {
        boardRepository.deleteById(id);
        return ApiResponse.ok();
    }

    @Override
    @Description("조회수 1 증가")
    public ApiResponse addViews(Long id) {
        return boardRepository.findById(id)
                // 게시물이 존재할 경우 조회수 1 증가하고 Update
                .map(board -> {
                    board.incrementViews();
                    boardRepository.save(board);
                    return ApiResponse.success(board);
                })
                // 게시물이 존재하지 않을 경우 게시물이 없다고 리턴
                .orElseGet(() -> ApiResponse.error(HttpStatus.NOT_FOUND, "게시물을 찾을 수 없습니다."));
    }

    @Override
    @Description("(v2) 조건에 맞는 게시판 목록 조회")
    public ApiResponse boardList(BoardListRequestDto boardListRequestDto) {
        // TODO: 조건에 맞게 게시판 목록을 조회하도록 추가할 것
        return ApiResponse.success(boardRepository.findAll());
    }
}
