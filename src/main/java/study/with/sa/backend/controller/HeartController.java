package study.with.sa.backend.controller;

import org.springframework.web.bind.annotation.*;
import study.with.sa.backend.config.ApiResponse;
import study.with.sa.backend.service.HeartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
public class HeartController {
    private final HeartService heartService;

    @GetMapping("/myLove")
    public ApiResponse<Object> myLove() {
        return heartService.myLove();
    }

}
