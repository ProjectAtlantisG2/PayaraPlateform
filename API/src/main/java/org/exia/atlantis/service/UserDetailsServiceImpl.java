package org.exia.atlantis.service;

import org.exia.atlantis.model.ApplicationUser;
import org.exia.atlantis.model.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

/**
 * Created by Azerom on 29/06/2018.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository applicationUserRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<ApplicationUser> result = applicationUserRepository.findByEliotId(id);
        if (!result.isPresent()) {
            throw new UsernameNotFoundException(id);
        }
        ApplicationUser applicationUser = result.get();
        return new User(applicationUser.getEliotId(), applicationUser.getEliotChain(), emptyList());
    }
}