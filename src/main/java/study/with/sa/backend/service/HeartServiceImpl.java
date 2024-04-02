package study.with.sa.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class HeartServiceImpl implements HeartService{
    private static final String GIRL_FRIEND_NAME = "노설아";
    private static final String BOY_FRIEND_NAME = "장성욱";

    @Override
    public ResponseEntity<Object> myLove() {
        // data에 담을 객체 선언
        Map<String, Object> response = new HashMap<>();
        // 파트너의 정보 세팅
        response.put("girlFriend", GIRL_FRIEND_NAME);
        response.put("boyFriend", BOY_FRIEND_NAME);
        response.put("rule", "영원히 함께!♥");
        // API 응답 객체 리턴
        return ResponseEntity.ok(response);
    }
}
