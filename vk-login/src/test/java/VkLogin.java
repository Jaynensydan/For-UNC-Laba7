import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class VkLogin extends WebDriverSettings {

    @Test
    public void test() {
        //Задание 1
        goToWebPage();
        doLogIn();
        //Задание 2
        goToMyPage();
        goToMyNews();
        goToMyMessage();
        goToMyFriends();
        goToMyGroups();
        //Задание 4
        writeMeSomething();
        //Задание 5
        checkMyText();
        //Задание 6
        changeMySettings();
        checkMyChanges();
        doLogOut();
    }

    //Метод открывает сайт VK.COM
    private void goToWebPage() {
        driver.get(url);
    }

    //Метод логинится в ВК
    private void doLogIn() {
        WebElement loginField = driver.findElementById("index_email");
        loginField.click();
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElementById("index_pass");
        passwordField.click();
        passwordField.sendKeys(password);


        WebElement loginButton = driver.findElementById("index_login_button");
        loginButton.click();

    }

    //Метод нажимает на кнопку "Моя страница" и делает скриншот
    private void goToMyPage() {
        WebElement tagLi = driver.findElementById("l_pr");
        tagLi.click();
        //giveMeScreen();

    }

    //Метод нажимает на кнопку "Мои новости" и делает скриншот
    private void goToMyNews() {
        WebElement tagLi = driver.findElementById("l_nwsf");
        tagLi.click();
        //giveMeScreen();

    }

    //Метод нажимает на кнопку "Мои сообщения" и делает скриншот
    private void goToMyMessage() {
        WebElement tagLi = driver.findElementById("l_msg");
        tagLi.click();
        //giveMeScreen();

    }

    //Метод нажимает на кнопку "Мои друзья" и делает скриншот
    private void goToMyFriends() {
        WebElement tagLi = driver.findElementById("l_fr");
        tagLi.click();
        //giveMeScreen();

    }

    //Метод нажимает на кнопку "Мои группы" и делает скриншот
    private void goToMyGroups() {
        WebElement tagLi = driver.findElementById("l_gr");
        tagLi.click();
        //giveMeScreen();

    }

    //Метод оставляет сообщение на стене
    private void writeMeSomething() {
        goToMyPage();
        WebElement tagLi = driver.findElementById("post_field");
        tagLi.click();
        tagLi.sendKeys("This is just spam, do not pay attention to it");
        WebElement sendButton = driver.findElementById("send_post");
        sendButton.click();

    }


    //Метод проверяет что запись на стене появилась
    private void checkMyText() {
        goToMyPage();
        WebElement pageWallPostsDiv = driver.findElement(By.id("page_wall_posts"));
        String innerHtml = pageWallPostsDiv.getAttribute("innerHTML");
        Assert.assertTrue(innerHtml.contains("<div class=\"wall_post_text zoom_text\">This is just spam, do not pay attention to it</div>"));
    }

    //Метод изменяет в настройках видимость подарков на странице
    private void changeMySettings() {
        goToMyPage();
        WebElement topProfileButton = driver.findElementById("top_profile_link");
        topProfileButton.click();
        WebElement topSettingsButton = driver.findElementById("top_settings_link");
        topSettingsButton.click();
        WebElement hideMyPresentsButton = driver.findElementById("hide_gifts");
        hideMyPresentsButton.click();
    }

    // Метод проверяет изменения в настройках
    private void checkMyChanges() {
        String notTrue = "false";
        changeMySettings();
        WebElement checkChanges = driver.findElementById("hide_gifts");
        String myChanges = checkChanges.getAttribute("aria-checked");
        if (myChanges.equals(notTrue)) {
            System.out.println("Nothing changes!");
        } else {
            System.out.println("Changes is done!");

        }
    }

    //Метод разлогинивается из ВК
    private void doLogOut() {
        WebElement topProfileButton = driver.findElementById("top_profile_link");
        topProfileButton.click();

        WebElement logOutButton = driver.findElementById("top_logout_link");
        logOutButton.click();
    }
}
