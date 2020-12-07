package SanityTests;

import Extentions.UIActions;
import Extentions.verifications;
import Utilities.CommonOps;
import WorkFlows.webFlows;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners (Utilities.listeners.class)

public class grafanaWeb extends CommonOps
{
    @Test (description = "Test01: Login to Grafana")
    @Description("Test Description: login to grafana web application")
    public void test01_Login() throws InterruptedException
    {
        webFlows.login(getData("user"),getData("password"));
        verifications.textInElement(grafanaMain.txt_mainHeader,"Welcome to Grafana");
    }

    @Test(description = "Test02: Verify default users")
    @Description("Test Description: Verify the default number of users should be 1")
    public void test02_verifyDefaultUser() throws InterruptedException
    {
        UIActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenu.lnk_users);
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,1);
    }

    @Test(description = "Test03: Add and verify users")
    @Description("Test Description: Add a new user and verify the number of users is 2")
    public void test03_addAndVerifyUsers() throws InterruptedException
    {
        UIActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenu.lnk_users);
        webFlows.createUser("Tzipi", "Tzipi@gmail.com", "TG", "12345");
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,2);
    }

    @Test(description = "Test04: Delete the last user and verify")
    @Description("Test Description: delete the last user and verify the number of users is 1")
    public void test04_deleteandVerifyUser() throws InterruptedException
    {
        UIActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenu.lnk_users);
        webFlows.deleteLastUser();
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,1);
    }
    @Test(description = "Test05: Verify Avatar")
    @Description("Test Description: Verify Grafana's default (admin) Avatar")
    public void test05_VerifyAvatar()
    {
        verifications.visaulElement(grafanaLeftMenu.img_avatar,"avatar");
    }
    }


