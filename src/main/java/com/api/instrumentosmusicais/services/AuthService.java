package com.api.instrumentosmusicais.services;

import com.api.instrumentosmusicais.domain.Users;
import com.api.instrumentosmusicais.dto.TokenResponseDTO;
import com.api.instrumentosmusicais.dto.UserDTO;
import com.api.instrumentosmusicais.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;
    
    public AuthService(UserRepository repository){
        this.repository = repository;
    }


    public UserDTO doSignUp(String username, String password){
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        this.repository.save(user);

        return new UserDTO(username, password);
    }

    public TokenResponseDTO doLogin(String username, String password) throws Exception {
        Users user = this.repository.findByUsernameAndPassword(username, password);
        if (user == null){
            throw new Exception("User does not exists!!!");
        }

        String token = "token de teste, isso aqui sera mudado";
        return new TokenResponseDTO(token, user.getUsername());
    }
}
