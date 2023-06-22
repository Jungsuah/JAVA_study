package selfproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ccc {

    public static WebDriver driver;
    public static String base_url = "https://www.opinet.co.kr/searRgSelect.do";
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\nahyun\\Desktop\\chromedriver.exe";

    public static void main(String[] args) {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        crawl();
        driver.quit();
    }

    public static void crawl() {
        try {
            driver.get(base_url);
            Thread.sleep(5000);

            String[] sigunguList = {
                    "강남구", "강동구", "강북구", "강서구", "관악구",
                    "광진구", "구로구", "금천구", "노원구", "도봉구",
                    "동대문구", "동작구", "마포구", "서대문구", "서초구",
                    "성동구", "성북구", "송파구", "양천구", "영등포구",
                    "용산구", "은평구", "종로구", "중구", "중랑구"
            };

            WebElement sidoSelectElement = driver.findElement(By.cssSelector("#SIDO_NM0"));
            Select sidoSelect = new Select(sidoSelectElement);
            sidoSelect.selectByVisibleText("서울");
            Thread.sleep(5000);

            String xpath = "//*[@id='glopopd_excel']";

            for (String sigungu : sigunguList) {
                WebElement sigunguSelectElement = driver.findElement(By.cssSelector("#SIGUNGU_NM0"));
                Select sigunguSelect = new Select(sigunguSelectElement);
                sigunguSelect.selectByVisibleText(sigungu);
                Thread.sleep(5000);

                WebElement elementGetExcel = driver.findElement(By.xpath(xpath));
                elementGetExcel.click();
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}