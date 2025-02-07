package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import web.pageobjects.RegisterObjects;

public class InputText {
    public static Performable onField(String fieldType, String value) throws Exception{
        Target field;

        switch (fieldType){
            case "Email":
                field = RegisterObjects.EMAIL_FIELD;
                break;
            case "Register Fullname":
                field = RegisterObjects.FIRSTNAME_FIELD;
                break;
            case "Register Lastname":
                field = RegisterObjects.LASTNAME_FIELD;
                break;
            case "Register Phone":
                field = RegisterObjects.NO_HANDPHONE_FIELD;
                break;
            case "Register PIN":
                field = RegisterObjects.PIN_FIELD;
                break;
            case "Register Confirm PIN":
                field = RegisterObjects.CONFIRM_PIN_FIELD;
                break;
            default:
                throw new Exception("There is no field type: " + fieldType);
        }

        return Task.where("{0} input value: '"+ value + "'", Enter.theValue(value).into(field));
    }
}
