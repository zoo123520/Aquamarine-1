package com.entor.service.impl;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;
import com.entor.service.IUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangfm
 * @since 2019-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUserByUsername(String username) {
		Wrapper<User> wrapper = new EntityWrapper<>();
		wrapper.eq(User.USERNAME, username);
		List<User> list = selectList(wrapper);
		if (list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
}
