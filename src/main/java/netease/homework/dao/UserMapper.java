package netease.homework.dao;

import netease.homework.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(int userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    User selectLogin(@Param("username") String username,@Param("password") String password);
}