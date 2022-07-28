package web.cruiseline.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class CruiseLineVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer cruiseLineNo;
	private String cruiseLines;
	private byte[] cruiseLinePicture;
	private LocalDate time;
	
	@Override
	public String toString() {
		return "CruiseLineVO [cruiseLineNo=" + cruiseLineNo + ", cruiseLines=" + cruiseLines + ", cruiseLinePicture="
				+ Arrays.toString(cruiseLinePicture) + ", time=" + time + "]";
	}
	public CruiseLineVO() {
		super();
	}
	public CruiseLineVO(Integer cruiseLineNo, String cruiseLines, byte[] cruiseLinePicture, LocalDate time) {
		super();
		this.cruiseLineNo = cruiseLineNo;
		this.cruiseLines = cruiseLines;
		this.cruiseLinePicture = cruiseLinePicture;
		this.time = time;
	}
	public Integer getCruiseLineNo() {
		return cruiseLineNo;
	}
	public void setCruiseLineNo(Integer cruiseLineNo) {
		this.cruiseLineNo = cruiseLineNo;
	}
	public String getCruiseLines() {
		return cruiseLines;
	}
	public void setCruiseLines(String cruiseLines) {
		this.cruiseLines = cruiseLines;
	}
	public byte[] getCruiseLinePicture() {
		return cruiseLinePicture;
	}
	public void setCruiseLinePicture(byte[] cruiseLinePicture) {
		this.cruiseLinePicture = cruiseLinePicture;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	
	
}
