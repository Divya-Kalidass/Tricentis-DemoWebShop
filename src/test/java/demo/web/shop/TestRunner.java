package demo.web.shop;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner {

    @BeforeTest
    public void setup(){
        FunctionUtility.reportGeneration();
        FunctionUtility.configureReport();
        BrowserInitiation.launchBrowser("chrome");
        BrowserInitiation.launchUrl("https://demowebshop.tricentis.com/");

    }
    @Test(priority = 1)
    public void registerMethod(){
        Registration.register();
        BrowserInitiation.quitMethod();
    }
    @Test(dataProviderClass = FunctionUtility.class, dataProvider = "logindata",priority = 2)
    public void loginMethod(String emailid, String password){
        Login.loginMethod(emailid,password);
    }



    @Test(priority = 3)
    public void movetodigitaldownload(){
        DigitalDownloads.digitalDownloads();
        DigitalDownloads.addToCard();

    }
    @Test(priority = 4)
    public void enterBillingAddress(){
        CheckoutDetails.billingAddress();
        CheckoutDetails.paymentMethod();
        CheckoutDetails.paymentInformation();
        CheckoutDetails.productDetails();
        CheckoutDetails.confirmOrder();
//        System.out.println("Billing address entered successfully");
    }

    @AfterTest
    public void teardown(){
        FunctionUtility.flushMethod();
        BrowserInitiation.quitMethod();
    }

}
