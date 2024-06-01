package Hackathon.Chuck_Je.service;

import Hackathon.Chuck_Je.domain.User;
import Hackathon.Chuck_Je.dto.user.AddUserRequest;
import Hackathon.Chuck_Je.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .phonenumber(dto.getPhonenumber())
                .name(dto.getName())
                .nickname(dto.getNickname())
                .build()).getId();
    }
}
