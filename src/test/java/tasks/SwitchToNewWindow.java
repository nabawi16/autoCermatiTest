package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchToNewWindow implements Task {

    public SwitchToNewWindow(){}

    public static SwitchToNewWindow switchToNewTab(){
        return Instrumented.instanceOf(SwitchToNewWindow.class).withProperties();
    }

    @Step("{0} Switching to new Window")
    public <T extends Actor> void performAs(T actor){
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String currHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles){
            if (!handle.contentEquals(currHandle)){
                driver.switchTo().window("1");
                break;
            }
        }
    }

}
