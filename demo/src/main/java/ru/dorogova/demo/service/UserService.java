package ru.dorogova.demo.service;

import org.springframework.stereotype.Service;
import ru.dorogova.demo.model.User;
import ru.dorogova.demo.repositories.UserRepository;
import java.util.List;

/**
 * Предоставляет определенные возможности  подключения к работе с базами данных
 * Логика работы с User
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Получение всех пользователей из репозитория
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //Сохранение пользователя в репозитории
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Получение пользователя по id
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        return userRepository.findUserById(id);
    }

    /**
     * Удаление пользователя
     * @param id
     */
    public void deleteById(int id){
        userRepository.delete(id);
    }

    /**
     * Изменение данных пользователя
     * @param user
     */
    public void updateUser(User user){
        userRepository.update(user);
    }
}


//package ru.kuznetsov.demo.service;
//
//import ru.kuznetsov.demo.model.User;
//import ru.kuznetsov.demo.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Сервисный класс для работы с пользователями.
// */
//@Service
//public class UserService {
//    /**
//     * Объект репозитория для работы с БД.
//     */
//    private final UserRepository userRepository;
//
//    /**
//     * Конструктор класса.
//     * @param userRepository репозиторий пользователей.
//     */
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User getUserById(Integer id){
//        return userRepository.findUserById(id);
//    }
//    /**
//     * Получение списка всех пользователей.
//     * @return список пользователей.
//     */
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }
//
//    /**
//     * Создание нового пользователя.
//     * @param user объект пользователя.
//     * @return объект пользователя с присвоенным id.
//     */
//    public User saveUser(User user){
//        return userRepository.save(user);
//    }
//
//    /**
//     * Удаление пользователя.
//     * @param id уникальный идентификатор пользователя.
//     */
//    public void deleteById(int id){
//        userRepository.deleteById(id);
//    }
//
//    /**
//     * Изменение данных пользователя.
//     * @param user объект пользователя с новыми данными.
//     */
//    public void updateUser(User user){
//        userRepository.update(user);
//    }
//}


