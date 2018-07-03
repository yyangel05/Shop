package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import logic.Shop;
import logic.User;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utils.UserEntryValidator;

@Controller
public class UserEntryFormController {
	
	private Shop shopService;
	private UserEntryValidator userEntryValidator;
	private MessageSource messageSource;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setUserEntryValidator(UserEntryValidator userEntryValidator) {
		this.userEntryValidator = userEntryValidator;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@RequestMapping(method = RequestMethod.GET) 
	public String toUserEntryView() {
		return "userEntry";
	}
	
	@ModelAttribute
	public User setUpForm() {
		User user = new User(); //user객체 생성
		MessageSourceAccessor accessor = new MessageSourceAccessor(this.messageSource);
		user.setUserId(accessor.getMessage("user.userId.default")); //입력폼에 미리 메세지를 나타나게 한다. placeholder과 비슷함
		user.setUserName(accessor.getMessage("user.userName.default")); //입력폼에 미리 메세지를 나타나게 한다. placeholder과 비슷함
		return user;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception{
		//Data타입의 birthday 프로퍼티를 커스터마이즈
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"birthDay", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ModelAndView onSubmit(User user, BindingResult bindingResult) throws Exception {
		
		this.userEntryValidator.validate(user, bindingResult);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		
		try {
			this.shopService.entryUser(user);
			modelAndView.setViewName("userEntrySuccess");
			modelAndView.addObject("user",user);
			return modelAndView;
		} catch(DataIntegrityViolationException e) {
			//유저 id가 중복일 때, 폼 송신처로 이동
			bindingResult.reject("error.duplicate.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}		
	}
}
