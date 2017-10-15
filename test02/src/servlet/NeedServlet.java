package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NeedDao;

import bean.NeedBean;

/**
 * Servlet implementation class NeedServlet
 */
@WebServlet("/servlet/needServlet")
public class NeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding( "utf-8");
		String method=req.getParameter( "method");
		if(method.equals( "addNeed"))
			addNeed(req,resp);
		else if(method.equals( "listNeed"))
			listNeed(req,resp);
		else if(method.equals( "listDetail"))
			listNeed(req,resp);
		else if(method.equals( "find"))
			findNeed(req,resp);
		else if(method.equals( "lookNeed"))
			lookNeed(req,resp);
		else if(method.equals( "isPass"))
			isPass(req,resp);
	}
	
	//添加审核意见修改审核状态
	private void isPass(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		int nd_id=Integer.parseInt(req.getParameter( "nd_id"));
		int nd_state =Integer.parseInt(req.getParameter( "nd_state")) ;
		String nd_advice = req.getParameter( "nd_advice");
		
		NeedDao needDao = new NeedDao();
		boolean f = needDao.isPass(nd_id, nd_state, nd_advice);
		
		if(f==true)
			resp.sendRedirect( req.getContextPath()+"/servlet/needServlet?method=lookNeed&status=3");
		else
			resp.sendRedirect( req.getContextPath()+"/servlet/needServlet?method=lookNeed&status=4");
	}
	
	//审核信息
	private void lookNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		String nd_id=req.getParameter( "nd_id");
		if (nd_id == null) {
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();

			needBeans = needDao.findNeedByState(1);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/look/look.jsp?status=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/look/look.jsp?status=2").forward(
						req, resp);
		}
		else{
			NeedBean needBean = new NeedBean();
			NeedDao needDao = new NeedDao();
			int nd_id1=Integer.parseInt(nd_id);
			needBean = needDao.singleNeed(nd_id1);
			req.setAttribute("needBean", needBean);
			if (needBean != null) {
				req.getRequestDispatcher("/look/lookDetail.jsp").forward(
						req, resp);
			} 
		}
	}
	
	//查询需求信息
	private void findNeed(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		String nd_name = req.getParameter("nd_name");
		int nd_state = Integer.parseInt(req.getParameter("nd_state"));
		List<NeedBean> needBeans = null;
		NeedDao needDao = new NeedDao();
		if (nd_name != ""){
			nd_state=0;
			needBeans = needDao.findNeedByName(nd_name);
		}
		if (nd_state != 0)
			needBeans = needDao.findNeedByState(nd_state);
		
		req.setAttribute("needBeans", needBeans);

		if (needBeans != null) {
			req.getRequestDispatcher("/need/list.jsp?status=1").forward(req,
					resp);
		} else
			req.getRequestDispatcher("/need/list.jsp?status=2").forward(req,
					resp);
	}
		
	
	
	//浏览需求信息
	private void listNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		String nd_id=req.getParameter( "nd_id");
		if (nd_id == null) {
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();

			needBeans = needDao.listNeed();
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/need/list.jsp?status=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/need/list.jsp?status=2").forward(
						req, resp);
		}
		else{
			NeedBean needBean = new NeedBean();
			NeedDao needDao = new NeedDao();
			int nd_id1=Integer.parseInt(nd_id);
			needBean = needDao.singleNeed(nd_id1);
			req.setAttribute("needBean", needBean);
			if (needBean != null) {
				req.getRequestDispatcher("/need/listDetail.jsp").forward(
						req, resp);
			} 
		}
	}
	
	//获取需求信息添加到数据库
	private void addNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding( "utf-8");
		String nd_name = req.getParameter( "nd_name");
		String nd_ms = req.getParameter( "nd_ms");
		String[] nd_types1=req.getParameterValues( "nd_type");
		String nd_type="";
		for(String nd_type1:nd_types1){
			if(nd_type1!=null&&!nd_type1.equals(nd_types1[0]))
				nd_type+=",";
			if(nd_type1.equals("1"))
				nd_type+="基础研究";
			else if(nd_type1.equals("2"))
				nd_type+="应用研究";
			else if(nd_type1.equals("3"))
				nd_type+="实验发展";
			else if(nd_type1.equals("4"))
				nd_type+="研究发展与成果应用";
			else if(nd_type1.equals("5"))
				nd_type+="技术推广与科技服务";
			
		}
		int nd_pa = Integer.parseInt(req.getParameter( "nd_pa"));
		float nd_money = Float.parseFloat( req.getParameter( "nd_money"));
		
		NeedBean needBean = new NeedBean(nd_name,nd_ms,nd_type,nd_pa,nd_money);
		needBean.setNd_state(1);
		NeedDao needDao= new NeedDao();
		boolean f = needDao.addNeed(needBean);
		if(f==true){
			resp.sendRedirect( req.getContextPath()+"/need/add.jsp?status=1");
		}
		else
			resp.sendRedirect( req.getContextPath()+"/need/add.jsp?status=2");
	}
}
