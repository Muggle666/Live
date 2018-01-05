package Live.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Live.model.UserRedis;
import Live.service.LiveService;
import Live.service.UserService;

@RestController
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LiveService liveService;
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public ModelAndView toRegister(ModelMap model) {
		model.addAttribute("user", new UserRedis());
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(value = "user") UserRedis user, HttpSession session, ModelMap model) {
		userService.save(user);
		session.setAttribute("user", user);
		model.addAttribute("liveList", liveService.getAll());
		return new ModelAndView("liveList");
	}

}
