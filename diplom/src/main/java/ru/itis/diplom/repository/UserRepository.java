package ru.itis.diplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.diplom.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    public UserRepository() {
//        List<User> users = new ArrayList<>();
//        users.add(new User("anton", "1234", "Антон", "Иванов", 20, Role.ADMIN));
//        users.add(new User("dima", "1234", "Дима", "Пупкин", 21, Role.OPERATOR));
//        users.add(new User("ivan", "12345", "Сергей", "Петров", 22, Role.INSPECTOR));
//        this.users = users;
//    }

    List<User> findAll();

    Optional<User> findUserByFirstname(String name);

    Optional<User> findUserByEmail(String email);

}
