package com.yc.ums.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yc.ums.entity.Profile;
import com.yc.ums.entity.ProfileBean;
import com.yc.ums.service.ProfileService;
import com.yc.ums.service.impl.ProfileServiceImple;
import com.yc.ums.util.ServletUtil;
@WebServlet("/user/*")
public class ProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	ProfileService us;
	public ProfileServlet() {
		us=new ProfileServiceImple();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String reqName=ServletUtil.getUriName(request.getRequestURI());
		System.out.println("进入ProfileServlet中，进行"+reqName+"请求处理");
		switch (reqName) {
		
			case "list":
				doList(request,response);
				break;
			case "modify":
				doModify(request,response);
				break;
	
			default:
				respOutStr(response, "<h1><span style='color:red;font-size:50px'>404!!!</span>未找到</h1>");
		}
	}
	private void doModify(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Profile profile=getReqParam2Obj(request, Profile.class);
		//System.out.println(profile);
		boolean b=us.modifyProfile(profile);
		respOutStr(response, toJsonStr(b));
		
	}
	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*List<Profile> us=Arrays.asList(new Profile(1, "a", "a", "a","a", "a", "a"),
		new Profile(1, "a", "a", "a","a", "a", "a"));
		respOutStr(response, toJsonStr(us));*/
		
		
		/*List<Profile> liat=us.listProfile();
		respOutStr(response, toJsonStr(liat));*/
		String currPage=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		ProfileBean profileBean=us.listPaginationProfile(currPage,pageSize);
		respOutStr(response, toJsonStr(profileBean));
	}
}
