package web.sightseeing.bean;

import java.io.Serializable;

public class SightseeingMarkVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer sightseeingMarkNo;
	private Integer portOfCallNo;
	private String sightseeingMarkPicture;
	
	
	@Override
	public String toString() {
		return "SightseeingMarkVO [sightseeingMarkNo=" + sightseeingMarkNo + ", portOfCallNo=" + portOfCallNo
				+ ", sightseeingMarkPicture=" + sightseeingMarkPicture + "]";
	}
	public SightseeingMarkVO() {
		super();
	}
	public SightseeingMarkVO(Integer sightseeingMarkNo, Integer portOfCallNo, String sightseeingMarkPicture) {
		super();
		this.sightseeingMarkNo = sightseeingMarkNo;
		this.portOfCallNo = portOfCallNo;
		this.sightseeingMarkPicture = sightseeingMarkPicture;
	}
	public Integer getSightseeingMarkNo() {
		return sightseeingMarkNo;
	}
	public void setSightseeingMarkNo(Integer sightseeingMarkNo) {
		this.sightseeingMarkNo = sightseeingMarkNo;
	}
	public Integer getPortOfCallNo() {
		return portOfCallNo;
	}
	public void setPortOfCallNo(Integer portOfCallNo) {
		this.portOfCallNo = portOfCallNo;
	}
	public String getSightseeingMarkPicture() {
		return sightseeingMarkPicture;
	}
	public void setSightseeingMarkPicture(String sightseeingMarkPicture) {
		this.sightseeingMarkPicture = sightseeingMarkPicture;
	}
	
	
}
