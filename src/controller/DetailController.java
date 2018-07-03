package controller;

import java.util.HashMap;
import java.util.Map;

import logic.Item;
import logic.Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController {
	
	private Shop shopService;
	
	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	@RequestMapping
	public ModelAndView detailItem(Integer itemId) {
		//���õ� ��ǰ id���� ��ǰ ������ ���
		Item item = this.shopService.getItemByItemId(itemId);
		
		//�� ����
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);
		
		//��ȯ���� ModelAndView�ν��Ͻ� ����
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addAllObjects(model);
		
		return modelAndView;		
		
	}
}
