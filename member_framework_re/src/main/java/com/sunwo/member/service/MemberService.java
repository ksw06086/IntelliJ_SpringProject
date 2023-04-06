package com.sunwo.member.service;

import com.sunwo.member.dto.MemberDTO;
import com.sunwo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO){
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO){
        MemberDTO loginMember = memberRepository.login(memberDTO);
        if(loginMember != null){
            return true;
        } else {
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail);
    }

    public boolean update(MemberDTO memberDTO) {
        int result = memberRepository.update(memberDTO);
        if(result > 0){
            return true;
        } else {
            return false;
        }
    }

    public String emailCheck(String memberEmail) {
        MemberDTO memberDTO = memberRepository.findByMemberEmail(memberEmail);
        if(memberDTO == null){  // 해당 이메일을 쓰는 사람이 없다.
            return "ok";
        } else {
            return "no";
        }
    }
}
