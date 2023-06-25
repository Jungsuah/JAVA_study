package domain;

public class parking {
	private int id;
	private String name;
	private String addr;
	private String stitValue;
	private String stxtValue;
	private String frStitValue;
	private String frStxtValue;
	private String aiTitValue;
	private String aiTxtValue;
	private String basicfee;
	private String extrafee;
	private String info;
	private String latitude;
	private String longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getStitValue() {
		return stitValue;
	}

	public void setStitValue(String stitValue) {
		this.stitValue = stitValue;
	}

	public String getStxtValue() {
		return stxtValue;
	}

	public void setStxtValue(String stxtValue) {
		this.stxtValue = stxtValue;
	}

	public String getFrStitValue() {
		return frStitValue;
	}

	public void setFrStitValue(String frStitValue) {
		this.frStitValue = frStitValue;
	}

	public String getFrStxtValue() {
		return frStxtValue;
	}

	public void setFrStxtValue(String frStxtValue) {
		this.frStxtValue = frStxtValue;
	}

	public String getAiTitValue() {
		return aiTitValue;
	}

	public void setAiTitValue(String aiTitValue) {
		this.aiTitValue = aiTitValue;
	}

	public String getAiTxtValue() {
		return aiTxtValue;
	}

	public void setAiTxtValue(String aiTxtValue) {
		this.aiTxtValue = aiTxtValue;
	}

	public String getBasicfee() {
		return basicfee;
	}

	public void setBasicfee(String basicfee) {
		this.basicfee = basicfee;
	}

	public String getExtrafee() {
		return extrafee;
	}

	public void setExtrafee(String extrafee) {
		this.extrafee = extrafee;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "parking [id=" + id + ", name=" + name + ", addr=" + addr + ", stitValue=" + stitValue + ", stxtValue="
				+ stxtValue + ", frStitValue=" + frStitValue + ", frStxtValue=" + frStxtValue + ", aiTitValue="
				+ aiTitValue + ", aiTxtValue=" + aiTxtValue + ", basicfee=" + basicfee + ", extrafee=" + extrafee
				+ ", info=" + info + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
