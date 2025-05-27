package sqa.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerUI {

    public static final Target INPUT_FECHA = Target.the("campo de entrada de fecha")
            .locatedBy("#datepicker");

    public static final Target CONTENEDOR_PICKER = Target.the("contenedor del datepicker")
            .locatedBy("#ui-datepicker-div");

    public static final Target MES_ACTUAL = Target.the("mes actual")
            .locatedBy(".ui-datepicker-month");

    public static final Target ANIO_ACTUAL = Target.the("año actual")
            .locatedBy(".ui-datepicker-year");

    public static final Target BOTON_SIGUIENTE = Target.the("botón siguiente")
            .locatedBy(".ui-datepicker-next");

    public static final Target BOTON_ANTERIOR = Target.the("botón anterior")
            .locatedBy(".ui-datepicker-prev");

    public static Target DIA(final int day) {
        return Target.the("día " + day)
                .locatedBy("//a[text()='" + day + "']");
    }
}