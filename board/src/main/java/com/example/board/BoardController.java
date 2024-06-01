package com.example.board;

import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardMapper boardMapper;

    // Http Get 방식으로 주소 가장 뒤 /board로 접근
    @GetMapping("/board")
    List<BoardEntity> getBoardList() {
        return boardMapper.getBoardList();
    }
}
