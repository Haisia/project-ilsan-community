package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.repository.BoardRepository;
import cjh.projectilsancommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

//    private final BoardRepository boardRepository;
    private final BoardService boardService;

    // 가입인사 게시판, 게시글 읽기 매핑
    @GetMapping("/board/welcome")
    public String boardWelcome(Model m, Integer bno){
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

    // 로그인 확인 후, 게시글 작성 폼 페이지 매핑
    @GetMapping("/board/welcome/write")
    public String boardWelcomeWriteForm(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(loginCheck(request)) {
            return "board/welcomeWrite";
        }else {
            return "redirect:/";
        }
    }

    // 로그인 확인 후, 게시글 작성
    @PostMapping("/board/welcome/write")
    public String boardWelcomeWrite(HttpServletRequest request, @ModelAttribute Board board){
        HttpSession session = request.getSession();
        if(loginCheck(request)) {
            // board 정보에 작성자 id 삽입
            board.setWriter((String) session.getAttribute("id"));
            boardService.writeArticle(board);
            return "redirect:/board/welcome";
        }else {
            return "redirect:/";
        }
    }



    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id") != null;
    }
}
