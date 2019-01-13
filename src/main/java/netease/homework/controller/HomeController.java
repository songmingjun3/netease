package netease.homework.controller;

import netease.homework.bean.User;
import netease.homework.common.Const;
import netease.homework.common.ResponseCode;
import netease.homework.common.ServerResponse;
import netease.homework.service.IProductService;
import netease.homework.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author SMJ
 * 首页控制端，整合版
 */
@Controller
public class HomeController {
    @Autowired
    private IProductService iProductService;
    @RequestMapping("/home.do")
    @ResponseBody
    public ServerResponse getProductList(HttpSession session,
                                         @RequestParam(value = "type",defaultValue = "0") int type,
                                         @RequestParam(value ="pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value ="pageNum",defaultValue = "10") int pageSize){
        if (type!=0&&type!=1){
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //未登录的商品展示
        if (user==null){
            return iProductService.getAllProductList(pageNum,pageSize);
        }
        //买家展示
        int userId = user.getUserId();
        if (user.getSalerorbuyer()==1){
            //所有商品列表
            if (type==0){
                return iProductService.getBuyerProductList(userId,pageNum,pageSize);
            }
            //未购买商品列表
            if (type==1){
                return iProductService.getNotBuyProductList(userId,pageNum,pageSize);
            }
        }else if (user.getSalerorbuyer()==0){
            //卖家商品展示
            return iProductService.getSellerProductList(userId,pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMsg("权限错误！");
        }
        return ServerResponse.createByErrorMsg("未知错误！");
    }
}
