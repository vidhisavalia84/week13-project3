package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void browserSetUp(){
        openBrowser(baseUrl);
    }
@Test
public void verifyThatSigningUpPageDisplay(){
        //* click on the ‘Register’ link
clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
    //* Verify the text ‘Signing up is easy!’
    verifyMessage("Signing up is easy!",getTextFromElement(By.xpath("//div[@id='rightPanel']/h1")));
}
@Test
public void userShouldRegisterAccountSuccessfully(){
       //* click on the ‘Register’ link
    clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
    //* Enter First name
  sendTextToElement(By.id("customer.firstName"),"Krishna1");
    //* Enter Last name
    sendTextToElement(By.id("customer.lastName"),"vara1");
    //* Enter Address
sendTextToElement(By.id("customer.address.street"),"123, abc road");
//* Enter City
sendTextToElement(By.id("customer.address.city"),"Delhi");
//* Enter State
sendTextToElement(By.id("customer.address.state"),"Gujarat");
//* Enter Zip Code
sendTextToElement(By.id("customer.address.zipCode"),"0123456");
    //* Enter Phone
    sendTextToElement(By.id("customer.phoneNumber"),"07912345698");
    //Enter SSN
    sendTextToElement(By.id("customer.ssn"),"asdfg");
    //* Enter Username
    sendTextToElement(By.id("customer.username"),"Krishna12345");
    //* Enter Password
    sendTextToElement(By.id("customer.password"),"kris1234");
    //* Enter Confirm
    sendTextToElement(By.id("repeatedPassword"),"kris1234");
    //* Click on REGISTER button
clickOnElement(By.xpath("//input[@value='Register']"));
    //* Verify the text 'Your account was created successfully. You are now logged in.’
    String actualText="Your account was created successfully. You are now logged in.";
    String expectedText=getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
    Assert.assertEquals(actualText,expectedText);

}


@After
    public void tearDown(){
        closeBrowser();
}
}
