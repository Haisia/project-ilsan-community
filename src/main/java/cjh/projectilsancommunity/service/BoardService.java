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


    // BoardRepository 에서 모든 글 목록 조회
    public List<Board> articlesList(){
        return boardRepository.articlesList();
    }

    // BoardRepository 에서 bno를 매개로 특정 글 조회
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

    // BoardRepository 를 통해 게시글 등록
    public void writeArticle(Board board){
        boardRepository.writeArticle(board);
    }
}

