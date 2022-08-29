package cjh.projectilsancommunity.service;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public List<Board> articlesList(){
        return boardRepository.articlesList();
    }


    public Board getArticle(int bno){
        Optional<Board> optionalArticle = boardRepository.getArticle(bno);
        if (optionalArticle.isPresent()) {
            Board article = optionalArticle.get();
            boardRepository.increaseViewCnt(bno);
            return article;
        } else {
            return null;
        }
    }
}

