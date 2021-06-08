import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String user, password;

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
      //  Configuration.browser = "chrome"; //(пример.можно вписать любой браузер)
      //  Configuration.clickViaJs = true;  //(клики Javascript)
        Configuration.headless = true;    //(без отрисовки в браузере,экономия)
        Configuration.startMaximized = true;   //(обязательно. развертка окна браузера)
        Configuration.timeout = 10000;         //(таймаут ожидания обязательно)

    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }
}
