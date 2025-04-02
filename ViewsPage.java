package Hackathon.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewsPage {
    private WebDriver driver;

    public ViewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /*public ViewsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }*/

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    public WebElement link_viewsLink;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
    public WebElement link_expandableListsLink;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")
    public WebElement link_customAdapterLink;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Cat Names\"]")
    public WebElement link_catNamesLink;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]")
    public WebElement link_sampleActionLink;

    @FindBy(xpath = "//android.widget.Toast[@text=\"Cat Names: Group 2 clicked\"]")
    public WebElement toast_sampleActionCatNames;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"WebView3\"]")
    public WebElement link_webView3Link;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Animation\"]")
    public WebElement link_animationLink;

    //drag drop
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Drag and Drop\"]")
    public WebElement link_dragDropLink;
    @FindBy(id = "io.appium.android.apis:id/drag_dot_1")
    public WebElement button_dragDot;
    @FindBy(id = "io.appium.android.apis:id/drag_dot_2")
    public WebElement button_dropDot;
    @FindBy(id = "io.appium.android.apis:id/drag_result_text")
    public WebElement text_dragDropResult;

    //swipe
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Gallery\"]")
    public WebElement link_galleryLink;
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
