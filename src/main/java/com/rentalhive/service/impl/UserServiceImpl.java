package com.rentalhive.service.impl;

import com.rentalhive.domain.User;
import com.rentalhive.repository.UserRepository;
import com.rentalhive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository ;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public User findById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return user.get();
        throw  new Exception("This User Doesn't Exist !!");
    }
}
