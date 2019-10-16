package com.entor.service;

import com.entor.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangfm
 * @since 2019-10-12
 */
public interface IUserService extends IService<User> {
	
	/**
	 * 更具用户名查找对象
	 * @param username
	 * @return
	 */
	public User queryUserByUsername(String username);
}
