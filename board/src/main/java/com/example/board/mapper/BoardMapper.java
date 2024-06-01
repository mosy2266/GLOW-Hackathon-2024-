package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.BoardEntity;

import java.util.List;

@Mapper
public interface BoardMapper {
    /*
     * mapper xml파일의 resultType 해당하는 클래스에 결과를 담으며,
     * N개가 되므로 MutableList로 Return 타입을 설정합니다.
     */
    List<BoardEntity> getBoardList();
}