package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class serverAdminMainPage
{
    @FindBy(xpath="//div/table/tbody")
    public List<WebElement> rows;

    @FindBy(className = "css-u6ysb0-button")
    public WebElement btn_newUser;

}
