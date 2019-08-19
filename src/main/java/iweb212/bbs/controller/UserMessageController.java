package iweb212.bbs.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import iweb212.bbs.model.Message;
import iweb212.bbs.model.Respond;
import iweb212.bbs.service.AdminBbsService;
import iweb212.bbs.service.UserBbsService;
import iweb212.bbs.service.UserService;
import iweb212.bbs.userstate.UserState;

@Controller
public class UserMessageController {
	private UserBbsService userBbsService;
	private AdminBbsService adminBbsService;
	private UserState userState;
	private UserService userService;
	
	@Autowired
	public void setUserBbsService(UserBbsService userBbsService) {
		this.userBbsService = userBbsService;
	}
	@Autowired
	public void setAdminBbsService(AdminBbsService adminBbsService) {
		this.adminBbsService = adminBbsService;
	}
	@Autowired
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@ModelAttribute("userState")
	public UserState userState() {
		return this.userState;
	}
	
	
	@RequestMapping(value="/add-message",method=RequestMethod.POST)
	public String addMessageAction(Message message) {
		
		return "add-message-result";
	}
	@RequestMapping(value= "/home",method=RequestMethod.POST)
	public String addMesage(
			@RequestParam("newMessage") String newMessage,
			Model model) {
		Message message = new Message();
		message.setContext(newMessage);
		message.setPublishedTime(new Date());
		Integer id = userState.getUserId();
		message.setUser(userService.findUserById(id));
		userBbsService.addMessage(message);
		return "redirect:home";
	}
	@RequestMapping(value="/modify-message",method=RequestMethod.GET)
	public String modifyMessage(
			@RequestParam("mid") int messageId,
			Model model) {
		Message message = userBbsService.findMessageById(messageId);
		model.addAttribute("message",message);
		return "modify-message";
	}
	
	@RequestMapping(value="/modify-message",method=RequestMethod.POST)
	public String modifyMessageAction(
			@RequestParam("mid")int messageId,
			@RequestParam("context")String newContext,
			Model model) {
		userBbsService.modifyMessage(messageId, newContext);
		model.addAttribute("result","修改成功");
		return "modify-message-result";
	}
	
	@RequestMapping(value="/delete-message",method=RequestMethod.GET)
	public String deleteCategory(
			@RequestParam("mid")int messageId,
			Model model) {
		Message message = userBbsService.findMessageById(messageId);
		model.addAttribute("message",message);
		return "delete-message";
	}
	
	@RequestMapping(value="/delete-message",method=RequestMethod.POST)
	public String deleteMessageAction(
			@RequestParam("mid") int messageId,
			Model model) {
		userBbsService.deleteMessage(messageId);
		model.addAttribute("result","删除成功");
		return "delete-message-result";
	}
	@RequestMapping(value="/respond",method=RequestMethod.GET)
	public String respondMessage(
			@RequestParam("mid") int messageId,
			Model model) {
		model.addAttribute("mid", messageId);
		return "respond";
	}
	
	@RequestMapping(value="/respond",method=RequestMethod.POST)
	public String respondMessageAction(
			@RequestParam("mid") int mid,
			@RequestParam("context") String context,
			Model model) {
		Respond respond = new Respond();
		respond.setContext(context);
		respond.setMessage(userBbsService.findMessageById(mid));
		respond.setPublishTime(new Date());
		adminBbsService.respondMessage(respond);
		model.addAttribute("result", "添加回复成功");
		return "respond-result";
	}
	@RequestMapping(value = "/delete-respond", method = RequestMethod.GET )
	public String deleteRespond(
			@RequestParam("rid") int id,
			Model model) {
			model.addAttribute("rid", id);
			return "delete-respond";
	}
	@RequestMapping(value = "/delete-respond", method = RequestMethod.POST )
	public String deleteRespondComfirm(
			@RequestParam("rid") int id,
			Model model) {
			adminBbsService.deleteRespond(id);
			model.addAttribute("result", "删除回复成功");
			return "delete-respond-result";
	}
	@RequestMapping(value = "/modify-respond", method = RequestMethod.GET )
	public String modifyRespond(
			@RequestParam("rid") int id,
			Model model) {
			model.addAttribute("rid", id);
			return "modify-respond";
	}
	@RequestMapping(value = "/modify-respond", method = RequestMethod.POST )
	public String modifyRespondForm(
			@RequestParam("rid") int id,
			@RequestParam("context") String newContext,
			Model model) {
			Respond respond = new Respond();
			respond.setId(id);
			respond.setContext(newContext);
			adminBbsService.modifyRespond(respond);
			model.addAttribute("result", "修改回复成功");
			return "modify-respond-result";
	}
}
