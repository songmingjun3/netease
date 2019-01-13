package netease.homework.controller;

import netease.homework.bean.User;
import netease.homework.common.Const;
import netease.homework.common.ServerResponse;
import netease.homework.service.IUserService;
import netease.homework.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author SMJ
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;


    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user!=null){
            return ServerResponse.createByErrorMsg("用户已经登录，请退出后重新登录");
        }
        ServerResponse<User> response = iUserService.login(username,password);
        if (response.isSuccess()){
            user = response.getData();
            session.setAttribute(Const.CURRENT_USER,user);
            //卖家登录
            if(user.getSalerorbuyer()==Const.Role.ROLE_SALER){
                //todo,跳转到卖家首页
            }
            //买家登录
            if (user.getSalerorbuyer()==Const.Role.ROLE_USER){
                //todo，跳转到买家首页
            }
        }else {
            return ServerResponse.createByErrorMsg("用户登录错误");
        }
        return response;
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout.do")
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }
}
