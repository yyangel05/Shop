package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return this.itemList;
	}
	
	public boolean isEmpty() {
		if(this.itemList == null || this.itemList.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public void push(ItemSet pushedItemSet) {
		//�߰� ��ǰ�� īƮ�� �̹� �����ϴ��� Ȯ���ϴ� �÷���
		boolean itemExistInCart = false;
		
		//�߰��� ��ǰ�� ��ǰid�� ���
		Item pushedItem = pushedItemSet.getItem();
		int pushedItemId = pushedItem.getItemId().intValue();
		
		//īƮ�� ��ǰ �� ��ŭ �ݺ� ����
		for(ItemSet cartItemSet : this.itemList) {
			
			//īƮ�� �ִ� ��ǰ�� id�� ���
			Item cartItem = cartItemSet.getItem();
			int cartItemId = cartItem.getItemId().intValue();
			
			if(cartItemId == pushedItemId) {
				//���� id�� ��ǰ�� īƮ�� �����ϴ� ���. ������ ����
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				//�߰� ��ǰ�� īƮ �ȿ� �̹� ������
				itemExistInCart = true;
				break;
			}
		}
		
		if(!itemExistInCart) {
			//īƮ�� ���� ��ǰ�� �����Ƿ� �߰�
			this.itemList.add(pushedItemSet);
		}
			
	}
	
	public void clearAll() {
		this.itemList = new ArrayList<ItemSet>();
	}
	
	

}
