package ru.itis.diplom.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.diplom.model.User;
import ru.itis.diplom.repository.UserRepository;

import java.util.Optional;

@Service(value = "customUserDetailsService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionUser = userRepository.findUserByEmail(email);
        if (optionUser.isPresent()) {
            return new UserDetailsImpl(optionUser.get());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
