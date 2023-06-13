package domain;

public class Stock {
	private String id;// 상품번호
	private int rownum;// 상품번호
	private String name;// 상품명
	private int inventory;// 현재 재고수
	private String checkdate;// 상품등록일
	private String date;// 재고등록일
	private String Content;// 상품설명
	private String url;// 상품사진

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", rownum=" + rownum + ", name=" + name + ", inventory=" + inventory + ", checkdate="
				+ checkdate + ", date=" + date + ", Content=" + Content + ", url=" + url + "]";
	}
}
