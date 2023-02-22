package com.test.openmrs.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy()
    WebElement username;

    @FindBy()
    WebElement password;

    //PLEASE DO NOT USE ANY INDEX FOR ANY LOCATOR EXCEPT TABLES
    @FindBy()
    List<WebElement> locations;

    @FindBy()
    WebElement loginButton;

    @FindBy()
    WebElement errorMessage;

    public void login(String username, String password, String locate){
        this.username.sendKeys(username);
        this.password.sendKeys(password);

        for (WebElement location: locations){
            if (BrowserUtils.getText(location).equals(locate)){
                location.click();
                break;
            }
        }
        loginButton.click();
    }

    public String validateMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
