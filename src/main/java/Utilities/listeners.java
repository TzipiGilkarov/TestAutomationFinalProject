package Utilities;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestListener;

public class listeners extends CommonOps implements ITestListener
{

        public void onFinish(ITestContext arg0)
        {
            System.out.println("-----ending execution-----");
        }

        public void onStart(ITestContext arg0)
        {
            System.out.println("-----starting execution-----");
        }

        public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
        {
            // TODO Auto-generated method stub
        }

        public void onTestFailure(ITestResult arg0)
        {
            System.out.println("-----starting test: "+arg0.getName()+" failed------------");
            if(!getData("PlatformName").equalsIgnoreCase("api"))
            saveScreenShot();
        }

        public void onTestSkipped(ITestResult arg0)
        {
            System.out.println("-----skipping test: "+arg0.getName()+"-----");
        }

        public void onTestStart(ITestResult arg0)
        {
            System.out.println("-----starting test: "+arg0.getName()+"-----");
        }

        public void onTestSuccess(ITestResult arg0)
        {
            System.out.println("-----starting test: "+arg0.getName()+" passed------");
        }

     @Attachment(value = "Page Screen-Shot",type = "image/png")
        public byte[] saveScreenShot()
{
    return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
}
}
