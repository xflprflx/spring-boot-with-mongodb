package com.xflprflx.springwithmongo.services;

import com.xflprflx.springwithmongo.dtos.UserDTO;
import com.xflprflx.springwithmongo.models.User;
import com.xflprflx.springwithmongo.repositories.UserRepository;
import com.xflprflx.springwithmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    public UserDTO findById(String id){
        Optional<User> obj = userRepository.findById(id);
        User user = obj.orElseThrow(() -> new ResourceNotFoundException("User not found."));
        return new UserDTO(user);
    }

    public User insert(UserDTO userDTO) {
        User user = fromDto(userDTO);
        return userRepository.save(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDto(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
