package cjh.projectilsancommunity.repository;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.mybatis.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final BoardMapper boardMapper;


    public List<Board> articlesList(String boardName){
        return boardMapper.articlesList(boardName);
    }

    // bno 로 특정 게시글을 조회합니다.
    public Optional<Board> getArticle(String boardName, int bno){
        return boardMapper.getArticle(boardName, bno);
    }

    public void writeArticle(String boardName, Board board){
        boardMapper.writeArticle(boardName, board);
    }

    // bno 를 매개로 특정게시글의 조회수 (view_cnt) 를 1 증가 시킵니다.
    public int increaseViewCnt(String boardName, int bno){
        return boardMapper.increaseViewCnt(boardName, bno);
    }



}
