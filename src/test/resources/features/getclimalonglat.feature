Feature: Get clima por latitud y longitud
  Yo como usuario de OpenWeatherMap
  Quiero acceder a los reportes del clima, ingresando longitud y latitud
  Para conocer el estado del clima en una coordenada especifica

  Scenario Outline: Clima por latitud y longitud
    Given el usuario ingresa al servicio de clima OpenWeatherMap
    When el usuario envia una peticion con la <latitud> y <longitud> del lugar
    Then el usuario deberia observar un <codigo> de respuesta OK y el reporte con el estado del clima con la <latitud> y <longitud> ingresadas
    Examples:
      | latitud | longitud | codigo |
      | 44.34   | 10.99    | 200    |
      | 50      | 100      | 200    |
      | 10      | 150      | 200    |