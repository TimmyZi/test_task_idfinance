package demoqa.object.form;

import framework.baseform.BaseForm;
import framework.element.Button;
import framework.element.Label;
import org.openqa.selenium.By;

public class ApproveWindowForm extends BaseForm {

    private static final Label approveWindowLabel = new Label(By.xpath("//div[contains(@class, 'modal-content')]"), "Approve window Label");
    private final Button okButton = new Button(By.id("closeSmallModal-ok"), "Ok Button");

    public ApproveWindowForm() {
        super(approveWindowLabel, "Approve window form");
    }

    public void clickOkButton(){
        okButton.waitForClickable();
        okButton.click();
    }
}
