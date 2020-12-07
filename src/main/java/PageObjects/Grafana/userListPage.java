package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userListPage
{
    @FindBy(xpath="//input[@name='name']")
    public WebElement txt_name;

    @FindBy(xpath="//input[@name='email']")
    public WebElement txt_email;

    @FindBy(xpath="//input[@name='login']")
    public WebElement txt_userName;

    @FindBy(xpath="//input[@name='password']")
    public WebElement txt_password;

    @FindBy(className = "css-u6ysb0-button")
    public WebElement btn_createUser;

    @FindBy(xpath="//button[@class='css-1scyk9l-button']")
    public WebElement btn_deleteUser;

    @FindBy(xpath="/html/body/div/div/div[1]/div[2]/div/div[2]/div[1]/button/span")
    public WebElement btn_confirmDelete;

}
