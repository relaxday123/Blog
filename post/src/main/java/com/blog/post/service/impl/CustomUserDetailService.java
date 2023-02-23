package com.blog.post.service.impl;

import com.blog.post.mapper.UserMapper;
import com.blog.post.model.Author;
import com.blog.post.model.Role;
import com.blog.post.repository.AuthorRepository;
import com.blog.post.repository.UserRepository;
import com.blog.post.service.AuthorService;
import com.blog.post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.blog.post.model.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        List<Role> roleList = new ArrayList<>();
        roleList.addAll(user.getRoles());
        List<GrantedAuthority> authorities = roleList.stream().map(role -> new SimpleGrantedAuthority(role.toString().toUpperCase()))
                .collect(Collectors.toList());

        return new User(username, user.getPassword(), authorities);
    }
}
