package SanityTests;

import Extentions.verifications;
import Utilities.CommonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class grafanaApi extends CommonOps
{


    @Test(description = "Test01: Add Team and Verify")
    @Description("Test Description: Add Team to Grafana And Verify")
    public void test01_AddTeamAndVerify()
    {
        apiFlows.postTeam("ATeam","a@team.com");
        verifications.text( apiFlows.getTeamProperty("teams[0].name"),"ATeam");
    }


    @Test(description = "Test02: Update Team and Verify")
    @Description("Test Description: Update Team in Grafana And Verify it")
    public void test02_UpdateTeamAndVerifyIt()
    {
        apiFlows.updateTeam("BTeam","a@team.com","4");
        verifications.text( apiFlows.getTeamProperty("teams[0].name"),"BTeam");
    }

    @Test(description = "Test03: Delete Team and Verify")
    @Description("Test Description: Delete Team from Grafana And Verify it")
    public void test03_DeleteTeamAndVerifyIt()
    {
        apiFlows.DeleteTeam("4");
        verifications.text( apiFlows.getTeamProperty("totalCount"),"0");
    }
}
