package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/board/welcome")
    public String boardWelcomeList(Model m){
        List<Board> boardList = boardRepository.articlesList();
        m.addAttribute(boardList);
//        for (Board board : list) {
//            m.addAttribute(board);
//        }

        return "board/welcome";
    }
}
