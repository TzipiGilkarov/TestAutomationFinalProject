package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class leftMenuPage
{
    @FindBy(className = "css-sr6nr")
    public WebElement btn_serverAdmin;

    @FindBy(xpath="//img[@src='/avatar/46d229b033af06a191ff2267bca9ae56']")
    public WebElement img_avatar;
}
