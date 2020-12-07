package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends Base
{
    public static void init()
    {
        grafanaLogin = PageFactory.initElements(driver, PageObjects.Grafana.loginPage.class);
        grafanaMain=PageFactory.initElements(driver, PageObjects.Grafana.mainPage.class);
        grafanaLeftMenu=PageFactory.initElements(driver, PageObjects.Grafana.leftMenuPage.class);
        grafanaServerAdminMenu=PageFactory.initElements(driver, PageObjects.Grafana.serverAdminMenuPage.class);
        grafanaServerAdminMainPage=PageFactory.initElements(driver, PageObjects.Grafana.serverAdminMainPage.class);
        grafanaUserListPage=PageFactory.initElements(driver, PageObjects.Grafana.userListPage.class);
    }
}
