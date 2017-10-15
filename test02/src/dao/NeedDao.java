package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import bean.NeedBean;

public class NeedDao {
	
	//根据序号修改状态信息，以及添加修改意见到数据库里
	public boolean isPass(int nd_id,int nd_state,String nd_advice){
		boolean f = false;
		boolean f1=false;
		boolean f2=false;
		String sql = "update need set nd_advice='"+nd_advice+"' where nd_id='"+nd_id+"'";
		Connection conn = DBUtil.getConn();
		Statement state =null;
		try{
			state=conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f1=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		f2=changeState(nd_id,nd_state);
		if(f1==true&&f2==true){
			f=true;
		}
		return f;
	}
	
	//根据序号修改状态信息
	public boolean changeState(int nd_id,int nd_state){
		boolean f = false;
		String sql = "update need set nd_state='"+nd_state+"' where nd_id='"+nd_id+"'";
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
	
	//根据序号查询需求的详细信息
	public NeedBean singleNeed(int nd_id){
		String sql = "select * from need where nd_id= '"+nd_id+"'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =new NeedBean();
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setNd_name( rs.getString( "nd_name"));
				needBean.setNd_ms( rs.getString( "nd_ms"));
				needBean.setNd_type( rs.getString( "nd_type"));
				needBean.setNd_pa(rs.getInt( "nd_pa")) ;
				needBean.setNd_money(rs.getFloat( "nd_money"));
				needBean.setNd_state(rs.getInt( "nd_state"));
				needBean.setNd_time(rs.getDate( "nd_time"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBean;
	}
	
	//通过名称查询技术需求信息
	public List<NeedBean> findNeedByName(String nd_name){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need where nd_name='"+nd_name+"'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setNd_name( rs.getString( "nd_name"));
				needBean.setNd_ms( rs.getString( "nd_ms"));
				needBean.setNd_type( rs.getString( "nd_type"));
				needBean.setNd_pa(rs.getInt( "nd_pa")) ;
				needBean.setNd_money(rs.getFloat( "nd_money"));
				needBean.setNd_state(rs.getInt( "nd_state"));
				needBean.setNd_time(rs.getDate( "nd_time"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	//通过状态查询所有的技术需求信息
	public List<NeedBean> findNeedByState(int nd_state){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need where nd_state='"+nd_state+"'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setNd_name( rs.getString( "nd_name"));
				needBean.setNd_ms( rs.getString( "nd_ms"));
				needBean.setNd_type( rs.getString( "nd_type"));
				needBean.setNd_pa(rs.getInt( "nd_pa")) ;
				needBean.setNd_money(rs.getFloat( "nd_money"));
				needBean.setNd_state(rs.getInt( "nd_state"));
				needBean.setNd_time(rs.getDate( "nd_time"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	//浏览需求
	public List<NeedBean> listNeed(){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setNd_name( rs.getString( "nd_name"));
				needBean.setNd_ms( rs.getString( "nd_ms"));
				needBean.setNd_type( rs.getString( "nd_type"));
				needBean.setNd_pa(rs.getInt( "nd_pa")) ;
				needBean.setNd_money(rs.getFloat( "nd_money"));
				needBean.setNd_state(rs.getInt( "nd_state"));
				needBean.setNd_time(rs.getDate( "nd_time"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	//添加需求到数据库里
	public boolean addNeed(NeedBean needBean){
		boolean f = false;
		String sql = "insert into need(nd_name,nd_ms,nd_type,nd_pa,nd_money,nd_state,nd_time) values('"+needBean.getNd_name()+"','"+needBean.getNd_ms()+"','"+needBean.getNd_type()+"','"+needBean.getNd_pa()+"','"+needBean.getNd_money()+"','"+needBean.getNd_state()+"',now())";
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
}
