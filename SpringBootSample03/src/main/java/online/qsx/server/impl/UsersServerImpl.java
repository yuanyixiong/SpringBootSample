package online.qsx.server.impl;

import online.qsx.mapper.UsersMapper;
import online.qsx.model.Users;
import online.qsx.server.UsersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;


@Service("usersServerImpl")
public class UsersServerImpl implements UsersServer {
	@Autowired
	UsersMapper usersMapper;

	public Users getUsers(Users users) {
		return usersMapper.getUsers(users);
	}

	@Override
	public List<Users> getUseries(Users users) {
		return usersMapper.getUseries(users);
	}
}
