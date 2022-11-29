package testsuit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void browserSetUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredential() {
        //* Enter valid username}
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Krishna12345");
        //* Enter valid password
sendTextToElement(By.cssSelector("div:nth-child(1) div:nth-child(2) form:nth-child(1) div.login:nth-child(4) > input.input"),"kris1234");
        //* Click on ‘LOGIN’ button
clickOnElement(By.xpath("//input[@class='button']"));
        //* Verify the ‘Accounts Overview’ text is display
        verifyMessage("Accounts Overview",getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]")));
    }
    @Test
    public void verifyTheErrorMeaasge(){
        //* Enter invalid username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Krishna127");
        //* Enter invalid password
        sendTextToElement(By.cssSelector("div:nth-child(1) div:nth-child(2) form:nth-child(1) div.login:nth-child(4) > input.input"),"kris127");
        //* Click on Login button
        clickOnElement(By.xpath("//input[@class='button']"));
        //* Verify the error message ‘The username and password could not be verified.’
// Verify the error message 'The username and password could not be verified'.
        //verifyExpectedAndActual(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"),"The username and password could not be verified.");
verifyMessage("The username and password could not be verified",getTextFromElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")));
    }
    @Test
    public void userShouldLogoutSuccessfully(){
        //* Enter valid username
sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"),"Krishna12345");
        //* Enter valid password
sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"),"kris1234");
        //* Click on Login button
clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //** Click on ‘Log Out’ link
clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //* Verify the text ‘Customer Login’
        verifyMessage("Customer Login",getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]")));
    }
        @After
        public void tearDown(){
            closeBrowser();
        }
    }
