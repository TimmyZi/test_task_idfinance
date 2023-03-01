package demoqa.object.form;

import framework.baseform.BaseForm;
import framework.element.Button;
import framework.element.Label;
import org.openqa.selenium.By;

public class LeftSideMenuForm extends BaseForm {
    private final String leftMenuButtons = "//span[contains(text(),'%s')]//parent::li";
    private final Button loginButton = new Button(By.xpath(String.format(leftMenuButtons, "Login")), "Login button");
    private static final Label leftSideMenu = new Label(By.xpath("//div[contains(@class,'left-pannel')]"), "Left side menu");

    public LeftSideMenuForm() {
        super(leftSideMenu, "LeftSideMenuForm");
    }

    public void clickLoginButton() {
        loginButton.waitForClickable();
        loginButton.click();
    }
}
