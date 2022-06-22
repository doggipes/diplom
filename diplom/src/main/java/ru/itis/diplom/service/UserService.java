package ru.itis.diplom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.diplom.exception.BackendException;
import ru.itis.diplom.exception.UserAlreadyExists;
import ru.itis.diplom.exception.UserNotFoundException;
import ru.itis.diplom.mapper.UserMapper;
import ru.itis.diplom.model.User;
import ru.itis.diplom.model.dto.AuthDTO;
import ru.itis.diplom.model.dto.TaskUserDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.model.enumeration.Role;
import ru.itis.diplom.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserDTO> getAll() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    public TaskUserDTO getTaskUserDtoByName(String name) {
        Optional<User> userOptional = userRepository.findUserByFirstname(name);
        return userOptional.map(userMapper::toTaskUserDTO).orElse(null);
    }

    public User getUserByName(String name) {
        Optional<User> userOptional = userRepository.findUserByFirstname(name);
        return userOptional.orElseThrow(UserNotFoundException::new);
    }

    public User getUserById(Long id) {
        if (Objects.isNull(id)) {
            throw new BackendException(BackendException.USER_ID_NULL);
        }
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(UserNotFoundException::new);
    }

    public AuthDTO auth(AuthDTO authDTO) {
        Optional<User> checkedUser = userRepository.findUserByEmail(authDTO.getEmail());
        if (!checkedUser.isPresent()) {
            User user = userMapper.toUser(authDTO);
            user.setPassword(bCryptPasswordEncoder.encode(authDTO.getPassword()));
            user.setRole(Role.OPERATOR);
            return userMapper.toAuthDTO(userRepository.save(user));
        } else {
            throw new UserAlreadyExists();
        }
    }

}
