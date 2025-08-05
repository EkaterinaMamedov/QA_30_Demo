package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver wd = new ChromeDriver();

    @Test
    public void selectorsRadioButtonPage() {
        wd.get("https://demoqa.com/radio-button");
        wd.manage().window().maximize();

        hideBanner();
        hideFooter();

        WebElement radioButtonYes1 = wd.findElement(By
                .cssSelector("*[for='yesRadio']"));
        WebElement radioButtonYes = wd.findElement(By
                .xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();
        pause(4000);

        WebElement radioButtonImpressive = wd.findElement(By.xpath("//*[@for='impressiveRadio']"));
        radioButtonImpressive.click();
        pause(4000);


        wd.quit();
    }

    @Test
    public void selectorsTextBoxPage() {
        wd.get("https://demoqa.com/text-box");
        wd.manage().window().maximize();

        hideBanner();
        hideFooter();

//        WebElement labelFullName = wd.findElement(By
//                .xpath("//*[@id='userName-label']"));
//        labelFullName.sendKeys("Monkey");

        WebElement inputFullName = wd.findElement(By
                .xpath("//*[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        //form/div[@id='userName-wrapper']/div[2]/input
        //form/div[@id='userName-wrapper']//input
        pause(4000);

        WebElement inputEmail = wd.findElement(By
                .xpath("//input[@type='email']"));
        inputEmail.sendKeys("monkey@gmail.com");
        pause(4000);

        WebElement textareaCurrentAddress = wd.findElement(By
                .xpath("//textarea[@id='currentAddress']"));
        textareaCurrentAddress.sendKeys("monkey street 5");
        pause(4000);

        WebElement textareaPermanentAddress = wd.findElement(By
                .xpath("//textarea[@id='permanentAddress']"));
        textareaPermanentAddress.sendKeys("monkey avenue 6");

        pause(4000);

        WebElement btnSubmit = wd.findElement(By
                .xpath("//button[text()='Submit']"));
        btnSubmit.click();

        pause(4000);

        WebElement outputForm = wd.findElement(By
                .xpath("//div[@id='output']"));
        System.out.println(outputForm.getText());


        pause(4000);
        wd.quit();


    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }


}
