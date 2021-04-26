import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Main2 extends BaseTest{

    @Test
    public void test1() {
        driver.get("http://demoqa.com/");

        String title = driver.getTitle();

        Assert.assertEquals("ToolsQA", title);

    }

    @Test
    public void test2() {

        WebElement element = driver.findElement(By.xpath("(//*[@class='avatar mx-auto white'])[1]"));
        element.click();

        WebElement element2 = driver.findElement(By.xpath("//*[@class='main-header']"));
        String s = element2.getText();

        Assert.assertEquals( "Elements", s);

    }

    @Test
    public void test3() {

        List<WebElement> elements = driver.findElements(By.xpath("//ul//li"));
        elements.get(0).click();

        WebElement inputName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        inputName.sendKeys("John Doe");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        WebElement nameField = driver.findElement(By.xpath("//p[@id=\"name\"]"));
        String string = nameField.getText();
        Assert.assertTrue(string.contains("John"));
    }

    @Test
    public void test4() {

        WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        inputEmail.sendKeys("test@test.com");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        WebElement emailField = driver.findElement(By.xpath("//p[@id=\"email\"]"));
        String string = emailField.getText();
        Assert.assertTrue(string.contains("test@test.com"));
    }


    @Test
    public void test5() {

        WebElement inputCurrentAddress = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        inputCurrentAddress.sendKeys("Warsaw, Poland");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        WebElement currentAddressField = driver.findElement(By.xpath("//p[@id=\"currentAddress\"]"));
        String string = currentAddressField.getText();
        Assert.assertTrue(string.contains("Warsaw"));
    }

    @Test
    public void test6() {

        WebElement inputPermanentAddress = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", inputPermanentAddress);
        inputPermanentAddress.sendKeys("Lviv, Ukraine");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        button.click();

        WebElement permanentAddressField = driver.findElement(By.xpath("//p[@id=\"permanentAddress\"]"));
        String string = permanentAddressField.getText();
        Assert.assertTrue(string.contains("Lviv"));

    }

    @Test
    public void test7() {

        List<WebElement> elements = driver.findElements(By.xpath("//ul//li"));
        elements.get(2).click();

        List<WebElement> radioButtons = driver.findElements(By.xpath("//label"));
        WebElement yes = radioButtons.get(0);
        WebElement impressive = radioButtons.get(1);
        WebElement no = radioButtons.get(2);

        yes.click();

        Assert.assertFalse("Button is not clicked" ,yes.isSelected());
    }

    @Test
    public void test8() {

        List<WebElement> elements = driver.findElements(By.xpath("//ul//li"));
        elements.get(1).click();

        WebElement toggle = driver.findElement(By.xpath("//ol/li/span/button"));
        toggle.click();


        List<WebElement> elements1 = driver.findElements(By.xpath("//ol/li/span/button"));
        elements1.get(1).click();


        WebElement checkBoxNotes = driver.findElement(By.xpath("//*[contains(text(), 'Notes')]"));

        checkBoxNotes.click();


        Assert.assertFalse("Checkbox is not clicked" ,checkBoxNotes.isSelected());

    }

    @Test
    public void test9() {

        WebElement header = driver.findElement(By.xpath("//header/a"));
        header.click();

        List<WebElement> elements = driver.findElements(By.xpath("//*[@fill='currentColor']"));
        elements.get(4).click();

        WebElement toggle = driver.findElement(By.xpath("//span[contains(text(), 'Selectable')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", toggle);
        toggle.click();

        List<WebElement> elements1 = driver.findElements(By.xpath("//div/ul[@id='verticalListContainer']/li"));
        elements1.get(1).click();
        for (WebElement e:elements1) {
            e.click();
        }
    }

    @Test
    public void testA() {

        WebElement widgets = driver.findElement(By.xpath("//div[contains(text(), 'Widgets')]"));
        widgets.click();

        WebElement autoComplete = driver.findElement(By.xpath("//span[contains(text(), 'Auto')]"));
        autoComplete.click();

        WebElement textField = driver.findElement(By.xpath("//div[@id=\"autoCompleteSingleContainer\"]"));
        System.out.println(textField.getAttribute("className"));
    }



}