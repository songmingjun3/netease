package netease.homework.controller;

import netease.homework.bean.User;
import netease.homework.common.Const;
import netease.homework.common.ResponseCode;
import netease.homework.common.ServerResponse;
import netease.homework.service.IBuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author SMJ
 */
@Controller
@RequestMapping("/buycar")
public class CarController {

    @Autowired
    private IBuyCarService iBuyCarService;
    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse addToCar(HttpSession session,Integer count,Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"请先登录！");
        }
        if (user.getSalerorbuyer()==1){
            return iBuyCarService.addToCar(count,productId);
        }else {
            return ServerResponse.createByErrorMsg("无权限操作");
        }
    }
}
