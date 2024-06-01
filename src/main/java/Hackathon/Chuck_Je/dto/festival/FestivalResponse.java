package Hackathon.Chuck_Je.dto.festival;

import Hackathon.Chuck_Je.domain.Festival;
import lombok.Getter;

//축제 목록 API dto
@Getter
public class FestivalResponse {
    private final String name;
    private final String detail;

    public FestivalResponse(Festival festival) {
        this.name = festival.getName();
        this.detail = festival.getDetail();
    }
}
