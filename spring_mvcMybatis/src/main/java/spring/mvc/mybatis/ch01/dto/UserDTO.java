package spring.mvc.mybatis.ch01.dto;

import lombok.Data;

import java.sql.Date;
@Data
public class UserDTO {
    private int userId;         // 회원 아이디
    private String userName;    // 회원 이름
    private Date regDate;       // 날짜
    private String address;    // 주소
}
