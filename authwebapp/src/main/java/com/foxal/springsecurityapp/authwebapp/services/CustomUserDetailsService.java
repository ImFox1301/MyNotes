package com.foxal.springsecurityapp.authwebapp.services;

import com.foxal.springsecurityapp.authwebapp.models.Role;
import com.foxal.springsecurityapp.authwebapp.models.User;
import com.foxal.springsecurityapp.authwebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        if(email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$"))
            user = userRepository.findByEmail(email);
        else
            user = userRepository.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return user.getRoles();
    }
}

