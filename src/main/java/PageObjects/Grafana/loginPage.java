package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage
{
    @FindBy(name="user")
    public WebElement txt_userName;

    @FindBy(name="password")
    public WebElement txt_password;

    @FindBy(className = "css-6ntnx5-button")
    public WebElement btn_submit;


    @FindBy(className = "css-6ntnx5-button")
    public WebElement btn_skip;
}
