package netease.homework.controller;

import netease.homework.bean.User;
import netease.homework.common.Const;
import netease.homework.common.ResponseCode;
import netease.homework.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author SMJ
 */
@Controller
public class AccountController {


    @RequestMapping("/account.do")
    @ResponseBody
    public ServerResponse getBuyerAccount(HttpSession session){
        User user =(User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"请先登录！");
        }
        if (user.getSalerorbuyer()==1){
            //todo
            return null;
        }else {
            return ServerResponse.createByErrorMsg("无权限操作！");
        }
    }
}
