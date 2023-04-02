package com.sunwo.board.service;

import com.sunwo.board.dto.BoardDTO;
import com.sunwo.board.dto.PageDTO;
import com.sunwo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateHIts(Long id) {
        boardRepository.updateHits(id);
    }

    public boolean delete(Long id) {
        int result = boardRepository.delete(id);
        if(result > 0){
            return true;
        } else {
            return false;
        }
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    int pageLimit = 3;  // 한 페이지에 보여줄 글 갯수
    int blockLimit = 3; // 하단에 숫자가 몇 개씩 나오게 할 것인지
    public List<BoardDTO> pagingList(int page) {
        /*
        * 1페이지당 보여지는 글 갯수 3
        *       1page => 0
        *       2page => 3
        *       3page => 6
        */
        int pageStart = (page - 1) * 3;
        Map<String, Integer> pagingParams = new HashMap<String, Integer>();
        pagingParams.put("start", pageStart);
        pagingParams.put("limit", pageLimit);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page) {
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 값(10/3=3.33333 => 4 -> ceil 올림 함수)
        int maxPage = (int) Math.ceil((double) boardCount / pageLimit);
        // 시작 페이지 값 계산(1,4,7,10,~~)
        int startPage = ((int) Math.ceil((double) page / blockLimit) - 1) * blockLimit + 1 ;
        // 끝 페이지 값 계산
        int endPage = startPage + blockLimit - 1;
        if(endPage>maxPage){
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO(page, maxPage, startPage, endPage);

        return pageDTO;
    }
}
