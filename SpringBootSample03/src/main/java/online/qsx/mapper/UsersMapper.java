package online.qsx.mapper;

import online.qsx.model.Users;

		import java.util.List;

/**
 * Created by Administrator on 2016/9/2.
 */
public interface UsersMapper {
	Users getUsers(Users users);

	List<Users> getUseries(Users users);
}
