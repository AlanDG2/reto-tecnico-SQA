package sqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import sqa.ui.DatepickerUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarDia implements Task {
    private final int dia;

    public SeleccionarDia(int dia) {
        this.dia = dia;
    }

    public static SeleccionarDia de(int dia) {
        return new SeleccionarDia(dia);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target diaTarget = DatepickerUI.DIA(dia);
        if (diaTarget.resolveAllFor(actor).isEmpty()) {
            System.out.println("El día " + dia + " no está disponible en el calendario.");
        } else {
            actor.attemptsTo(Click.on(diaTarget));
        }
    }
}
