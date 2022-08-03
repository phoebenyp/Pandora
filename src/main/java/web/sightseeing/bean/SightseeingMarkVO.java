package web.sightseeing.bean;

import java.io.Serializable;
import java.util.Arrays;

public class SightseeingMarkVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer sightseeingMarkNo;
	private Integer portOfCallNo;
	private byte[] sightseeingMarkPicture;
	
	@Override
	public String toString() {
		return "SightseeingMarkVO [sightseeingMarkNo=" + sightseeingMarkNo + ", portOfCallNo=" + portOfCallNo
				+ ", sightseeingMarkPicture=" + Arrays.toString(sightseeingMarkPicture) + "]";
	}
	public SightseeingMarkVO() {
		super();
	}
	public SightseeingMarkVO(Integer sightseeingMarkNo, Integer portOfCallNo, byte[] sightseeingMarkPicture) {
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
	public byte[] getSightseeingMarkPicture() {
		return sightseeingMarkPicture;
	}
	public void setSightseeingMarkPicture(byte[] sightseeingMarkPicture) {
		this.sightseeingMarkPicture = sightseeingMarkPicture;
	}
	
	
}
