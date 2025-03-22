# JIGSAW - Java Modules

## [API Module](./countries-cities-api)

1. El módulo api consume la api que se encuentra en [https://documenter.getpostman.com/view/1134062/T1LJjU52](https://documenter.getpostman.com/view/1134062/T1LJjU52).
1. Se utilizan tres endpoints que se pueden ver en la clase utilitaria [Constants](./countires-cities-client/src/main/java/com/jlopez/util/Constants.java).
1. Las clases que consumen al [cliente](./countires-cities-client/src/main/java/com/jlopez/client) estan divididas en tres, una para cada URL que se estará consultando
los métodos son de una línea, pero se dividen para ejemplificar que estan dedicadas a un solo path,
y que posiblemente en un futuro se podrían agregar más métodos de consumo y con diferente lógica. 
1. Creación de [POJOs](countires-cities-client/src/main/java/com/jlopez/entity) para representar las respuestas de la api.
1. Capas:
   1. **[REPOSITORY](./countries-cities-api/src/main/java/com/jlopez/repository):** fuente donde se almacenan los datos
   que se obtienen de las apis; implementación de cache.
   1. **[SERVICE](./countries-cities-api/src/main/java/com/jlopez/service):** clases para el procesamiento de datos, transformaciòn
    de los objetos obtenidos de la api, a objetos que muestran los resultados.
   1. **[FLOW](./countries-cities-api/src/main/java/com/jlopez/flow):** métodos donde se realiza la consulta de informaciòn
    y el procesamiento de datos.
1. **[module-info.java](./countries-cities-api/src/main/java/module-info.java):** archivo donde se especifican los paquetes que se 
están exportando y paquetes externos requeridos.
1. Carpeta de pruebas [test](./countries-cities-api/src/test)

## [Client Module](./countries-cities-client)

1. Módulo que consume la api, que procesa la información estadística de los países.
1. Se puede empaquetar el proyecto con comando `mvn install` y ejecutarlo con `java -jar`, previamente se debe haber
generado el jar del módulo api [countries-cities-api](./countries-cities-api).
3. Programa interactivo, donde el usuario puede elegir entre 4 opciones diferentes (listar todos los países, obtener las
las estadísticas para todos los países, obtener las estadísticas de un solo país o salir), la clase que se ejecuta es
[CountriesCitiesClient](./countries-cities-client/src/main/java/com/jlopez/api/countries/client/CountriesClient.java).
4. Carpeta de pruebas [test](./countries-cities-client/src/test)

# Ejecución

1. Dentro de la carpeta [countries-cities-api](./countries-cities-api) ejecutar el comando `mvn install -DskipTests`.
2. Dentro de la carpeta [countries-cities-client](./countries-cities-client) ejecutar el comando `mvn install`, este comando
generará el jar `countries-cities-client-1.0-SNAPSHOT.jar` bajo el path _/target_.
3. En la terminal, desde la carpeta _/target_ ejecutar el comando `java -jar countries-cities-client-1.0-SNAPSHOT.jar`.
4. Es un programa interactivo donde se puden elegir entre 3 opciones, en las cuales se hace la llamada al endpoint o
procesar la data en cache.
5.  Main class: [CountriesClient](./countries-cities-client/src/main/java/com/jlopez/api/countries/client/CountriesClient.java).