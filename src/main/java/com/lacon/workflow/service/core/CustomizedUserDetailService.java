package com.lacon.workflow.service.core;

import com.lacon.workflow.entity.User;
import com.lacon.workflow.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomizedUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    public CustomizedUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(UUID.fromString(username))
                .orElseThrow(() -> new UsernameNotFoundException("could not found user..!!"));
        return new CustomUserDetails(user);
    }

}
