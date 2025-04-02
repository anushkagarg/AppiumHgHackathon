package Hackathon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    private WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"App\"]")
    public WebElement link_appLink;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")
    public WebElement link_alertDialogLink;

    @FindBy(id = "io.appium.android.apis:id/two_buttons")
    public WebElement link_alertFirstOptionLink;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Single choice list\"]")
    public WebElement link_singleChoiceLink;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Street view\"]")
    public WebElement radioButton_streetView;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement button_saveSingleList;

    //entry dialog

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Text Entry dialog\"]")
    public WebElement link_textEntryLink;
    @FindBy(id = "io.appium.android.apis:id/username_edit")
    public WebElement input_userNameTextEntry;
    @FindBy(id = "io.appium.android.apis:id/password_edit")
    public WebElement input_passwordTextEntry;

    //handling repeat
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Repeat alarm\"]")
    public WebElement link_repeatAlarmLink;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Photos\"]")
    public WebElement link_photosLink;
    @FindBy(xpath = "//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[5]")
    public WebElement swiped_imageFifth;


    //animation page main
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Animation\"]")
    public WebElement link_animationLinkMain;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"View Flip\"]")
    public WebElement link_viewFlipUnderAnimation;
    @FindBy(id = "io.appium.android.apis:id/button")
    public WebElement button_viewFlip;

}
