package sqa.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Value;
import sqa.questions.FechaMostrada;
import sqa.tasks.AbrirDatepicker;
import sqa.tasks.NavegarAMes;
import sqa.tasks.SeleccionarDia;
import sqa.ui.DatepickerUI;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.ensure.Ensure.that;


public class PasosDatepicker {

    private Actor usuario;

    @Before
    public void iniciarEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario abre el selector de fecha")
    public void abrir_selector() {
        usuario = OnStage.theActorCalled("Olga");
        usuario.attemptsTo(AbrirDatepicker.ahora());
    }

    @Cuando("el usuario navega a {word} {int}")
    public void navegar_a_mes(String nombreMes, int anio) {
        int mes = java.time.Month.valueOf(nombreMes.toUpperCase()).getValue();
        usuario.attemptsTo(NavegarAMes.hasta(mes, anio));
    }

    @Cuando("el usuario selecciona el día {int}")
    public void seleccionar_dia(int dia) {
       usuario.attemptsTo(SeleccionarDia.de(dia));
    }

    @Cuando("el usuario intenta seleccionar el día {int}")
    public void intentar_dia_invalido(int dia) {
       usuario.attemptsTo(SeleccionarDia.de(dia));
    }

    @Entonces("la fecha seleccionada {string} debe aparecer en el campo")
    public void verificar_fecha_seleccionada(String esperado) {
        usuario.should(
                seeThat("La fecha en el input",
                        Value.of(DatepickerUI.INPUT_FECHA), equalTo(esperado))
        );

    }

    @Entonces("el selector no debe permitir la selección")
    public void verificar_no_seleccion() {
        usuario.should(
                seeThat("El campo de fecha debe estar vacío",
                        Value.of(DatepickerUI.INPUT_FECHA), equalTo(""))
        );
    }
}