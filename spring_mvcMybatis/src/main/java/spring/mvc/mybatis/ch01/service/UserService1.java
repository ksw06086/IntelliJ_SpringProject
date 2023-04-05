package spring.mvc.mybatis.ch01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.mvc.mybatis.ch01.dto.UserDTO;
import spring.mvc.mybatis.ch01.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService1 {

    private final UserRepository userRepository;

    public List<UserDTO> addressInfo1() {
        return userRepository.addressInfo1();
    }

}
