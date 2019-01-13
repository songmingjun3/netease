package netease.homework.service.Impl;

import netease.homework.bean.User;
import netease.homework.common.ServerResponse;
import netease.homework.dao.UserMapper;
import netease.homework.service.IUserService;
import netease.homework.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author SMJ
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {

        //验证用户是否存在
        int userCount = userMapper.checkUserName(username);
        if (userCount==0){
            return ServerResponse.createByErrorMsg("用户名不存在");
        }

        //使用MD5加密密码登录，验证密码是否正确
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username,md5Password);
        if (user==null){
            return ServerResponse.createByErrorMsg("密码错误");
        }

        //登录成功,将密码置空后返回user对象
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",user);

    }
}
