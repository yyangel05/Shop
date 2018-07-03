package controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.ItemSet;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;
import exception.CartEmptyException;
import exception.LoginRequiredException;


@Controller
public class CheckoutController {
	
	@Autowired
	private Shop shopService;
	
	@RequestMapping
	public ModelAndView checkOut(HttpSession session) {
		//�α����� Ȯ��
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser == null) {
			throw new LoginRequiredException("�α��εǾ� ���� �ʽ��ϴ�.");
		}
		
		//īƮ�� ���
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if(cart == null || cart.isEmpty()) {
			throw new CartEmptyException("īƮ�� ����ֽ��ϴ�.");
		}
		
		//���� ������ īƮ ���� ��ǰ������ ����
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginUser", loginUser);
		List<ItemSet> itemList = cart.getItemList();
		modelAndView.addObject("itemList", itemList);
		
		//�հ� �ݾ��� ����
		Integer totalAmount = this.shopService.calculateTotalAmount(itemList);
		modelAndView.addObject("totalAmount", totalAmount);
		
		return modelAndView;
	}

}
