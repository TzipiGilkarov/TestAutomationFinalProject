package WorkFlows;

import Extentions.UIActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class webFlows extends CommonOps
{
    @Step("Login grafana flow")
    public static void login(String user,String pass) throws InterruptedException
    {
        UIActions.updateText(grafanaLogin.txt_userName,user);
        UIActions.updateText(grafanaLogin.txt_password,pass);
        UIActions.click(grafanaLogin.btn_submit);
        UIActions.click(grafanaLogin.btn_skip);
    }
    @Step("Create new user")
    public static void createUser(String name,String email,String user,String pass)
    {
        UIActions.click(grafanaServerAdminMainPage.btn_newUser);
        UIActions.updateText(grafanaUserListPage.txt_name,name);
        UIActions.updateText(grafanaUserListPage.txt_email,email);
        UIActions.updateText(grafanaUserListPage.txt_userName,user);
        UIActions.updateText(grafanaUserListPage.txt_password,pass);
        UIActions.click(grafanaUserListPage.btn_createUser);

    }
    @Step("Delete last user")
    public static void deleteLastUser()
    {
        UIActions.click(grafanaServerAdminMainPage.rows.get(grafanaServerAdminMainPage.rows.size()-1));
        UIActions.click(grafanaUserListPage.btn_deleteUser);
        UIActions.click(grafanaUserListPage.btn_confirmDelete);
    }
}
