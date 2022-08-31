package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.domain.Board;
import cjh.projectilsancommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeBoardController {

//    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private String boardName = "board_welcome";

    // 가입인사 게시판, 게시글 읽기 매핑
    @GetMapping("/board/welcome")
    public String boardWelcome(Model m){
            List<Board> boardList = boardService.articlesList(boardName);
            m.addAttribute(boardList);
            return "board/welcome";
    }

    // 게시글 단일 조회
    @GetMapping("/board/welcome/{bno}")
    public String boardWelcomeView(Model m, @PathVariable("bno") int bno){
        Board article = boardService.getArticle(boardName, bno);
        m.addAttribute("article",article);
        return "board/welcomeArticle";
    }

    // 로그인 확인 후, 게시글 작성 폼 페이지 매핑
    @GetMapping("/board/welcome/article")
    public String boardWelcomeWriteForm(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(loginCheck(request)) {
            return "board/welcomeWrite";
        }else {
            return "redirect:/";
        }
    }

    // 로그인 확인 후, 게시글 작성
    @PostMapping("/board/welcome/article")
    public String boardWelcomeWrite(HttpServletRequest request, @ModelAttribute Board board){
        HttpSession session = request.getSession();
        if(loginCheck(request)) {
            // board 정보에 작성자 id 삽입
            board.setWriter((String) session.getAttribute("id"));
            boardService.writeArticle(boardName, board);
            return "redirect:/board/welcome";
        }else {
            return "redirect:/";
        }
    }

    // 로그인 확인 후, 게시글 수정 폼으로 이동
    @GetMapping("/board/welcome/article/{bno}")
    public String boardWelcomeModifyForm(Model m, @PathVariable("bno") int bno, HttpServletRequest request){
        HttpSession session = request.getSession();
        Board article = boardService.getArticle(boardName, bno);
        if (authCheck(session, article.getWriter())) {
            m.addAttribute("article",article);
            return "board/welcomeModify";
        } else {
            System.out.println("글 작성자만 수정 가능합니다.");
            return "redirect:/";
        }
    }



    // 로그인 확인 후, 게시글 수정
    @PutMapping("/board/welcome/article/{bno}")
    public String boardWelcomeModify(Model m, @PathVariable("bno") int bno, HttpServletRequest request, @ModelAttribute Board newArticle){
        HttpSession session = request.getSession();
        Board article = boardService.getArticle(boardName, bno);

        if(authCheck(session, article.getWriter())) {
            // board 정보에 작성자 id 삽입
            newArticle.setWriter(article.getWriter());

            System.out.println("newArticle.toString() = " + newArticle.toString());
//            boardService.writeArticle(boardName, newArticle);
            boardService.modifyArticle(boardName, newArticle);

            return "redirect:/board/welcome";
        }else {
            return "redirect:/";
        }
    }

//    @PostMapping("/board/welcome/article/{bno}")
//    public String test(@PathVariable("bno") int bno){
//        System.out.println("test 호출");
//
//        return "redirect:/";
//    }


//
//    // 로그인 확인 후, 게시글 삭제
//    @DeleteMapping ("/board/welcome/{bno}")
//    public String boardWelcomeDelete(Model m, @PathVariable("bno") int bno){
//        return "index";
//    }

    // 인자로 받은 id가 로그인되어 있는 유저의 id와 일치여부 반환
    private static boolean authCheck(HttpSession session, String id) {
        return session.getAttribute("id").equals(id);
    }

    // 로그인이 되어 있는지 확인
    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id") != null;
    }
}