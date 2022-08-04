package bobtail.test;


import com.bobtail.listeners.TestListener;
import com.bobtail.pages.HomePage;
import com.bobtail.setup.TestBase;
import com.bobtail.utalities.DataUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})

public class HomeTest extends TestBase {
    HomePage homeObj;


    public HomeTest(){
        super();
    }
    @BeforeTest
    public void homeInitialization(){
        homeObj= new HomePage();
    }

    @Test(priority = 1, dataProviderClass = DataUtils.class, dataProvider = "calDataProvider", enabled = true)
    @Description("User will hit the url and when user will land on the Home page then user will enter " +
            "vat price ")
    @Feature("Home Page")
    @Story("As a user I need to enter the vat price to calculate vat ")
    public void enterVatPriceToCalculate(String data){
        String[] formInfo= data.split(",");
        homeObj.inputVatPrice(formInfo[0]);
        homeObj.clickOnCalculateButton();
    }

    @Test(priority = 2, dataProviderClass = DataUtils.class, dataProvider = "calDataProvider", enabled = true)
    @Description("User will click on the sales tax calulator link and when user will land on sales tax calculator screen")
    @Feature("Home Page")
    @Story("As a user I need to verify/check sales tax ")
    public void checkSalesTax(String data){
        String[] formInfo= data.split(",");
        homeObj.clickOnSalesTaxCalculator();
        homeObj.clickOnSalesTaxCalculatorButton();
    }
}
