# OpenWeatherMap

## Ejercicio planteado

Considere como SUT la API https://openweathermap.org/current la cual emite información del clima en tiempo real.
Implementar los casos de pruebas asociados a las siguientes funcionalidades:
- Obtener la información del clima consultando por nombre de ciudad
- Obtener la información del clima consultando por latitud y longitud
- Obtener la información del clima en formato Json
- Obtener la información del clima en formato XML


## Solución

Para la solución del ejercicio planteado se implementa una automatización usando el patrón de pruebas ScreenPlay, el
framework Serenety, el gestor de dependicas Gradle y Java en su versión 11.

### Dependencias

- Junit: 5.7.2
- Serenity: 2.2.9
- Serenity Cucumber: 2.2.6
- apache: 3.17
- Java version 11
- log4j 1.2.17
- Json Simple 1.1.1

### Repositorio

Para ejecutar la automatización, primero se debe clonar el presente repositorio, utilizando el siguiente comando:
``` git clone git@github.com:SergioBalca/APIclima.git```

La ejecución del proyecto se realiza utilizando Junit

### Reporte ejecución

Luego de ejecutar la automatización es posible obtener un informe detallado con los resultados en el archivo <b>index.html
</b>:
``` target/index.html```