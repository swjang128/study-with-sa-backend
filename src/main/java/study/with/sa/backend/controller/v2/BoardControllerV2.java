package study.with.sa.backend.controller.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardListRequestDto;
import study.with.sa.backend.service.BoardService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v2")
public class BoardControllerV2 {
    private final BoardService boardService;

    @GetMapping("/board")
    public ApiResponse boardList(@RequestBody BoardListRequestDto boardListRequestDto) {
        return boardService.boardList(boardListRequestDto);
    }

}
