package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.UserBean;


import util.DBUtil;

public class UserDao {
	
	//修改用户的密码
	public boolean changeUser(UserBean userBean){
		boolean f= false;
		String sql = "update user set password = '"+userBean.getPassword()+"' where username='"+userBean.getUsername()+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try{
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1)
				f=true;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close( state, conn);
		}
		return f;
	}
	
	//得到用户的信息
	public UserBean findUser(String username){
		String sql = "select * from user where username = '"+username+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		UserBean userBean=new UserBean();
		try{
			state = conn.createStatement();
			rs= state.executeQuery(sql);
			while (rs.next()){
				userBean.setUsername(rs.getString( "username"));
				userBean.setPassword(rs.getString( "password"));
				userBean.setPhone(rs.getString( "phone"));
				userBean.setWorkplace(rs.getString( "workplace"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		
		return userBean;
	}
	
	
	//注册用户
	public boolean addUser(UserBean userBean){
		boolean f = false;
		String sql = "insert into user(username,password,phone,workplace) values('"+userBean.getUsername()+"','"+userBean.getPassword()+"','"+userBean.getPhone()+"','"+userBean.getWorkplace()+"')";
		Connection conn = DBUtil.getConn();
		Statement state =null;
		try{
			state=conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	//判断用户名在不在数据库里
	public String checkUser(String username){
		String sql = "select * from user where username = '"+username+"'";
		String password="";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		
		try{
			state = conn.createStatement();
			rs= state.executeQuery(sql);
			while (rs.next()){
				password=rs.getString("password");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return password;
	}
}
