package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class helperMethods extends CommonOps
{
    public static void takeElementScreenShot(WebElement imgElement, String imgName)
    {
        imageScreenShot = new AShot().takeScreenshot(driver, imgElement);
        try
        {
            ImageIO.write(imageScreenShot.getImage(), "png", new File(getData("ImageRepo") + imgName + ".png"));
        } catch (Exception e)
        {
            System.out.println("Error writing image file, see details: " + e);
        }
    }
}
