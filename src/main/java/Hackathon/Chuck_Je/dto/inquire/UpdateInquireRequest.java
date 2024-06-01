package Hackathon.Chuck_Je.dto.inquire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateInquireRequest {
    private String title;
    private String content;
}
