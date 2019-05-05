package by.itacademy.service.service;

import by.itacademy.database.dao.UserDao;
import by.itacademy.database.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public List<User> findAll() {
        return UserDao.getInstance().findAll().stream().collect(Collectors.toList());
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
