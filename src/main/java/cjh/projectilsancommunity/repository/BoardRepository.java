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


    public List<Board> articlesList(){
        return boardMapper.articlesList();
    }

    // bno 로 특정 게시글을 조회합니다.
    public Optional<Board> getArticle(int bno){
        Optional<Board> article = boardMapper.getArticle(bno);
        return boardMapper.getArticle(bno);
    }

    public void writeArticle(Board board){
        System.out.println("board.toString() = " + board.toString());
        boardMapper.writeArticle(board);
    }

    // bno 를 매개로 특정게시글의 조회수 (view_cnt) 를 1 증가 시킵니다.
    public int increaseViewCnt(int bno){
        return boardMapper.increaseViewCnt(bno);
    }



}
