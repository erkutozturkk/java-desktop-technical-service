package models;

import props.User;

public interface IUser {
    int userInsert(User user);

    int userUpdate(User user);
    boolean userLogin(String email, String password);
}
