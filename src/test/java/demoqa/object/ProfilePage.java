package demoqa.object;

import demoqa.object.form.ApproveWindowForm;
import framework.baseform.BaseForm;
import framework.element.Button;
import framework.element.Label;
import org.openqa.selenium.By;

public class ProfilePage extends BaseForm {

    private static final Label userNameValueLabel = new Label(By.id("userName-value"), "User name value Label");
    private final String profileButtons = "//button[contains(@class, 'btn-primary') and contains(text(), '%s')]";
    private final Button deleteAccountButton = new Button(By.xpath(String.format(profileButtons, "Delete Account")), "Delete account Button");
    private final ApproveWindowForm approveWindowForm = new ApproveWindowForm();

    public ProfilePage() {
        super(userNameValueLabel, "Profile Page");
    }

    public String getUserNameValue() {
        return userNameValueLabel.getText();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.waitForClickable();
        deleteAccountButton.click();
    }

    public ApproveWindowForm getApproveWindowForm() {
        return  approveWindowForm;
    }
}
