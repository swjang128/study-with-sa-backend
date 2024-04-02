package study.with.sa.backend.dto;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.with.sa.backend.entity.Board;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDto {
    private Long id;
    private Long authorId;
    private String title;
    private String content;
    private int views;

    public Board create() {
        return Board.builder()
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
    }

    @Description("게시물 전체 수정")
    public Board update() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
    }

}
