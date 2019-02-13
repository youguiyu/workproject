package com.ygy.syh.service.wlw;




import com.ygy.syh.domain.wlw.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public interface UserService {

    int addUser(User user);

    List<User> getAllUser();
}
