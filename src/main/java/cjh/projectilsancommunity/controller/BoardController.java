package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.BoardRepository;
import cjh.projectilsancommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

//    private final BoardRepository boardRepository;
    private final BoardService boardService;


    @GetMapping("/board/welcome")
    public String boardWelcomeList(Model m, Integer bno){
        if(bno==null) {
            List<Board> boardList = boardService.articlesList();
            m.addAttribute(boardList);
            return "board/welcome";
        }else {
            // 글 조회 부분 구현부
            int intBno = bno;
            Board article = boardService.getArticle(intBno);
            m.addAttribute("article",article);
            return "board/welcomeArticle";
        }
    }
}
