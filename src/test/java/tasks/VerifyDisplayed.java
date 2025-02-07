package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import web.pageobjects.RegisterObjects;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyDisplayed {
    public static Performable element(String elementType) throws Exception{
        Target element;

        switch (elementType){
            case "Register Successful":
                element = RegisterObjects.REGISTER_BUTTON; // This should be changed to RegisterObjects.REGISTER_SUCCESSFUL if the element is defined in RegisterObjects.java
                break;
            case "Register Failed":
                element = RegisterObjects.REGISTER_FAILED; // This should be changed to RegisterObjects.REGISTER_FAILED if the element is defined in RegisterObjects.java
                break;
            case "Validate Email":
                element = RegisterObjects.VALIDATE_EMAIL; // This should be changed to RegisterObjects.VALIDATE_EMAIL if the element is defined in RegisterObjects.java
                break;
            default:
                throw new Exception("There is no element type: "+ elementType);
        }
        WaitUntil.the(element, isVisible()).forNoMoreThan(1000).seconds();
        return Task.where("{0} verify element is displayed", Ensure.that(element).isDisplayed());
    }
}
