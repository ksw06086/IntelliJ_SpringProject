package com.sunwo.board.controller;

import com.sunwo.board.dto.BoardDTO;
import com.sunwo.board.dto.PageDTO;
import com.sunwo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        int saveResult = boardService.save(boardDTO);
        if(saveResult > 0){
            return "redirect:/board/paging";
        } else {
            return "save";
        }
    }

    // DB에서 무언가를 가져가야한다면 Model을 넣어주야함
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    // 넘어오는 것이 "/"없이 ?key=값으로 했다면 값을 주지 않으면 됨
    @GetMapping
    public String findById(@RequestParam("id") Long id,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           Model model){
        boardService.updateHIts(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boolean deleteResult = boardService.delete(id);
        if(deleteResult) {
            return "redirect:/board/";
        } else {
            return "redirect:/board?id="+id;
        }
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);
        boardDTO = boardService.findById(boardDTO.getId());
        model.addAttribute("board", boardDTO);
        return "detail";
        // ㄴ 조회수 올리는 것을 제외하게 됨
    }

    // /board/paging?page=2 식으로 올 것
    // 처음페이지는 1페이지를 보여줌
    @GetMapping("/paging")
    public String paging(Model model,                   // false : 필수가 아니다.
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page){
        System.out.println("page = " + page);
        // 해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        System.out.println("pagingList = " + pagingList);
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "paging";
    }
}
