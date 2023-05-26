package com.example.studentmanagment.config;

import com.example.studentmanagment.entity.UserInfo;
import com.example.studentmanagment.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo=userInfoRepo.findByName(username);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"+username));
    }
}