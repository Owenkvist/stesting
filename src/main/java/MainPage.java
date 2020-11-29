
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    By authFirstName = By.id("firstname");
    By authLastName = By.id("lastname");
    By authLogin = By.id("login");
    By authPassword = By.id("password");
    By authPassConfirm = By.id("password_confirm");
    By authPhone = By.id("phone");
    By authUsername = By.id("passp-field-login");
    By authUserpass = By.id("passp-field-passwd");
    By find = By.name("q");
    By searchButton = By.name("btnK");
    By count = By.xpath("//div[@class=\"LHJvCe\"]");
    By sigInHeader = By.xpath("//span[@class='user-account__name']");


    public MainPage enterText(String text) {
        driver.findElement(find).sendKeys(text);
        return this;
    }

    public MainPage typeFirstName(String firstName) {
        driver.findElement(authFirstName).sendKeys(firstName);
        return this;
    }

    public MainPage typeLastName(String lastname) {
        driver.findElement(authLastName).sendKeys(lastname);
        return this;
    }

    public MainPage typeLogin(String login) {
        driver.findElement(authLogin).sendKeys(login);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(authPassword).sendKeys(password);
        return this;
    }

    public MainPage typePassConfirm(String passConfirm) {
        driver.findElement(authPassConfirm).sendKeys(passConfirm);
        return this;
    }

    public MainPage typePhone(String phone) {
        driver.findElement(authPhone).sendKeys(phone);
        return this;
    }

    public MainPage typeUsername(String username) {
        driver.findElement(authUsername).sendKeys(username);
        return this;
    }

    public MainPage typeUserpass(String userpass) {
        driver.findElement(authUserpass).sendKeys(userpass);
        return this;
    }

    public MainPage clickOnRegisterButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(By.xpath("//span[text()='Зарегистрироваться']")));
        return this;
    }

    public MainPage clickOnInButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(By.xpath("//span[text()='Войти']")));
        return this;
    }

    public MainPage clickOnSearchButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(searchButton));
        return this;
    }

    public String getSigInHeader() {
        return driver.findElement(sigInHeader).getAttribute("textContent");
    }

    public String getCount() {
        return driver.findElement(count).getAttribute("textContent");
    }

    public MainPage registerWithPhoneNumber(String firstName, String lastname, String login, String password, String passConfirm, String phone) {
        this.typeFirstName(firstName);
        this.typeLastName(lastname);
        this.typeLogin(login);
        this.typePassword(password);
        this.typePassConfirm(passConfirm);
        this.typePhone(phone);
        this.clickOnRegisterButton();
        return new MainPage(driver);
    }

}
