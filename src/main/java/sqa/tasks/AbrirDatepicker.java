    package sqa.tasks;

    import net.serenitybdd.core.annotations.findby.By;
    import net.serenitybdd.screenplay.Actor;
    import net.serenitybdd.screenplay.Task;
    import net.serenitybdd.screenplay.actions.Click;
    import net.serenitybdd.screenplay.actions.Open;
    import net.serenitybdd.screenplay.actions.Switch;
    import net.serenitybdd.screenplay.waits.WaitUntil;
    import org.openqa.selenium.WebElement;
    import sqa.ui.DatepickerUI;


    import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


    public class AbrirDatepicker implements Task {

        public static AbrirDatepicker ahora() {
            return new AbrirDatepicker();
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Open.url("https://jqueryui.com/resources/demos/datepicker/default.html"),
                    Click.on(DatepickerUI.INPUT_FECHA)
            );
        }
    }

