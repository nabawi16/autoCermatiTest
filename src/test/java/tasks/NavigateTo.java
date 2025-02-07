package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import web.pageobjects.RegisterObjects;

public class NavigateTo {
    public static Performable theURL(String urlType)throws Exception{
        Class url;

        switch (urlType){
            case "Register":
                url = RegisterObjects.class;
                break;
            default:
                throw new Exception("There is no url type" + urlType);
        }

        return Task.where("{0} access the page url", Open.browserOn().the(url));
    }
}
