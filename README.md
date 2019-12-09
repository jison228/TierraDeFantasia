# Tierra de Fantasía

## Reglas
1. No se acepta más de una raza incompleta.
2. Cada raza debe poder `atacar`, `descansar` y `recibirAtaque`.
3. Sólamente habrá puntaje si se evidencia el correcto funcionamiento mediante suficientes pruebas unitarias.

## Tips
1. Utilizar herencia y polimorfismo ayuda, pero no hasta descubrir un patrón de comportamiento.
2. Para probar más fácilmente, quizás conviene utilizar una raza adicional, "sabor a vainilla".
3. No hay un orden específico para las razas, y todas puntúan igual: elijan sabiamente por dónde empezar.

## Razas
Una Gricean tiene una salud inicial de 155. Utiliza una catapulta, y su rango de ataque es de 17 a 33 metros. Ocasiona un daño básico de 31 puntos. Cuando ataca, envenena a su enemigo, lo que hace que pierda 10 de vida después de que termine de realizar una acción (atacar o descansar). Al recibir un ataque se enfurece y sus ataques multiplican por 2 su valor (dura 2 turnos). Cuando descansa, reduce el daño del siguiente ataque recibido, a 1/4 del valor.

Una Hudin tiene una salud inicial de 100. Utiliza una espada larga, y su rango de ataque es de 1 a 3 metros. Ocasiona un daño básico de 83 puntos. Cuando ataca se cura un 3 por ciento de su salud cada vez. Al recibir un ataque recibe 2 veces el valor, ya que no lleva armadura. Cuando descansa, medita, y como considera la violencia como algo malo, se rehusa a atacar hasta que lo ataquen.

Una Cilnine tiene una salud inicial de 116. Utiliza sus dientes, y su rango de ataque es de menos de 1 metro. Ocasiona un daño básico de 54 puntos. Cuando ataca, lo hace con 2/7 de daño, cada 2 ataques. Después de recibir un ataque, si esta con vida, se cura un 20 por ciento de su salud total. Cuando descansa, se concentra y sus proximos 2 ataques dañan por el doble del valor correspondiente.

Un Rocnes tiene una salud inicial de 84. Utiliza una alabarda, y su rango de ataque es de menos de 5 metros. Ocasiona un daño básico de 51 puntos. Cuando ataca erra 2 de cada 8 ataques. Al recibir un ataque se desconcentra y sus ataques vuelven al valor normal inicial. Cuando descansa, aumenta su daño básico en 5 por cada vez que erró un ataque.

Un Gnikgers tiene una salud inicial de 86. Utiliza una katana, y su rango de ataque es de menos de 2 metros. Ocasiona un daño básico de 20 puntos. Cuando ataca, lo hace cada vez con más fuerza (4 puntos de daño extra x la cantidad de ataques dados). Al recibir un ataque lo hace normalmente. Cuando descansa, recupera toda su salud, pero se vuelve de piedra por 2 turnos, lo que hace que no pueda atacar, pero reduce el daño entrante en 1/3.

Un Apotonix tiene una salud inicial de 81. Utiliza un arco, y su rango de ataque es de 5 a 49 metros. Ocasiona un daño básico de 8 puntos. Cuando ataca, lo hace con más fuerza cada vez que recibe ataques (2 puntos elevados a la cantidad de ataques recibidos). Al recibir un ataque recibe 5/6 del valor, ya que tiene mucha armadura. Cuando descansa, recupera hasta el 25 por ciento de su salud inicial.