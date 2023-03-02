package demoqa.object.form;

import framework.baseform.BaseForm;
import framework.element.Label;
import framework.element.Link;
import org.openqa.selenium.By;

import java.util.List;

public class BooksWrapperForm extends BaseForm {

    private static final Label booksWrapperFormLabel = new Label(By.xpath("//div[contains(@class, 'books-wrapper')]"), "Books wrapper form Label");
    private final Link bookTitlesLink = new Link(By.xpath("//div[contains(@class, 'action-buttons')]//a"), "Book titles Link");

    public BooksWrapperForm() {
        super(booksWrapperFormLabel, "BooksWrapperForm");
    }

    public List<String> getBookTitlesList() {
        return bookTitlesLink.getTextByElements();
    }
}
