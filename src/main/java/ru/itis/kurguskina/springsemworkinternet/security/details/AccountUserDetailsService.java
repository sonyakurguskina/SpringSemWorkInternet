package ru.itis.kurguskina.springsemworkinternet.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.kurguskina.springsemworkinternet.repositories.UserRepository;


@RequiredArgsConstructor
@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final UserRepository accountsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AccountUserDetails(
                accountsRepository.findUserByEmail(email).orElseThrow(
                                () -> new UsernameNotFoundException("User not found")));

    }
}
