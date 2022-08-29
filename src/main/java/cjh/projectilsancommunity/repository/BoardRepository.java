package cjh.projectilsancommunity.repository;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.mybatis.BoardMapper;
import lombok.RequiredArgsConstructor;
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

    public Optional<Board> getArticle(int bno){
        return boardMapper.getArticle(bno);
    }
}
