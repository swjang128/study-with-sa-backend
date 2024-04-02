package study.with.sa.backend.controller.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.dto.BoardRequestDto;
import study.with.sa.backend.service.BoardService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board")
    public ApiResponse readAll() {
        return boardService.readAll();
    }

    @GetMapping("/board/{id}")
    public ApiResponse readOne(@PathVariable("id") Long id) {
        return boardService.readOne(id);
    }

    @PutMapping("/board/{id}")
    public ApiResponse readOneAndIncrementViews(@PathVariable("id") Long id) {
        return boardService.addViews(id);
    }

    @PostMapping("/board")
    public ApiResponse create(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.create(boardRequestDto);
    }

    @PutMapping("/board")
    public ApiResponse update(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.update(boardRequestDto);
    }

    @DeleteMapping("/board/{id}")
    public ApiResponse delete(@PathVariable("id") Long id) {
        return boardService.delete(id);
    }
}
