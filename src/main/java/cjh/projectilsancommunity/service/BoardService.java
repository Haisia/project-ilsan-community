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
    public List<Board> articlesList(String boardName){
        return boardRepository.articlesList(boardName, null, null);
    }


    // limit1 에서부터 limit2 개 만큼만 조회
    public List<Board> articlesList(String boardName, int limit1, int limit2){
        return boardRepository.articlesList(boardName, limit1, limit2);
    }

    public int articlesListSize(String boardName){
        return boardRepository.articlesListSize(boardName);
    }



    // BoardRepository 에서 bno를 매개로 특정 글 조회
    public Board getArticle(String boardName, int bno){
        Optional<Board> optionalArticle = boardRepository.getArticle(boardName, bno);
        if (optionalArticle.isPresent()) {
            Board article = optionalArticle.get();
            boardRepository.increaseViewCnt(boardName, bno);
            return article;
        } else {
            return null;
        }
    }

    // BoardRepository 를 통해 게시글 등록
    public void writeArticle(String boardName, Board board){
        boardRepository.writeArticle(boardName, board);
    }

    public void modifyArticle(String boardName, Board board){
        boardRepository.modifyArticle(boardName, board);
    }

    public void removeArticle(String boardName, int bno){
        boardRepository.removeArticle(boardName, bno);
    }



}

