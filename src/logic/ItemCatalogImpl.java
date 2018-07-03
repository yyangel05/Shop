package logic;

import java.util.List;
import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog {
	
	private ItemDao itemDao ;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return this.itemDao.findAll();
	}	
	
	//아이템 아이디를 파라미터로 받아 아이템 정보를 가져온다
	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}

}
