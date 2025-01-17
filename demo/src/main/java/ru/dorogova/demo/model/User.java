package ru.dorogova.demo.model;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fisrtName) {
        this.firstName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}



//package ru.kuznetsov.demo.model;
//
//import java.util.Objects;
//
///**
// * Сущность пользователя.
// */
//public class User {
//    /**
//     * Уникальный идентификатор.
//     */
//    private int id;
//    /**
//     * Имя пользователя.
//     */
//    private String firstName;
//    /**
//     * Фамилия пользователя.
//     */
//    private String lastName;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id == user.id && Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName);
//    }
//}