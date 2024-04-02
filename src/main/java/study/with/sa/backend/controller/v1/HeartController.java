package study.with.sa.backend.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Object> myLove() {
        return ResponseEntity.ok(heartService.myLove());
    }

}
