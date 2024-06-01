package Hackathon.Chuck_Je.dto.festival;

import Hackathon.Chuck_Je.domain.Festival;
import lombok.Getter;

@Getter
public class FestivalListViewResponse {
    private final Long id;
    private final String name;
    private final String detail;

    public FestivalListViewResponse(Festival festival) {
        this.id = festival.getId();
        this.name = festival.getName();
        this.detail = festival.getDetail();
    }
}
