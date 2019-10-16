package com.entor.realm;


import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.entor.entity.User;
import com.entor.service.IUserService;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private SessionDAO sessionDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		// 这里做权限控制
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 这里做登录控制
		UsernamePasswordToken t = (UsernamePasswordToken)token;
		//传递过来的帐号
		String username = t.getUsername();
		//传递过来的密码
		String password = new String(t.getPassword());
		//根据帐号获取对象
		User users = userService.queryUserByUsername(username);
		//校验
		if (users==null||!users.getPassword().equals(password)) {
			throw new AuthenticationException();
		}
		
		// 清除当前用户登陆会话，只允许一次登录
		Collection<Session> sessions = sessionDao.getActiveSessions();
		for(Session session:sessions) {
			// 获取会话中的用户名
			String uname = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			if(uname.equals(username)) {
				// 移除会话
				System.out.println("清理用户["+uname+"],SessionId为["+session.getId()+"]的Session信息!");
				session.setTimeout(0);
				break;
			}
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(users,users.getPassword(),getName());
		return info;
	}
}
