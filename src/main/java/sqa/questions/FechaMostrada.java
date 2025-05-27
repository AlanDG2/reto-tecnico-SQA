package sqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import sqa.ui.DatepickerUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class FechaMostrada implements Question<String> {
    public static FechaMostrada valor() {
        return new FechaMostrada();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(DatepickerUI.INPUT_FECHA)
                .answeredBy(actor);
    }
}