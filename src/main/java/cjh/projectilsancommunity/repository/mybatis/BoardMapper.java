package cjh.projectilsancommunity.repository.mybatis;

import cjh.projectilsancommunity.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
//    List<Board> articlesList(String boardName);    // 게시판 목록 얻기

    List<Board> articlesList(@Param("boardName") String boardName,
                             @Param("limit1")Integer limit1, @Param("limit2")Integer limit2);

    int articlesListSize(String boardName);

    Optional<Board> getArticle(@Param("boardName") String boardName, @Param("bno") int bno);     // 글 1개 조회
    void writeArticle(@Param("boardName") String boardName, @Param("board") Board board);         // 글 작성
    void modifyArticle(@Param("boardName") String boardName, @Param("board") Board board);        // 글 수정
    void removeArticle(@Param("boardName") String boardName, @Param("bno") int bno);            // 글 삭제
    int increaseViewCnt(@Param("boardName") String boardName, @Param("bno") int bno);          // 조회수 1 증가

}
