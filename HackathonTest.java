package Hackathon.Tests;

import Hackathon.Pages.AlertPage;
import Hackathon.Pages.ViewsPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackathonTest {
    AndroidDriver driver;

    @BeforeTest(enabled = true, description = "")
    public void launchApk() {

        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Medium_Phone");
            options.setPlatformName("Android");
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
            options.setApp("C:\\Users\\Anushka\\Downloads\\ApiDemos-debug.apk");
             driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("App Launched Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(enabled = true, description = "")
    public void validateLongPress() {
        ViewsPage oViewsPage = new ViewsPage(driver);

        try {
            oViewsPage.link_viewsLink.click();
            System.out.println("Views Option Clicked");
            Thread.sleep(2000);
            oViewsPage.link_expandableListsLink.click();
            System.out.println("Expandable list Option Clicked");
            Thread.sleep(2000);
            oViewsPage.link_customAdapterLink.click();
            System.out.println("Custom adapter Option Clicked");
            Thread.sleep(2000);

            WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Cat Names\"]"));

            int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
            int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 1);
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(2)));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(sequence));
            Thread.sleep(2000);
            System.out.println("Long pressed successfully on cat names");
            oViewsPage.link_sampleActionLink.click();
            Thread.sleep(2000);
            System.out.println("Toast Message validated: "+oViewsPage.toast_sampleActionCatNames.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(enabled = true, description = "")
    public void validateScroll() {
        ViewsPage oViewsPage = new ViewsPage(driver);

        try {
            oViewsPage.link_viewsLink.click();
            System.out.println("Views Option Clicked");
            Thread.sleep(2000);
            String uiAutomatorScroll = "new UiScrollable(new UiSelector().scrollable(true))"
                    + ".scrollIntoView(new UiSelector().text(\"WebView3\"));";
            Thread.sleep(2000);
            driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorScroll));
            Thread.sleep(2000);
            System.out.println("Scroll down successfully");


            String uiAutomatorScroll2 = "new UiScrollable(new UiSelector().scrollable(true))"
                    + ".scrollIntoView(new UiSelector().text(\"Animation\"));";
            Thread.sleep(2000);
            driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorScroll2));
            Thread.sleep(2000);
            System.out.println("Scroll up successfully");
            Thread.sleep(2000);
            oViewsPage.link_animationLink.click();
            System.out.println("Animation selected");
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true, description = "")
    public void validateTap() {
        ViewsPage oViewsPage = new ViewsPage(driver);

        try {
            oViewsPage.link_animationLinkMain.click();
            System.out.println("Animation Option Clicked");
            Thread.sleep(2000);
            oViewsPage.link_viewFlipUnderAnimation.click();
            System.out.println("View flip  Clicked");
            Thread.sleep(2000);
            oViewsPage.button_viewFlip.click();
            System.out.println("Flip Option Clicked");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true, description = "")
    public void validateDragDrop() {
        ViewsPage oViewsPage = new ViewsPage(driver);

        try {
            oViewsPage.link_viewsLink.click();
            System.out.println("Views Option Clicked");
            Thread.sleep(2000);
            oViewsPage.link_dragDropLink.click();
            System.out.println("Drag and drop Clicked");
            Thread.sleep(2000);

            WebElement fromDot = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
            WebElement toDot = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
            int startX = fromDot.getLocation().getX() + (fromDot.getSize().getWidth() / 2);
            int startY = fromDot.getLocation().getY() + (fromDot.getSize().getHeight() / 2);
            int endX = toDot.getLocation().getX() + (toDot.getSize().getWidth() / 2);
            int endY = toDot.getLocation().getY() + (toDot.getSize().getHeight() / 2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence dragAndDrop = new Sequence(finger, 1);

            // Long press on the first dot
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            // Drag to the second dot
            dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));

            // Release the touch
            dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(dragAndDrop));
            Thread.sleep(2000);
            System.out.println("Toast Message validated: "+oViewsPage.text_dragDropResult.getText());
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true, description = "")
    public void validateSwipe() {
        ViewsPage oViewsPage = new ViewsPage(driver);

        try {
            oViewsPage.link_viewsLink.click();
            System.out.println("Views Option Clicked");
            Thread.sleep(2000);
            oViewsPage.link_galleryLink.click();
            System.out.println("Gallery Clicked");
            Thread.sleep(2000);
            oViewsPage.link_photosLink.click();
            System.out.println("Photos Clicked");
            Thread.sleep(2000);

            WebElement imageContainer = driver.findElement(By.id("io.appium.android.apis:id/gallery"));

            int startX = imageContainer.getLocation().getX() + (imageContainer.getSize().getWidth() * 3 / 4);
            int startY = imageContainer.getLocation().getY() + (imageContainer.getSize().getHeight() / 2);
            int endX = imageContainer.getLocation().getX() + (imageContainer.getSize().getWidth() / 4);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            for (int i = 0; i < 5; i++) {
                // Swipe Left Gesture
                Sequence swipe = new Sequence(finger, 1);
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, startY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Collections.singletonList(swipe));
                // Check if the 5th image is displayed
                if (oViewsPage.swiped_imageFifth.isDisplayed()) {
                    System.out.println("Fifth image displayed!");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Alert handling test cases
    @Test(enabled = true, description = "")
    public void validateSimpleAlert() {
        AlertPage oAlertPage = new AlertPage(driver);
        try {
            oAlertPage.link_appLink.click();
            System.out.println("App Option Clicked");
            Thread.sleep(2000);
            oAlertPage.link_alertDialogLink.click();
            System.out.println("Alert dialog Clicked");
            Thread.sleep(2000);
            oAlertPage.link_alertFirstOptionLink.click();
            System.out.println("First alert Option Clicked");
            Thread.sleep(2000);
            // Switch to alert
            Alert alert = driver.switchTo().alert();

            // Capture alert text
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);

            // Accept and close the alert
            alert.accept();
            System.out.println("Alert accepted successfully!");

            //single choice alert
            oAlertPage.link_singleChoiceLink.click();
            Thread.sleep(2000);
            System.out.println("Single choice Option Clicked");

            oAlertPage.radioButton_streetView.click();
            Thread.sleep(2000);
            System.out.println("Street view selected");

            oAlertPage.button_saveSingleList.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(enabled = true, description = "")
    public void validateEntryDialogAlertAndRepeatAlarm() {
        AlertPage oAlertPage = new AlertPage(driver);
        String username = "Anushka";
        String password = "abc123";
        try {
            oAlertPage.link_appLink.click();
            System.out.println("App Option Clicked");
            Thread.sleep(2000);
            oAlertPage.link_alertDialogLink.click();
            System.out.println("Alert dialog Option Clicked");
            Thread.sleep(2000);
            oAlertPage.link_textEntryLink.click();
            System.out.println("Text Entry dialog Option Clicked");
            Thread.sleep(2000);
            oAlertPage.input_userNameTextEntry.sendKeys(username);
            oAlertPage.input_passwordTextEntry.sendKeys(password);
            System.out.println("Username entered:"+username);
            System.out.println("Password entered:"+password);
            oAlertPage.button_saveSingleList.click();
            Thread.sleep(2000);

            //repeat alarm
            oAlertPage.link_repeatAlarmLink.click();
            System.out.println("Repeat alarm selected");
            Thread.sleep(2000);
            List<String> weekdays = Arrays.asList("Every Monday", "Every Tuesday", "Every Wednesday", "Every Thursday", "Every Friday");
            for (String day : weekdays) {
                WebElement checkbox = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text='"+day+"']"));
                Thread.sleep(3000);
                boolean isChecked = checkbox.getAttribute("checked").equals("true");
                // Check the box if it's not checked and it's not Tuesday or Friday
                if (!isChecked && !day.equals("Tuesday") && !day.equals("Friday")) {
                    checkbox.click();
                    Thread.sleep(3000);
                    System.out.println(day + " is now checked.");
                } else {
                    System.out.println(day + " was already checked or should remain unchecked.");
                }
            }
            oAlertPage.button_saveSingleList.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void closeDriver(){
        try{
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
