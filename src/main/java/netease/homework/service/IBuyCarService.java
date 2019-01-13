package netease.homework.service;

import netease.homework.bean.Product;
import netease.homework.common.ServerResponse;

/**
 * Author SMJ
 */
public interface IBuyCarService {
    ServerResponse addToCar(Integer count,Integer productId);
    ServerResponse clearCar(Integer userId);
    ServerResponse listCar(Integer userId);
}
