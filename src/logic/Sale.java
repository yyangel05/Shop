package logic;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Sale implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer saleId;
	private User user;
	private Timestamp updateTime;
	
	private List<SaleLine> saleLineList = new ArrayList<SaleLine>();

	public void addSaleLine(SaleLine saleLine) {
		this.saleLineList.add(saleLine);
	}
	
	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<SaleLine> getSaleLineList() {
		return saleLineList;
	}

	public void setSaleLineList(List<SaleLine> saleLineList) {
		this.saleLineList = saleLineList;
	}
	
	
	
	

}
