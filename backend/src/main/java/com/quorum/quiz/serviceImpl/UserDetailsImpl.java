package com.quorum.quiz.serviceImpl;

import com.quorum.quiz.models.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;;

@Data
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionID=1L;
    private Long id;
    private String username;
    private String password;
    private String email;

    public UserDetailsImpl(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Custom user implementation
    //Convert User object into UserDetailsImpl for spring security
    public static UserDetailsImpl build(User user){
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
