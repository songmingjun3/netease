package netease.homework.service.Impl;

import netease.homework.bean.Product;
import netease.homework.common.ServerResponse;
import netease.homework.service.IBuyCarService;
import org.springframework.stereotype.Service;

/**
 * Author SMJ
 */
@Service("iBuyCarService")
public class BuyCarService implements IBuyCarService{
    @Override
    public ServerResponse addToCar(Integer count, Integer productId) {
        return null;
    }

    @Override
    public ServerResponse clearCar(Integer userId) {
        return null;
    }

    @Override
    public ServerResponse listCar(Integer userId) {
        return null;
    }
}
