package netease.homework.controller;

import netease.homework.bean.User;
import netease.homework.common.Const;
import netease.homework.common.ServerResponse;
import netease.homework.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author SMJ
 *详情页控制端，整合版
 */
@Controller
public class DetailController {
    @Autowired
    private IProductService iProductService;
    @RequestMapping("/detail.do")
    @ResponseBody
    public ServerResponse getProductDetail(HttpSession session,Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return iProductService.getProductDetail(productId);
        }
        Integer userId = user.getUserId();
        if (user.getSalerorbuyer()==0){
            return iProductService.getSellerProductDetail(productId);
        }else if(user.getSalerorbuyer()==1){
            return iProductService.getBuyerProductDetail(userId,productId);
        }else {
            return ServerResponse.createByErrorMsg("无权限操作！");
        }
    }
}
