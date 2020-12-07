package Extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class verifications extends CommonOps
{
    @Step("Verify text in element")
    public static void textInElement(WebElement elem,String expectedValue)
    {
        assertEquals(elem.getText(),expectedValue);
    }
    @Step("Verify number of elements")
    public static void numberOfElements(List<WebElement> elems,int expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expectedValue);
    }

    @Step("Verify element visually")
    public static void visaulElement(WebElement imageElement, String expecedImageName)
    {
        BufferedImage expectedImage=null;
        try
        {
            expectedImage= ImageIO.read(new File(getData("ImageRepo")+expecedImageName+".png"));

        } catch (IOException e)
        {
            System.out.println("Error reading image file");
        }
        Screenshot imageScreenShot=new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage= imageScreenShot.getImage();
        diff=imageDiff.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(),"Images are not the same");
    }

    @Step("Verify text with text")
    public static void text(String actual,String expected)
    {
        assertEquals(actual,expected);
    }
}
