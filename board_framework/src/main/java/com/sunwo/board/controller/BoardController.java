package com.sunwo.board.controller;

import com.sunwo.board.dto.BoardDTO;
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
            return "redirect:/board/";
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
}
