package study.with.sa.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardCreateDto;
import study.with.sa.backend.service.BoardService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board")
    public ApiResponse<Object> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/board/{id}")
    public ApiResponse<Object> findOne(@PathVariable Long id) {
        return boardService.findOne(id);
    }

    @PostMapping("/board")
    public ApiResponse<Object> create(@RequestBody BoardCreateDto boardCreateDto) {
        return boardService.create(boardCreateDto);
    }

}
