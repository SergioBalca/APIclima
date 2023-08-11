Feature: Get Clima por ciudad
  Yo como usuario del servicio Openweathermap
  Quiero acceder al reporte del clima
  Para conocer el estado del clima en mi ciudad

  Scenario Outline: Estado clima por ciudad
    Given el usuario ingresa al servicio OpenWeathermap
    When el usuario envia una peticion con el nombre de la "<ciudad>"
    Then Deberia observar un <codigo> de respuesta OK, el nombre de la "<ciudad>" elegida y el reporte del clima
    Examples:
      | ciudad    | codigo |
      | London    | 200    |
      | Paris     | 200    |
      | Barcelona | 200    |
