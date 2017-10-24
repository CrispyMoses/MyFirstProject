package MyFirstProject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import MyFirstProject.Service.UserService;
import MyFirstProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView mov = new ModelAndView("home");
		mov.addObject("users", userService.getAllUsers());
		mov.addObject("pidor", new User());
		return mov;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String removeUser(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add-user")
	public String addUser(@ModelAttribute("pidor") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
}
