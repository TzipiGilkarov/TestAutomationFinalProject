package Helpers;

import Utilities.CommonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

public class visualTesting extends CommonOps
{
    @Test
    public void createScreenShot() throws InterruptedException
    {
        webFlows.login("admin","admin");
       helperMethods.takeElementScreenShot(grafanaLeftMenu.img_avatar,"avatar_v1");
    }
}
