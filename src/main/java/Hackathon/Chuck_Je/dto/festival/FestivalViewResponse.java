package Hackathon.Chuck_Je.dto.festival;

import Hackathon.Chuck_Je.domain.Festival;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FestivalViewResponse {
    private Long id;
    private String name;
    private String detail;

    public FestivalViewResponse(Festival festival) {
        this.id = festival.getId();
        this.name = festival.getName();
        this.detail = festival.getDetail();
    }
}
