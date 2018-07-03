package logic;

import java.util.List;

public interface ItemCatalog {
	
	List<Item> getItemList();
	
	//아이템 no를 받아서 한줄짜리 데이터를 가져오기 위함
	Item getItemByItemId(Integer itemId);
}
