package com.spring.ajax.service;

import com.spring.ajax.dto.SearchDTO;
import com.spring.ajax.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    public List<SearchDTO> searchList(String keyword) {
        return searchRepository.searchList(keyword);
    }
}
