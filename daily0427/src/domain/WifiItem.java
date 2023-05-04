package domain;

public class WifiItem {
	private int k27_id; // WIFI �������� ID
	private String k27_InstallationLocationName; // WIFI ��ġ ��Ҹ�
	private String k27_InstallationLocationDetails; // WIFI ��ġ ��� �� ����
	private String k27_InstallationCityName; // WIFI ��ġ ���ø�
	private String k27_InstallationDistrictName; // WIFI ��ġ ��/����
	private String k27_InstallationFacilityType; // WIFI ��ġ �ü� ����
	private String k27_ServiceProviderName; // WIFI ���� �����ڸ�
	private String k27_wifiSsid; // WIFI SSID
	private String k27_dateOfInstallation; // WIFI ��ġ ��¥
	private String k27_RoadNameAddress; // WIFI ��ġ ���θ� �ּ�
	private String k27_LotNumberAddress; // WIFI ��ġ ���� �ּ�
	private String k27_ManagementAgencyName; // WIFI ���� �����
	private String k27_ManagementAgencyPhoneNumber; // WIFI ���� ��� ����ó
	private double k27_Latitude; // WIFI ��ġ ����
	private double k27_Longitude; // WIFI ��ġ �浵
	private String k27_created; // WIFI ������ ���� ����

	// ID�� ��ȯ�ϴ� �޼ҵ�
	public int getId() {
		return k27_id;
	}

	// ID�� �����ϴ� �޼ҵ�
	public void setId(int id) {
		this.k27_id = id;
	}

	// ��ġ ��ġ �̸��� ��ȯ�ϴ� �޼ҵ�
	public String getInstallationLocationName() {
		return k27_InstallationLocationName;
	}

	// ��ġ ��ġ �̸��� �����ϴ� �޼ҵ�
	public void setInstallationLocationName(String installationLocationName) {
		k27_InstallationLocationName = installationLocationName;
	}

	// ��ġ ��ġ ���� ������ ��ȯ�ϴ� �޼ҵ�
	public String getInstallationLocationDetails() {
		return k27_InstallationLocationDetails;
	}

	// ��ġ ��ġ ���� ������ �����ϴ� �޼ҵ�
	public void setInstallationLocationDetails(String installationLocationDetails) {
		k27_InstallationLocationDetails = installationLocationDetails;
	}

	// ��ġ ���� �̸��� ��ȯ�ϴ� �޼ҵ�
	public String getInstallationCityName() {
		return k27_InstallationCityName;
	}

	// ��ġ ���� �̸��� �����ϴ� �޼ҵ�
	public void setInstallationCityName(String installationCityName) {
		k27_InstallationCityName = installationCityName;
	}

	// ��ġ �� �̸��� ��ȯ�ϴ� �޼ҵ�
	public String getInstallationDistrictName() {
		return k27_InstallationDistrictName;
	}

	// ��ġ �� �̸��� �����ϴ� �޼ҵ�
	public void setInstallationDistrictName(String installationDistrictName) {
		k27_InstallationDistrictName = installationDistrictName;
	}

	// ��ġ �ü� ������ ��ȯ�ϴ� �޼ҵ�
	public String getInstallationFacilityType() {
		return k27_InstallationFacilityType;
	}

	// ��ġ �ü� ������ �����ϴ� �޼ҵ�
	public void setInstallationFacilityType(String installationFacilityType) {
		this.k27_InstallationFacilityType = installationFacilityType;
	}

	// ���� ���� ��ü �̸��� ��ȯ�ϴ� �޼ҵ�
	public String getServiceProviderName() {
		return k27_ServiceProviderName;
	}

	// ���� ���� ��ü �̸��� �����ϴ� �޼ҵ�
	public void setServiceProviderName(String serviceProviderName) {
		k27_ServiceProviderName = serviceProviderName;
	}

	// WiFi SSID�� ��ȯ�ϴ� �޼ҵ�
	public String getWifiSsid() {
		return k27_wifiSsid;
	}

	// WiFi SSID�� �����ϴ� �޼ҵ�
	public void setWifiSsid(String wifiSsid) {
		this.k27_wifiSsid = wifiSsid;
	}

	// ��ġ ��¥�� ��ȯ�ϴ� �޼ҵ�
	public String getDateOfInstallation() {
		return k27_dateOfInstallation;
	}

	// ��ġ ��¥�� �����ϴ� �޼ҵ�
	public void setDateOfInstallation(String dateOfInstallation) {
		this.k27_dateOfInstallation = dateOfInstallation;
	}

	// ���θ� �ּҸ� ��ȯ�ϴ� �޼ҵ�
	public String getRoadNameAddress() {
		return k27_RoadNameAddress;
	}

	// ���θ� �ּҸ� �����ϴ� �޼ҵ�
	public void setRoadNameAddress(String roadNameAddress) {
		k27_RoadNameAddress = roadNameAddress;
	}

	// ���� �ּҸ� ��ȯ�ϴ� �޼ҵ�
	public String getLotNumberAddress() {
		return k27_LotNumberAddress;
	}

	// ���� �ּҸ� �����ϴ� �޼ҵ�
	public void setLotNumberAddress(String lotNumberAddress) {
		k27_LotNumberAddress = lotNumberAddress;
	}

	// ���� ��� �̸��� ��ȯ�ϴ� �޼ҵ�
	public String getManagementAgencyName() {
		return k27_ManagementAgencyName;
	}

	// ���� ��� �̸��� �����ϴ� �޼ҵ�
	public void setManagementAgencyName(String managementAgencyName) {
		k27_ManagementAgencyName = managementAgencyName;
	}

	// ���� ��� ��ȭ��ȣ�� ��ȯ�ϴ� �޼ҵ�
	public String getManagementAgencyPhoneNumber() {
		return k27_ManagementAgencyPhoneNumber;
	}

	// ���� ��� ��ȭ��ȣ�� �����ϴ� �޼ҵ�
	public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
		k27_ManagementAgencyPhoneNumber = managementAgencyPhoneNumber;
	}

	// ���� ���� ��ȯ�ϴ� �޼ҵ�
	public double getLatitude() {
		return k27_Latitude;
	}

	// ���� ���� �����ϴ� �޼ҵ�
	public void setLatitude(double latitude) {
		k27_Latitude = latitude;
	}

	// �浵 ���� ��ȯ�ϴ� �޼ҵ�
	public double getLongitude() {
		return k27_Longitude;
	}

	// �浵 ���� �����ϴ� �޼ҵ�
	public void setLongitude(double longitude) {
		k27_Longitude = longitude;
	}

	// �������ڸ� ��ȯ�ϴ� �޼ҵ�
	public String getCreatedA() {
		return k27_created;
	}

	// �������ڸ� �����ϴ� �޼ҵ�
	public void setCreated(String created) {
		this.k27_created = created;
	}
}
