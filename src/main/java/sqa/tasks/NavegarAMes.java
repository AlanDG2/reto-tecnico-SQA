package sqa.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import sqa.ui.DatepickerUI;

import java.time.Month;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarAMes implements Task {
    private final int mesObjetivo;
    private final int anioObjetivo;

    public NavegarAMes(int mes, int anio) {
        this.mesObjetivo = mes;
        this.anioObjetivo = anio;
    }

    public static NavegarAMes hasta(int mes, int anio) {
        return new NavegarAMes(mes, anio);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DatepickerUI.CONTENEDOR_PICKER, isVisible()).forNoMoreThan(5).seconds()
        );

        while (true) {
            String mesActualTexto = Text.of(DatepickerUI.MES_ACTUAL).answeredBy(actor);
            String anioActualTexto = Text.of(DatepickerUI.ANIO_ACTUAL).answeredBy(actor);

            int mesActual = Month.valueOf(mesActualTexto.toUpperCase()).getValue(); // de nombre a número
            int anioActual = Integer.parseInt(anioActualTexto);

            if (anioActual == anioObjetivo && mesActual == mesObjetivo) {
                break;
            }

            if (anioActual < anioObjetivo || (anioActual == anioObjetivo && mesActual < mesObjetivo)) {
                actor.attemptsTo(
                        Click.on(DatepickerUI.BOTON_SIGUIENTE)
                );
            } else {
                actor.attemptsTo(
                        Click.on(DatepickerUI.BOTON_ANTERIOR)
                );
            }
        }
    }
}
