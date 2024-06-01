package Hackathon.Chuck_Je.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
    private String phonenumber;
    private String name;
    private String nickname;
}
