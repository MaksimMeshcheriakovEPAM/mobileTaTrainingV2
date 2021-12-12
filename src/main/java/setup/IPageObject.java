package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    Object getPageObject();
    WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
