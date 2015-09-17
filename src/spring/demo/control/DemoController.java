package spring.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.demo.service.DemoService;

/**
 * 
 * @Description: Controller
 * @author: Bing Yue
 */
@Controller
public class DemoController {
	
	@Autowired  
	private DemoService demoService;
	

	@RequestMapping("login")
	private ModelAndView login(@RequestParam(value = "username", required = false)String username,
			@RequestParam(value = "password", required = false)String password){
		   String result=demoService.Verify(username,password);
		   ModelAndView mv=new ModelAndView();
		  //添加模型，可以是任意的POJO对象
		  mv.addObject("validation",result);
		  //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		  //即cityAir.jsp
		  mv.setViewName("result");
		  return mv;
	}
	
}
