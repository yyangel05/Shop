package logic;

import java.util.List;

public interface ItemCatalog {
	
	List<Item> getItemList();
	
	//������ no�� �޾Ƽ� ����¥�� �����͸� �������� ����
	Item getItemByItemId(Integer itemId);
}
