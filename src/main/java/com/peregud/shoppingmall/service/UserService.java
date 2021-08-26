package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   void signUp(Users users);
}
