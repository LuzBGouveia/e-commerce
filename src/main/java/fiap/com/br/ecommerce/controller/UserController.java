package fiap.com.br.ecommerce.controller;

import fiap.com.br.ecommerce.dto.UserRequest;
import fiap.com.br.ecommerce.dto.UserResponse;
import fiap.com.br.ecommerce.entity.User;
import fiap.com.br.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll()
                .stream()
                .map(UserResponse::fromEntity) //method reference
                .toList();
    }

    @PostMapping
    public User create(@RequestBody @Valid UserRequest userRequest){
        return userService.create(userRequest.toEntity());
    }

}
