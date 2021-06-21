import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTest extends BaseTest {

    @Test
    public void project() {
        open("/login");
        $("#inputEmail").sendKeys(user);
        $("#inputPassword").sendKeys(password);
        $("#btnLogin").click();
        $("#user-menu").shouldBe(Condition.visible);
        $("#createButton").click();
        $("#inputTitle").sendKeys("AntonProject");
        $("#inputCode").sendKeys("AP");
        $("#inputDescription").sendKeys("This my new project");
        $("#public-access-type").click();
        $(".btn-primary").click();
        $(".col").click();
       // $(".project-name").shouldBe(Condition.visible);

    }
}
