package online.qsx.server;

import online.qsx.model.Users;

import java.util.List;

public interface UsersServer {

    Users getUsers(Users users);

    List<Users> getUseries(Users users);
}
