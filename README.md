Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---
Entrega 2
----------------
Para esta entrega el programa presenta funcionalidad parcial, sólamente habiendo batallas que utilizan la cola de turnos
de forma que genera un intercambio aleatorio de ataques entre personajes de la party y los enemigos.

Dentro del modelo se encuentran personajes, que pueden diferenciarse
a gran escala como personajes de la party del guador (PC) y enemigos
que no son controlados por el jugador (NPC). Los PC pueden ser una de las
5 clases Knight, Thief, Engineer, Black Mage, y White Mage, siendo estos últimos
un tipo de "PC Mago", que tiene un atributo adicional relacionado con la magia que se
implementará en un futuro. 

Los PC pueden equiparse armas que son representadas como un objeto. Las armas se pueden clasificar como
arcos, espadas, hachas, bastones, y cuchillos. Dependiendo de la clase del PC, estos pueden equiparse sólo
ciertos tipos de armas. 

El jugador tiene un grupo de 3 personajes controlables llamado _party_, y maneja un inventario que tiene 20 _slots_
en los cuales se pueden guardar armas. 

Los enemigos se agrupan en _enemy groups_ o _mobs_, que pueden contener hasta 4 enemigos.

Las batallas son gestionadas por el _Game Controller_, que maneja una cola de turnos en la cual los personajes van
ingresando repetidamente, después de haber esperado un periodo de tiempo proporcional a su peso,luego de haber realizado 
su turno. Cada personaje se encarga de "contar" cuánto tiempo debe esperar para que sea nuevamente su turno, y se
comunica con el controlador mediante handlers que implementan el patrón de diseño de observador.



