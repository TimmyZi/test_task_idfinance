package demoqa.object;

import demoqa.object.form.BooksWrapperForm;
import demoqa.object.form.LeftSideMenuForm;
import framework.baseform.BaseForm;
import framework.element.Label;
import org.openqa.selenium.By;

public class BookStorePage extends BaseForm {

    private static final Label header = new Label(By.xpath("//div[contains(@class,'main-header')]"), "Header");
    private final LeftSideMenuForm leftSideMenuForm = new LeftSideMenuForm();
    private final BooksWrapperForm booksWrapperForm = new BooksWrapperForm();

    public BookStorePage() {
        super(header, "BookStorePage");
    }

    public LeftSideMenuForm getLeftSideMenuForm() {
        return leftSideMenuForm;
    }

    public BooksWrapperForm getBooksWrapperForm() {
        return booksWrapperForm;
    }
}
