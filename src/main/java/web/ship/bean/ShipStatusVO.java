package web.ship.bean;

import java.io.Serializable;

public class ShipStatusVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer shipStatusNo;
	private String shipStatus;
	
	
	
	public ShipStatusVO() {
		super();
	}
	public ShipStatusVO(Integer shipStatusNo, String shipStatus) {
		super();
		this.shipStatusNo = shipStatusNo;
		this.shipStatus = shipStatus;
	}
	public Integer getShipStatusNo() {
		return shipStatusNo;
	}
	public void setShipStatusNo(Integer shipStatusNo) {
		this.shipStatusNo = shipStatusNo;
	}
	public String getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
	

}
