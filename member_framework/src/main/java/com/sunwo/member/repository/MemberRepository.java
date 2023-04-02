package com.sunwo.member.repository;

import com.sunwo.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     // mybatis의 기능별로 쿼리를 정의하는데 적절한 쿼리들을 호출해주고 매개변수 넘겨주고 return 값이 있다면 해주는 역할
@RequiredArgsConstructor
// 400에러 => 맞지 않은 값을 입력했을 경우
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        // mapper 이름, 매개변수
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO){
        // 값이 여러 리스트가 나오는데 One으로 했다면 500에러가 나올 수 있음
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }
}
