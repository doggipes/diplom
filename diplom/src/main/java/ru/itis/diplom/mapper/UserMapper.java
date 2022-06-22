package ru.itis.diplom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.diplom.model.User;
import ru.itis.diplom.model.dto.TaskUserDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.model.dto.AuthDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "id")
    UserDTO toUserDTO(User user);

    TaskUserDTO toTaskUserDTO(User user);

    @Mapping(target = "password", ignore = true)
    User toUser(AuthDTO authDTO);

    List<UserDTO> toUserDTOs(List<User> users);

    @Mapping(target = "password", ignore = true)
    AuthDTO toAuthDTO(User user);

}
