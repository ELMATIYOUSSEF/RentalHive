package com.rentalhive.service;

import com.rentalhive.domain.User;

public interface UserService {
     User save(User user);
    User findById(Long id) throws Exception;
}
