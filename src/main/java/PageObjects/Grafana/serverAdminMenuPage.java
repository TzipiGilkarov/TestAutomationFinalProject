package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class serverAdminMenuPage
{
    @FindBy(xpath="//a[@href='/admin/users\']")
    public WebElement lnk_users;

    @FindBy(xpath="//a[@href='/admin/orgs\']")
    public WebElement lnk_orgs;

    @FindBy(xpath="//a[@href='/admin/settings\']")
    public WebElement lnk_settings;

    @FindBy(xpath="//a[@href='/admin/stats\']")
    public WebElement lnk_stats;

    @FindBy(xpath="//a[@href='/admin/upgrading\']")
    public WebElement lnk_upgradind;
}
