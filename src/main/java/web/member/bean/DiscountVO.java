package web.member.bean;

public class DiscountVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer discountNo;
	private String memberLevel;
	private Double Discount;
	private Integer levelQualification;
	
	public DiscountVO(Integer discountNo, String memberLevel, Double discount, Integer levelQualification) {
		super();
		this.discountNo = discountNo;
		this.memberLevel = memberLevel;
		Discount = discount;
		this.levelQualification = levelQualification;
	}

	public DiscountVO() {
		
	}
	
	public Integer getDiscountNo() {
		return discountNo;
	}

	public void setDiscountNo(Integer discountNo) {
		this.discountNo = discountNo;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double discount) {
		Discount = discount;
	}

	public Integer getLevelQualification() {
		return levelQualification;
	}

	public void setLevelQualification(Integer levelQualification) {
		this.levelQualification = levelQualification;
	}
	

}
