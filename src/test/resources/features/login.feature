

Feature: Selección de fecha
  Como usuario de la web
  Quiero seleccionar fechas usando el selector de jQuery UI
  Para evitar errores al ingresar fechas manualmente

  Scenario: Seleccionar fecha válida dentro del rango permitido
    Given que el usuario abre el selector de fecha
    When el usuario navega a October 2025
    And el usuario selecciona el día 13
    Then la fecha seleccionada "10/13/2025" debe aparecer en el campo

  Scenario: Intentar seleccionar fecha fuera del rango permitido
    Given que el usuario abre el selector de fecha
    When el usuario intenta seleccionar el día 32
    Then el selector no debe permitir la selección