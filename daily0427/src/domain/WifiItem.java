package domain;

public class WifiItem {
	private int k27_id; // WIFI 아이템의 ID
	private String k27_InstallationLocationName; // WIFI 설치 장소명
	private String k27_InstallationLocationDetails; // WIFI 설치 장소 상세 정보
	private String k27_InstallationCityName; // WIFI 설치 도시명
	private String k27_InstallationDistrictName; // WIFI 설치 구/군명
	private String k27_InstallationFacilityType; // WIFI 설치 시설 유형
	private String k27_ServiceProviderName; // WIFI 서비스 제공자명
	private String k27_wifiSsid; // WIFI SSID
	private String k27_dateOfInstallation; // WIFI 설치 날짜
	private String k27_RoadNameAddress; // WIFI 설치 도로명 주소
	private String k27_LotNumberAddress; // WIFI 설치 지번 주소
	private String k27_ManagementAgencyName; // WIFI 관리 기관명
	private String k27_ManagementAgencyPhoneNumber; // WIFI 관리 기관 연락처
	private double k27_Latitude; // WIFI 설치 위도
	private double k27_Longitude; // WIFI 설치 경도
	private String k27_created; // WIFI 아이템 생성 일자

	// ID를 반환하는 메소드
	public int getId() {
		return k27_id;
	}

	// ID를 설정하는 메소드
	public void setId(int id) {
		this.k27_id = id;
	}

	// 설치 위치 이름을 반환하는 메소드
	public String getInstallationLocationName() {
		return k27_InstallationLocationName;
	}

	// 설치 위치 이름을 설정하는 메소드
	public void setInstallationLocationName(String installationLocationName) {
		k27_InstallationLocationName = installationLocationName;
	}

	// 설치 위치 세부 정보를 반환하는 메소드
	public String getInstallationLocationDetails() {
		return k27_InstallationLocationDetails;
	}

	// 설치 위치 세부 정보를 설정하는 메소드
	public void setInstallationLocationDetails(String installationLocationDetails) {
		k27_InstallationLocationDetails = installationLocationDetails;
	}

	// 설치 도시 이름을 반환하는 메소드
	public String getInstallationCityName() {
		return k27_InstallationCityName;
	}

	// 설치 도시 이름을 설정하는 메소드
	public void setInstallationCityName(String installationCityName) {
		k27_InstallationCityName = installationCityName;
	}

	// 설치 구 이름을 반환하는 메소드
	public String getInstallationDistrictName() {
		return k27_InstallationDistrictName;
	}

	// 설치 구 이름을 설정하는 메소드
	public void setInstallationDistrictName(String installationDistrictName) {
		k27_InstallationDistrictName = installationDistrictName;
	}

	// 설치 시설 유형을 반환하는 메소드
	public String getInstallationFacilityType() {
		return k27_InstallationFacilityType;
	}

	// 설치 시설 유형을 설정하는 메소드
	public void setInstallationFacilityType(String installationFacilityType) {
		this.k27_InstallationFacilityType = installationFacilityType;
	}

	// 서비스 제공 업체 이름을 반환하는 메소드
	public String getServiceProviderName() {
		return k27_ServiceProviderName;
	}

	// 서비스 제공 업체 이름을 설정하는 메소드
	public void setServiceProviderName(String serviceProviderName) {
		k27_ServiceProviderName = serviceProviderName;
	}

	// WiFi SSID를 반환하는 메소드
	public String getWifiSsid() {
		return k27_wifiSsid;
	}

	// WiFi SSID를 설정하는 메소드
	public void setWifiSsid(String wifiSsid) {
		this.k27_wifiSsid = wifiSsid;
	}

	// 설치 날짜를 반환하는 메소드
	public String getDateOfInstallation() {
		return k27_dateOfInstallation;
	}

	// 설치 날짜를 설정하는 메소드
	public void setDateOfInstallation(String dateOfInstallation) {
		this.k27_dateOfInstallation = dateOfInstallation;
	}

	// 도로명 주소를 반환하는 메소드
	public String getRoadNameAddress() {
		return k27_RoadNameAddress;
	}

	// 도로명 주소를 설정하는 메소드
	public void setRoadNameAddress(String roadNameAddress) {
		k27_RoadNameAddress = roadNameAddress;
	}

	// 지번 주소를 반환하는 메소드
	public String getLotNumberAddress() {
		return k27_LotNumberAddress;
	}

	// 지번 주소를 설정하는 메소드
	public void setLotNumberAddress(String lotNumberAddress) {
		k27_LotNumberAddress = lotNumberAddress;
	}

	// 관리 기관 이름을 반환하는 메소드
	public String getManagementAgencyName() {
		return k27_ManagementAgencyName;
	}

	// 관리 기관 이름을 설정하는 메소드
	public void setManagementAgencyName(String managementAgencyName) {
		k27_ManagementAgencyName = managementAgencyName;
	}

	// 관리 기관 전화번호를 반환하는 메소드
	public String getManagementAgencyPhoneNumber() {
		return k27_ManagementAgencyPhoneNumber;
	}

	// 관리 기관 전화번호를 설정하는 메소드
	public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
		k27_ManagementAgencyPhoneNumber = managementAgencyPhoneNumber;
	}

	// 위도 값을 반환하는 메소드
	public double getLatitude() {
		return k27_Latitude;
	}

	// 위도 값을 설정하는 메소드
	public void setLatitude(double latitude) {
		k27_Latitude = latitude;
	}

	// 경도 값을 반환하는 메소드
	public double getLongitude() {
		return k27_Longitude;
	}

	// 경도 값을 설정하는 메소드
	public void setLongitude(double longitude) {
		k27_Longitude = longitude;
	}

	// 생성일자를 반환하는 메소드
	public String getCreatedA() {
		return k27_created;
	}

	// 생성일자를 설정하는 메소드
	public void setCreated(String created) {
		this.k27_created = created;
	}
}
