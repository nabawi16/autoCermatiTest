package web.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;
import tasks.VerifyDisplayed;

import java.util.Random;

public class RegisterStepDef {

    //Pre-condition
    @Given("{actor} already in web Cermati")
    public void loadHomePage(Actor actor)throws Exception{
        actor.wasAbleTo(NavigateTo.theURL("Register"));
    }
    @And("{actor} already on register page")
    public void goRegisterPage(Actor actor)throws Exception{
        actor.attemptsTo(
                ClickOn.button("Homepage Menu"),
                ClickOn.button("Register Menu")
        );
    }

    //Steps
    @When("{actor} inputs new account with required field only")
    public void inputCredential(Actor actor)throws Exception{

        String firstName = firstName();
        String lastName = lastName();
        String fullname = firstName + " " + lastName;
        String userName = firstName + new Random().nextInt(100);
        String email = firstName + new Random().nextInt(100) + "@mail.com";
        String phone = phoneNumber();
        String pin = "123456";

        actor.attemptsTo(
                InputText.onField("Register Fullname", fullname),
                InputText.onField("Register Lastname", lastName),
                InputText.onField("Register Username", userName),
                InputText.onField("Register Email", email),
                InputText.onField("Register Phone", phone),
                InputText.onField("Register PIN", pin),
                InputText.onField("Register Confirm PIN", pin)
        );
    }

    @When("{actor} inputs new account without fullname required field only")
    public void inputCredentialWithoutFullname(Actor actor)throws Exception{

        String firstName = firstName();
        String userName = firstName + new Random().nextInt(10);
        String email = firstName + "@mail.com";
        String phone = phoneNumber();
        String pin = "123456";

        actor.attemptsTo(
                InputText.onField("Register Username", userName),
                InputText.onField("Register Email", email),
                InputText.onField("Register Phone", phone),
                InputText.onField("Register PIN", pin),
                InputText.onField("Register Confirm PIN", pin)
        );
    }

    @When("{actor} inputs new account in email without domain required field only")
    public void inputCredentialWithoutDomain(Actor actor)throws Exception{

        String firstName = firstName();
        String lastName = lastName();
        String fullname = firstName + " " + lastName;
        String userName = firstName + new Random().nextInt(10);
        String email = firstName;

        actor.attemptsTo(
                InputText.onField("Register Fullname", fullname),
                InputText.onField("Register Username", userName),
                InputText.onField("Register Email", email)
        );
    }

    @When("{actor} inputs registered account with required field only")
    public void inputCredentialWithRegisteredAccount(Actor actor)throws Exception{

        String fullname = "toni sanjoyo";
        String userName = "toni112";
        String email = "toni112@mail.com";
        String phone = phoneNumber();
        String pin = "123456";

        actor.attemptsTo(
                InputText.onField("Register Fullname", fullname),
                InputText.onField("Register Lastname", "sanjoyo"),
                InputText.onField("Register Username", userName),
                InputText.onField("Register Email", email),
                InputText.onField("Register Phone", phone),
                InputText.onField("Register PIN", pin),
                InputText.onField("Register Confirm PIN", pin)
        );
    }

    @And("{actor} clicks the register button")
    public void clickRegisterButton(Actor actor)throws Exception{
        actor.attemptsTo(
                ClickOn.button("Register")
        );
    }

    //Validation
    @Then("{actor} successfully registers")
    public void validationRegisterSuccess(Actor actor)throws Exception{
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains("/login"),
                VerifyDisplayed.element("Register Successful")
        );
    }

    @Then("{actor} sees alert message email tidak valid")
    public void validationRegisterFailed1(Actor actor)throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("Validate Email")
        );
    }
    @Then("{actor} sees popup alert message register failed")
    public void validationRegisterFailed2(Actor actor)throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("Register Failed")
        );
    }


    //Bot Random data
    public static String firstName(){
        String firstNames[] = {"rohim", "muhammad", "nuswan", "agung", "riki", "fitri", "afri", "syafii", "raju", "budi"};
        return firstNames[new Random().nextInt(firstNames.length)];
    }

    public static String lastName(){
        String lastNames[] = {"nugroho", "yoga", "teguh", "agung", "dwi", "nabawi", "harianto", "rizki", "lalu", "minoto"};
        return lastNames[new Random().nextInt(lastNames.length)];
    }

    public static String phoneNumber(){
        String phoneNumbers = "081";

        for (int i = 0; i < 8; i++){
            phoneNumbers = phoneNumbers + new Random().nextInt(10);
        }
        return phoneNumbers;
    }
}
