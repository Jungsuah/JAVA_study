package selfproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class crowling {
	public static WebDriver driver;
	public static String base_url = "https://parking.seoul.go.kr/";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\Users\\a\\dev_resources\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		crawl();
	}

	public static void crawl() {
		driver.get(base_url);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 최소가격순으로 정렬

		// 페이지 아래로 내리기
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String[] sigunguList = { "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구",
				"마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" };

		for (int i = 2; i <= sigunguList.length + 1; i++) {
			driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]")).click();
			String xpath = "/html/body/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/ul/li[" + i + "]/a";
			WebElement elementToClick = driver.findElement(By.xpath(xpath));
			elementToClick.click();

			WebElement searchButton = driver
					.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/a"));
			searchButton.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String value = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/div[3]/p/strong")).getText();
			value = value.replace("건", "").trim();
			int ivalue = Integer.parseInt(value);

			for (int index = 0; index < ivalue; index++) {
				WebElement oneClick = driver.findElement(
						By.xpath("/html/body/div[2]/div[4]/div[1]/div[3]/ul/ul[" + (index + 1) + "]/li/strong/a"));
				oneClick.click();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				insertParkingData();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void insertParkingData() {
		String answer = "완료";
		String name = driver.findElement(By.cssSelector("div.hd h3")).getText();
		String addr = driver.findElement(By.cssSelector("div.default span.addr2")).getText();

		WebElement divElement = driver.findElement(By.cssSelector("div.fl"));
		WebElement stitElement = divElement.findElement(By.className("stit"));
		String stitValue = stitElement.getText();

		WebElement stxtElement = divElement.findElement(By.className("stxt"));
		String stxtValue = stxtElement.getText();

		List<WebElement> frElements = driver.findElements(By.className("fr"));
		String frStitValue = "";
		String frStxtValue = "";
		if (!frElements.isEmpty()) {
			WebElement frElement = frElements.get(0);
			WebElement frStit = frElement.findElement(By.className("stit"));
			frStitValue = frStit.getText();

			WebElement frStxt = frElement.findElement(By.className("stxt"));
			frStxtValue = frStxt.getText();
		}

		List<WebElement> aiRightElements = driver.findElements(By.className("ai_right"));
		String aiTitValue = "";
		String aiTxtValue = "";
		if (!aiRightElements.isEmpty()) {
			WebElement aiRightElement = aiRightElements.get(0);
			WebElement aiTitElement = aiRightElement.findElement(By.className("ai_tit"));
			aiTitValue = aiTitElement.getText();

			WebElement aiTxtElement = aiRightElement.findElement(By.className("ai_txt"));
			aiTxtValue = aiTxtElement.getText();
		}

		WebElement elementbasic;
		String basicfee = "";

		try {
			elementbasic = driver.findElement(By.xpath(
					"/html/body/div[2]/div[4]/div[2]/div/div[1]/div[3]/div[1]/div[2]/div/div[6]/div[2211]/div[2]/div/div[2]/div[4]/dl[1]/dd[1]"));
			if (!elementbasic.getText().isEmpty()) {
				basicfee = elementbasic.getText();
			}
		} catch (Exception e) {
			System.out.println("Element for elementbasic not found. Skipping the assignment of basicfee.");
		}

		WebElement elementextra;
		String extrafee = "";

		try {
			elementextra = driver.findElement(By.xpath(
					"/html/body/div[2]/div[4]/div[2]/div/div[1]/div[3]/div[1]/div[2]/div/div[6]/div[2211]/div[2]/div/div[2]/div[4]/dl[1]/dd[2]"));
			extrafee = elementextra.getText();
		} catch (Exception e) {
			System.out.println("Element for extrafee not found. Skipping the assignment of extrafee.");
		}

		List<WebElement> timeElements = driver.findElements(By.cssSelector("dl.time dd"));
		StringBuilder concatenatedValues = new StringBuilder();
		for (WebElement element : timeElements) {
			String f = element.getText();
			concatenatedValues.append(f).append(" ");
		}
		String info = concatenatedValues.toString().trim();

		String insertQuery = "INSERT INTO parking (name, addr, stitValue, stxtValue, frStitValue, frStxtValue, aiTitValue, aiTxtValue, basicfee, extrafee, info) "
				+ "VALUES ('" + name + "', '" + addr + "', '" + stitValue + "', '" + stxtValue + "', '" + frStitValue
				+ "', '" + frStxtValue + "', '" + aiTitValue + "', '" + aiTxtValue + "', '" + basicfee + "', '"
				+ extrafee + "', '" + info + "')";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root",
					"kopoctc");
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(insertQuery);

			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
