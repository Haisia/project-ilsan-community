package cjh.projectilsancommunity.repository;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.mybatis.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final BoardMapper boardMapper;


//    public List<Board> articlesList(String boardName){
//        return boardMapper.articlesList(boardName);
//    }

    public List<Board> articlesList(String boardName, Integer limit1, Integer limit2){
        return boardMapper.articlesList(boardName, limit1, limit2);
    }


    // bno 로 특정 게시글을 조회합니다.
    public Optional<Board> getArticle(String boardName, int bno){
        return boardMapper.getArticle(boardName, bno);
    }

    public void writeArticle(String boardName, Board board){
        boardMapper.writeArticle(boardName, board);
    }

    public void modifyArticle(String boardName, @Param("board") Board board){
        boardMapper.modifyArticle(boardName, board);
    }

    public void removeArticle(String boardName, int bno){
        boardMapper.removeArticle(boardName, bno);
    }

    // bno 를 매개로 특정게시글의 조회수 (view_cnt) 를 1 증가 시킵니다.
    public int increaseViewCnt(String boardName, int bno){
        return boardMapper.increaseViewCnt(boardName, bno);
    }
}
