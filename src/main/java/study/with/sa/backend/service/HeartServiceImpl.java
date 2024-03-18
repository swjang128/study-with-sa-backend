package study.with.sa.backend.service;

import study.with.sa.backend.config.RestApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class HeartServiceImpl implements HeartService{
    private static final String GIRL_FRIEND_NAME = "노설아";
    private static final String BOY_FRIEND_NAME = "장성욱";

    @Override
    public RestApiResponse<Object> myLove() {
        // data에 담을 객체 선언
        Map<String, Object> response = new HashMap<>();
        // 파트너의 정보 세팅
        response.put("girlFriend", GIRL_FRIEND_NAME);
        response.put("boyFriend", BOY_FRIEND_NAME);
        response.put("rule", "영원히 함께!♥");

        return RestApiResponse.success(response);
    }
}
