package Hackathon.Chuck_Je.dto.inquire;

import Hackathon.Chuck_Je.domain.Inquire;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddInquireRequest {
    private String title;
    private String content;
    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

    public Inquire toEntity() {
        return Inquire.builder()
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .build();
    }
}
