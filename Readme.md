# Java Modules

## Client Module

1. El cliente consume la api que se encuentra en [https://documenter.getpostman.com/view/1134062/T1LJjU52](https://documenter.getpostman.com/view/1134062/T1LJjU52).
1. Se utilizan tres endpoints que se pueden ver en la clase utilitaria [Constants](./countires-cities-client/src/main/java/com/jlopez/util/Constants.java).
1. Las clases qeu consumen al [cliente](./countires-cities-client/src/main/java/com/jlopez/client) estan divididas en tres, una para cada URL que se estará consultando
los métodos son de una línea, pero se dividen para ejemplificar que estan dedicadas a un solo path, y que posiblemente en un futuro se podrían agregar más métodos de consumo
y con diferente lógica. 
1. Creación de [POJOs](countires-cities-client/src/main/java/com/jlopez/entity) para representar las respuestas de la api.
