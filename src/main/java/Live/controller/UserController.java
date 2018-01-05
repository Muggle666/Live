package Live.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Live.dao.UserRedisDao;

@RestController
public class UserController {
	
	@Autowired
	UserRedisDao userRedis;
	
	@RequestMapping("/userList")
	public ModelAndView list(Model model) {
		model.addAttribute("users", userRedis.getAll());
		return new ModelAndView("user/userList");
	}
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/hello/{userName}")
	String index(@PathVariable String userName) {
		return "Hello " + userName + " !!!";
	}

}
