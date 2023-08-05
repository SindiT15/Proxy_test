import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ProxyDemo {

    public static void main(String[] args) {

        Proxy proxy =new Proxy();
        proxy.setAutodetect(false);
        proxy.setHttpProxy("localhost:8080");
        proxy.setSslProxy("localhost:8080");

        System.out.println("Starting login test");

        ChromeOptions options=new ChromeOptions();
        options.setCapability("proxy",proxy);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://github.com");

        sleep(2);
        driver.quit();
    }
//    @Test
//    public void loginTest(){
//
//        System.out.println("Starting login test");
//
//        ChromeOptions opt=new ChromeOptions();
//        opt.addArguments("--remote-allow-origins=*");
//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
//        WebDriver driver=new ChromeDriver(opt);
//
//        sleep(1000);
//
//        String url="http://github.com";
//        driver.get(url);
//        System.out.println("Page is opened.");
//    }
    public static void sleep (long m){
        try {
            Thread.sleep(m);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
