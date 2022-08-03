package com.iu.start.bankBook;

public class BankBookDTO {
	private Long BookNum;
	private String BookName;
	private Double BookRate;
	private Integer BookSale = 1;
	
	
	public Long getBookNum() {
		return BookNum;
	}
	public void setBookNum(Long bookNum) {
		BookNum = bookNum;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public Double getBookRate() {
		return BookRate;
	}
	public void setBookRate(Double bookRate) {
		BookRate = bookRate;
	}
	public Integer getBookSale() {
		return BookSale;
	}
	public void setBookSale(Integer bookSale) {
		BookSale = bookSale;
	}

	
}
