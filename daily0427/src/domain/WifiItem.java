package domain;

public class WifiItem {
	private int id;
	private String InstallationLocationName;
	private String InstallationLocationDetails;
	private String InstallationCityName;
	private String InstallationDistrictName;
	private String installationFacilityType;
	private String ServiceProviderName;
	private String wifiSsid;
	private String dateOfInstallation;
	private String RoadNameAddress;
	private String LotNumberAddress;
	private String ManagementAgencyName;
	private String ManagementAgencyPhoneNumber;
	private double Latitude;
	private double Longitude;
	private String createdA;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstallationLocationName() {
		return InstallationLocationName;
	}

	public void setInstallationLocationName(String installationLocationName) {
		InstallationLocationName = installationLocationName;
	}

	public String getInstallationLocationDetails() {
		return InstallationLocationDetails;
	}

	public void setInstallationLocationDetails(String installationLocationDetails) {
		InstallationLocationDetails = installationLocationDetails;
	}

	public String getInstallationCityName() {
		return InstallationCityName;
	}

	public void setInstallationCityName(String installationCityName) {
		InstallationCityName = installationCityName;
	}

	public String getInstallationDistrictName() {
		return InstallationDistrictName;
	}

	public void setInstallationDistrictName(String installationDistrictName) {
		InstallationDistrictName = installationDistrictName;
	}

	public String getInstallationFacilityType() {
		return installationFacilityType;
	}

	public void setInstallationFacilityType(String installationFacilityType) {
		this.installationFacilityType = installationFacilityType;
	}

	public String getServiceProviderName() {
		return ServiceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		ServiceProviderName = serviceProviderName;
	}

	public String getWifiSsid() {
		return wifiSsid;
	}

	public void setWifiSsid(String wifiSsid) {
		this.wifiSsid = wifiSsid;
	}

	public String getDateOfInstallation() {
		return dateOfInstallation;
	}

	public void setDateOfInstallation(String dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}

	public String getRoadNameAddress() {
		return RoadNameAddress;
	}

	public void setRoadNameAddress(String roadNameAddress) {
		RoadNameAddress = roadNameAddress;
	}

	public String getLotNumberAddress() {
		return LotNumberAddress;
	}

	public void setLotNumberAddress(String lotNumberAddress) {
		LotNumberAddress = lotNumberAddress;
	}

	public String getManagementAgencyName() {
		return ManagementAgencyName;
	}

	public void setManagementAgencyName(String managementAgencyName) {
		ManagementAgencyName = managementAgencyName;
	}

	public String getManagementAgencyPhoneNumber() {
		return ManagementAgencyPhoneNumber;
	}

	public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
		ManagementAgencyPhoneNumber = managementAgencyPhoneNumber;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public String getCreatedA() {
		return createdA;
	}

	public void setCreatedA(String createdA) {
		this.createdA = createdA;
	}

}
