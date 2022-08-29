package cjh.projectilsancommunity.repository.mybatis;

import cjh.projectilsancommunity.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    List<Board> articlesList();    // 게시판 목록 얻기
    Optional<Board> getArticle(int bno);     // 글 1개 조회
    void writeArticle(Board board);         // 글 작성
    void modifyArticle(Board board);        // 글 수정
    void removeArticle(int bno);            // 글 삭제
}
