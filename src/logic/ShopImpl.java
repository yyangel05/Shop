package logic;

import java.util.List;
import java.util.Calendar;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopImpl implements Shop {
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@Autowired
	private UserCatalog userCatalog;
	
	@Autowired
	private SaleCatalog saleCatalog;
	

/*	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}
*/
	
	@Override
	public Cart getCart() {
		// TODO Auto-generated method stub
		return new Cart();
	}

	@Override
	public Integer calculateTotalAmount(List<ItemSet> itemList) {
		// TODO Auto-generated method stub
		//합계 금액
		int totalAmount = 0;
		for(ItemSet itemSet : itemList) {
			int price = itemSet.getItem().getPrice().intValue();
			int quantity = itemSet.getQuantity().intValue();
			totalAmount = totalAmount + (price * quantity);
		}
				
		return new Integer(totalAmount);
	}

	@Override
	public void checkout(User user, Cart cart) {
		// TODO Auto-generated method stub
		//매상 정보 작성
		Sale sale = createSale(user, cart);
		//매상 정보 등록
		entrySale(sale);
	}

	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return this.itemCatalog.getItemList();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return this.itemCatalog.getItemByItemId(itemId);
	}

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return this.userCatalog.getUserByUserIdAndPassword(userId, password);
	}

	@Override
	public void entryUser(User user) {
		// TODO Auto-generated method stub
		this.userCatalog.entryUser(user);
	}

	private void entrySale(Sale sale) {
		this.saleCatalog.entrySale(sale);
	}
	
	private Sale createSale(User user, Cart cart) {
		//매상 정보 작성 
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId());
		sale.setUser(user);
		Timestamp currentTime = getCurrentTime();
		sale.setUpdateTime(currentTime);
		
		//카트 상품 종류별 매상 명세정보를 작성
		List<ItemSet> itemList = cart.getItemList();
		for(int i=0; i<itemList.size() ; i++) {
			ItemSet itemSet = (ItemSet) itemList.get(i);
			//매상 상세 id는 첫 번째부터 설정
			int saleLineId = i+1;
			SaleLine saleLine = createSaleLine(sale, saleLineId, itemSet, currentTime);
			sale.addSaleLine(saleLine);
		}
		
		return sale;
	}


	private Integer getNewSaleId() {
		// TODO Auto-generated method stub
		return this.saleCatalog.getNewSaleId();
	}
	
	private Timestamp getCurrentTime() {
		// TODO Auto-generated method stub
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	
	private SaleLine createSaleLine(Sale sale, int saleLineId, ItemSet itemSet, Timestamp currentTime) {
		// TODO Auto-generated method stub
		return new SaleLine(sale, new Integer(saleLineId), itemSet, currentTime);
	}
	
}
