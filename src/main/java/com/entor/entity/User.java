package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangfm
 * @since 2019-10-12
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private Integer rid;
	private String aaa;


	public Integer getId() {
		return id;
	}

	public User setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Integer getRid() {
		return rid;
	}

	public User setRid(Integer rid) {
		this.rid = rid;
		return this;
	}

	public String getAaa() {
		return aaa;
	}

	public User setAaa(String aaa) {
		this.aaa = aaa;
		return this;
	}

	public static final String ID = "id";

	public static final String USERNAME = "username";

	public static final String PASSWORD = "password";

	public static final String RID = "rid";

	public static final String AAA = "aaa";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", username=" + username +
			", password=" + password +
			", rid=" + rid +
			", aaa=" + aaa +
			"}";
	}
}
