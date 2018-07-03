package controller;

import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import  utils.WebConstants;

@Controller
public class CartController {
	
	@Autowired
	private Shop shopService;
	
	@RequestMapping(value = "/cart/cartAdd")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session) {
		//�߰� ��ǰ ������ ���
		Item selectedItem = this.shopService.getItemByItemId(itemId);
		
		//īƮ�� ���
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if(cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
 		
		//īƮ�� ��ǰ�� �߰�
		cart.push(new ItemSet(selectedItem, quantity));
		
		//īƮ ������ �޼����� ����
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("message", selectedItem.getItemName() + "��/��" + quantity + 
				"�� īƮ�� �߰��߽��ϴ�");
		modelAndView.addObject("cart",cart);
		
		//�α��� ������ ���
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/cart/cartClear")
	public ModelAndView clear(HttpSession session) {
		//īƮ�� ���
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if(cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		
		//īƮ�� Ŭ����
		cart.clearAll();
		
		//�޼����� ����
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("message", "īƮ�� ������ϴ�");
		
		//�α��� ������ ���
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/cart/cartConfirm")
	public ModelAndView confirm(HttpSession session) {
		//īƮ�� ���
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if(cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		
		//īƮ ������ ����
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("cart",cart);
		
		//�α��� ������ ���
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}

}
