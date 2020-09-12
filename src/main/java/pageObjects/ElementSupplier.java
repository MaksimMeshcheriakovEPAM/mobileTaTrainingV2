package pageObjects;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public interface ElementSupplier {
    default WebElement getElement(String weName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(this);
    }
}