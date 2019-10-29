package com.songchunhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sch.utils.StringUtils;
import com.songchunhao.comon.ArticleType;
import com.songchunhao.comon.ConstClass;
import com.songchunhao.comon.ResultMsg;
import com.songchunhao.entity.Article;
import com.songchunhao.entity.Link;
import com.songchunhao.entity.User;
import com.songchunhao.service.ArticleService;
import com.songchunhao.service.LinkService;
import com.songchunhao.service.UserService;
import com.songchunhao.web.PageUtils;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	
	//自动注入
	@Autowired
	ArticleService articelService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private LinkService linkService;
	
	//页面
	@RequestMapping("index")
	public String index() {
		
		return "admin/index";
	}
	
	//获取友情链接
	@RequestMapping("linklist")
	public String list(HttpServletRequest request) {
		//获取友情链接
		List<Link> linklist = linkService.linklist();
		request.setAttribute("linklist", linklist);
		
		return "admin/article/link";
	}
	
	
	//友情链接添加
	@RequestMapping(value="addlink",method=RequestMethod.GET)
	public String add(HttpServletRequest request) {
		return "admin/addlink";
	}
	
	@RequestMapping(value="addlink",method=RequestMethod.POST)
	@ResponseBody
	public  ResultMsg add(HttpServletRequest request,Link link) {
		
		if(!StringUtils.isUrl(link.getHttp())) {
			return new ResultMsg(2, "url格式不正确，请仔细校验一下格式再来啊", "");
		}
		
		int result =linkService.addLink(link);
		if(result>0) {
			return new ResultMsg(1, "添加成功", "");
		}else {
			return new ResultMsg(2, "添加失败，请与管理员联系", "");
		}
		
		
	}
	
	//友情链接的删除
	@ResponseBody
	@RequestMapping("deletelink")
	public boolean deletelink(Integer id ) {
		int i =linkService.deletelink(id);
		return i>0;
	}
	
	
	/**
	 *  管理员审核文章列表
	 * @param request
	 * @param page  页码
	 * @param status  查询数据的状态
	 * @return
	 */
	@RequestMapping("manArticle")
	public String adminArticle(HttpServletRequest request,
			@RequestParam(defaultValue="1") Integer page
			,@RequestParam(defaultValue="0") Integer status
			) {
		
		// 根据状态和页码获取文章列表数据
		  PageInfo<Article> pageInfo= articelService.getAdminArticles(page,status);
		  request.setAttribute("pageInfo", pageInfo);
		  request.setAttribute("status", status);
		  
		  //生成分页html代码
		  String pageStr = PageUtils.pageLoad(pageInfo.getPageNum(),pageInfo.getPages() , 
				  "/admin/manArticle?status="+status, 10);
		  request.setAttribute("page", pageStr);
		 return "admin/article/list";
		
	}
	
	@RequestMapping("getArticle")
	public String getArticle(HttpServletRequest request,Integer id) {
		
		Article  article = articelService.findById(id);
		
		if (article.getArticleType()==ArticleType.HTML) {
			request.setAttribute("article", article);
			return "admin/article/detail";
		}else {
			Gson gson = new Gson();
			article.setImgList(gson.fromJson(article.getContent(), List.class));
			request.setAttribute("article", article);
		return "admin/slieimgarticle";
	}
		
	}
	
	
	// 查询用户管理 禁用和解封
	@RequestMapping("list")
	public String getList(HttpServletRequest request,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="0") int locked) {
		PageInfo<User> pageInfo = userService.list(page,locked);
		request.setAttribute("pageInfo", pageInfo);
		String pageStr = PageUtils.pageLoad(pageInfo.getPageNum(),pageInfo.getPages() , "/admin/list?locked="+locked, 10);
		request.setAttribute("page", pageStr);
		return "admin/article/userlist";
	}
	
	
	//修改用户管理禁用 和解封
	@ResponseBody
	@RequestMapping("userupadte")
	public boolean userupdate(HttpServletRequest request,Integer id ,String locked) {
		int i =userService.update(id,locked);
			return i>0;
	}
	
	
	/**
	 * 审核文章
	 * @param request
	 * @param articleId  文章的id
	 * @param status  审核后的状态  1 审核通过  2 不通过
	 * @return
	 */
	@RequestMapping("checkArticle")
	@ResponseBody
	public ResultMsg checkArticle(HttpServletRequest request,Integer articleId,int status) {
		
		User login = (User)request.getSession().getAttribute(ConstClass.SESSION_USER_KEY);
		if(login == null) {
			return new ResultMsg(2, "对不起，您尚未登录，不能审核文章", null);
		}
		if(login.getRole()!= ConstClass.USER_ROLE_ADMIN) {
			return new ResultMsg(3, "对不起，您没有权限审核文章", null);
		}
		Article article = articelService.findById(articleId);
		if(article==null) {
			return new ResultMsg(4, "哎呀，没有这篇文章！！", null);
		}
		if(article.getStatus()==status) {
			return new ResultMsg(5, "这篇文章的状态就是您要审核的状态，无需此操作！！", null);
		}
		int result = articelService.updateStatus(articleId,status);
		if(result>0) {
			return new ResultMsg(1, "恭喜，审核成功！！", null);
		}else {
			return new ResultMsg(5, "很遗憾，操作失败，请与管理员联系或者稍后再试！！", null);
		}
	}
	
	
	/**
	 * 设置热门
	 * @param request
	 * @param articleId  文章的id
	 * @param status  热门状态  1 审核通过  2 不通过
	 * @return
	 */
	@RequestMapping("sethot")
	@ResponseBody
	public ResultMsg sethot(HttpServletRequest request,Integer articleId,int status) {
		
		User login = (User)request.getSession().getAttribute(ConstClass.SESSION_USER_KEY);
		if(login == null) {
			return new ResultMsg(2, "对不起，您尚未登录，不能修改文章热门状态", null);
		}
		if(login.getRole()!= ConstClass.USER_ROLE_ADMIN) {
			return new ResultMsg(3, "对不起，您没有权限修改文章热门状态", null);
		}
		Article article = articelService.findById(articleId);
		if(article==null) {
			return new ResultMsg(4, "哎呀，没有这篇文章！！", null);
		}
		if(article.getHot() == status) {
			return new ResultMsg(5, "这篇文章的状态就是您要修改的状态，无需此操作！！", null);
		}
		int result = articelService.updateHot(articleId,status);
		if(result>0) {
			return new ResultMsg(1, "恭喜，审核成功！！", null);
		}else {
			return new ResultMsg(5, "很遗憾，操作失败，请与管理员联系或者稍后再试！！", null);
		}
	}
	

}
