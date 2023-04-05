package spring.mvc.mybatis.ch01.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import spring.mvc.mybatis.ch01.dto.UserDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final SqlSessionTemplate sql;

    public List<UserDTO> addressInfo1() {
        return sql.selectList("Member.addressInfo1");
    }

}
