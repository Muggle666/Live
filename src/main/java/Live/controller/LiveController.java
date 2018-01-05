package Live.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Live.model.LiveRedis;
import Live.service.LiveService;

@RestController
public class LiveController {
	
	@Autowired
	private LiveService liveService;
	
	@RequestMapping(value = "/liveList", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		model.addAttribute("live", new LiveRedis());
		return new ModelAndView("liveList");
	}
	
	@RequestMapping(value = "/live", method = RequestMethod.GET)
	public ModelAndView live(Model model, HttpServletRequest request) {
		model.addAttribute("keyName", request.getParameter("keyName"));
		return new ModelAndView("live");
	}
	
	@RequestMapping(value = "/publisher", method = RequestMethod.GET)
	public ModelAndView toPublisher(ModelMap model) {
		model.addAttribute("live", new LiveRedis());
		return new ModelAndView("publisher");
	}
	
	@RequestMapping(value = "/publisher", method = RequestMethod.POST)
	public ModelAndView publisher(@ModelAttribute(value="live") LiveRedis liveRedis, ModelMap model) {
		liveService.save(liveRedis);
		model.addAttribute("liveList", liveService.getAll());
		return new ModelAndView("liveList");
	}

}
