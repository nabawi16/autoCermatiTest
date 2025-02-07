package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import web.pageobjects.RegisterObjects;

public class ClickOn {
    public static Performable button(String buttonType) throws Exception{
        Target button;

        switch (buttonType){
            case "Register":
                button = RegisterObjects.REGISTER_BUTTON;
                break;
            case "Verify":
                button = RegisterObjects.VERIFY_BUTTON;
                break;
            default:
                throw new Exception("There is no button type: " + buttonType);
        }

        return Task.where("{0} click " + buttonType + "button", Click.on(button));
    }
}
