package netease.homework.service;

import netease.homework.bean.User;
import netease.homework.common.ServerResponse;

/**
 * Author SMJ
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
}
