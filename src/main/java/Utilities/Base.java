package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

public class Base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imageDiff=new ImageDiffer();
    public static ImageDiff diff;


    public static PageObjects.Grafana.loginPage grafanaLogin;
    public static PageObjects.Grafana.mainPage grafanaMain;
    public static PageObjects.Grafana.leftMenuPage grafanaLeftMenu;
    public static PageObjects.Grafana.serverAdminMenuPage grafanaServerAdminMenu;
    public static PageObjects.Grafana.serverAdminMainPage grafanaServerAdminMainPage;
    public static PageObjects.Grafana.userListPage grafanaUserListPage;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject params=new JSONObject();
    public static JsonPath jp;
}
