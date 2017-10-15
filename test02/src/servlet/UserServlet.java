package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.UserBean;

import dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/servlet/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding( "utf-8");
		String method = req.getParameter( "method");
		
		if(method.equals("register")){
			register(req,resp);
		}
		else if (method.equals( "login")){
			login(req,resp);
		}
		else if (method.equals( "correct")){
			correct(req,resp);
		}
	}
	
	//修改密码
	private void correct(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding( "utf-8");
		String password  =req.getParameter( "password");
		String password1  =req.getParameter( "password1");
		UserBean userBean=(UserBean)req.getSession().getAttribute( "userBean");
		userBean.setPassword(password1);
		UserDao userDao = new UserDao();
		boolean f = userDao.changeUser(userBean);
		if(f==true)
			resp.sendRedirect( req.getContextPath()+"/user/correct.jsp?status=1");
		else
			resp.sendRedirect( req.getContextPath()+"/user/correct.jsp?status=2");
	}
	
	//注册用户
	private void register(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding( "utf-8");
		String username = req.getParameter( "username");
		String password  =req.getParameter( "password");
		String phone = req.getParameter( "phone");
		String workplace = req.getParameter( "workplace");
		
		UserBean userBean = new UserBean(username,password,phone,workplace);
		
		UserDao userDao = new UserDao();
		boolean f = userDao.addUser(userBean);
		if(f==true)
			resp.sendRedirect( req.getContextPath()+"/user/register.jsp?status=1");
		else
			resp.sendRedirect( req.getContextPath()+"/user/register.jsp?status=2");
	}
	
	//登录
	private void login(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		String username = req.getParameter("username");
		UserDao userDao = new UserDao();
		String password1 = userDao.checkUser(username);
		if(!password1.equals( "")){
			String password = req.getParameter( "password");
			if(password1.equals(password)){
				UserBean userBean =userDao.findUser(username);
				req.getSession().setAttribute("userBean",
						userBean);
				resp.sendRedirect( req.getContextPath()+"/main/main.jsp");
			}
			else{
				resp.sendRedirect( req.getContextPath()+"/user/login.jsp?status=1"); //status=1代表密码错误
			}
		}
		else
			resp.sendRedirect( req.getContextPath()+"/user/login.jsp?status=2");  //status=2代表用户名不存在
	}
}
