package demoqa.object;

import framework.baseform.BaseForm;
import framework.element.Button;
import framework.element.Label;
import framework.element.TextBox;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {

    private static final Label userNameLabel = new Label(By.id("userName-label"), "User name Label");
    private final TextBox userNameTextBox = new TextBox(By.id("userName"), "User name TextBox");
    private final TextBox passwordTextBox = new TextBox(By.id("password"), "Password TextBox");
    private final Button loginButton = new Button(By.id("login"), "Login Button");

    public LoginPage() {
        super(userNameLabel, "Login Form");
    }

    public void setUserName(String userName) {
        userNameTextBox.sendText(userName);
    }

    public void setPassword(String password) {
        passwordTextBox.sendText(password);
    }

    public void clickLoginButton() {
        loginButton.waitForClickable();
        loginButton.click();
    }
}
