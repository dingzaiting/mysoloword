package com.dzt.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dzt.entity.Users;
import com.dzt.service.UserService;
import com.dzt.serviceImp.UserServiceImp;

@Controller
@RequestMapping("ssmuser")
public class TestControl {
	@Resource(name="userServiceImp")
	private UserService userServiceImp;

	
	public UserService getUserServiceImp() {
		return userServiceImp;
	}

	public void setUserServiceImp(UserService userServiceImp) {
		this.userServiceImp = userServiceImp;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public String registG(){
		System.out.println("do.....regist");
		return "jsp/regist";
		
	}
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String registP(String username,String password){
		Users users=new Users(username,password);
		int flag= userServiceImp.addUser(users);
		if(flag>0){
		return "jsp/registOk";}
		else {
			return "index";
		}
	}
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	public String login(String username,String password,HttpServletRequest request){
		Users users=new Users(username,password);
		Users users2 = userServiceImp.selectUserByLogin(users);
		System.out.println(request);
		if(users2==null){ return null;}
		else {
			
			HttpSession session = request.getSession();
			session.setAttribute("users", users2);
			return "jsp/loginOk";
		}
	}
	
	
	@RequestMapping(value="addFile",method=RequestMethod.POST)
	public String addFile(@RequestParam MultipartFile pic,HttpServletRequest request,Model model){
		String filename = pic.getOriginalFilename();
		System.out.println("接收到的文件的名字： "+filename);
		String contentType = pic.getContentType();
		System.out.println("接收文件的类型： "+contentType);
		InputStream iStream=null;
		OutputStream oStream=null;
		String realPath = request.getSession().getServletContext().getRealPath("/imgs");
		//得到一个随机的字符串
		String string = UUID.randomUUID().toString();
		String endname = filename.substring(filename.lastIndexOf("."), filename.length());
		try {
			iStream=pic.getInputStream();
			oStream=new FileOutputStream(new File(realPath+"/"+string+endname));
			FileCopyUtils.copy(iStream, oStream);
			oStream.flush();
			oStream.close();
			iStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(realPath+"/"+string+endname+"....");
		
		
		return "index";
	}
	
	public String saveFile(){
		
		
		return "index";
	}
	
	
	
}
