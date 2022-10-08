package com.gcsj.mapper;

import com.gcsj.pojo.User;

import com.gcsj.vo.PageRequest;
import com.gcsj.vo.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface UserMapper {

    int addUser(User user);

    List<User> selectUserList(User user);

    User selectUserByName(String  nickname);

    int deleteUserById(Integer id);

	 User selectUserById(Integer id);

	 int Logout(Integer id);

	 int relive(Integer id);

    int updateUserById(User user);

    int updateAvatar(User user);

    List<User> listUser();

    List<User> selectUserListByPage(User user);

    User selectUserByMail(String  mail);

    int checkByEmail(String mail);
}
