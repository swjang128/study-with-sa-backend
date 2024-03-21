package study.with.sa.backend.dto;

import lombok.Builder;
import study.with.sa.backend.entity.Board;

@Builder
public class BoardCreateDto {
    private String title;
    private String content;
    private Long authorId;

    public Board entity() {
        return Board.builder()
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
    }
}
