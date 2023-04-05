package com.spring.ajax.repository;

import com.spring.ajax.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final SqlSessionTemplate sql;

    public List<SearchDTO> searchList(String keyword) {
        return sql.selectList("Search.searchList", keyword);
    }
}
