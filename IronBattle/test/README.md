# Proyecto "IronBattle"

"IronBattle" es un emocionante juego de rol desarrollado en Java que sumerge a los jugadores en un mundo de batallas épicas entre personajes únicos tales como Elfos, guerreros, magos entre otros

## Descripción del Proyecto

"IronBattle" es un juego de rol por turnos donde dos personajes se enfrentan en combate. El jugador puede elegir entre cuatro tipos de personajes distintos, cada uno con habilidades especiales y características únicas:

- Guerrero: Un guerrero valiente con gran fuerza física
- Mago: Un hechicero poderoso con habilidades mágicas devastadoras
- Hombre Lobo: Un ser mitológico con transformaciones lunares
- Elfoscuro: Un elfo oscuro con habilidades de sigilo y venenos mortales

Cada personaje tiene estadísticas aleatorias al inicio del juego, lo que garantiza una experiencia única en cada partida. El objetivo es derrotar al oponente antes de que te derrote él, utilizando estrategia y aprovechando las habilidades especiales de tu personaje.

## Funcionalidades Principales

### Sistema de Combate por Turnos

- Los personajes se turnan para atacar o defender
- Cada acción consume energía, limitando las acciones por turno
- El juego termina cuando un personaje alcanza cero puntos de vida

### Habilidades Especiales

Cada personaje tiene una habilidad única que puede ser utilizada en momentos estratégicos del combate:

- Guerrero: Golpe Crítico (duplica el daño del ataque normal)
- Mago: Escudo Mágico (reduce el daño recibido durante un turno)
- Hombre Lobo: Transformación Lunar (aumenta la fuerza y velocidad durante varios turnos)
- Elfoscuro: Veneno Silencioso (aplica un efecto de veneno que reduce gradualmente la salud del oponente)

### Bonificaciones según el Momento del Día

El juego incluye un sistema de ciclo día/noche que afecta las estadísticas de los personajes:

- Los Guerreros son más fuertes durante el día
- Los Magos tienen mayor poder mágico por la noche
- Los Hombres Lobos se vuelven más poderosos durante la luna llena
- Los Elfoscuros son más sigilosos y letales en la oscuridad nocturna

### Sistema de Escape

Los jugadores pueden intentar escapar del combate, pero esto conlleva riesgos:

- Hay una probabilidad aleatoria de éxito
- Si falla, el oponente obtiene un turno adicional como castigo

## Tecnologías Utilizadas

Este proyecto aprovecha las siguientes tecnologías y conceptos de Java:

- Programación orientada a objetos (POO)
- Interfaces y clases abstractas para una estructura modular
- Manejo de entrada/salida estándar para la interacción con el usuario
- Generación aleatoria de números para crear estadísticas únicas y resultados impredecibles
- Uso de enums para representar constantes como tipos de personajes y acciones

## Estructura del Proyecto

El proyecto se organiza en las siguientes clases principales:

### Character.java

Clase base abstracta que define las propiedades comunes de todos los personajes:

- Nombre
- Tipo de personaje
- Nivel
- Puntos de vida
- Energía
- Fuerza
- Defensa
- Velocidad

Métodos abstractos para ataques básicos y especiales.

### Warrior.java, Wizard.java, Werewolf.java, DarkElf.java

Subclases específicas que extienden Character y sobrescriben métodos para implementar habilidades únicas:

- Implementan ataques básicos y especiales específicos de cada personaje
- Sobrescriben métodos para calcular bonificaciones según el momento del día

### Combat.java

Clase responsable de gestionar el flujo del combate:

- Gestiona turnos alternados entre los dos personajes
- Aplica reglas de juego como límites de energía y efectos de habilidades especiales
- Determina el ganador cuando un personaje alcanza cero puntos de vida

### Attacker.java

Interfaz que define el contrato para cualquier objeto capaz de realizar ataques:

- Métodos para calcular daño y aplicar efectos secundarios

### Main.java

Punto de entrada del programa:

- Crea instancias de personajes
- Inicializa el combate
- Gestiona la interacción con el usuario mediante la consola

## Cómo Ejecutar el Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona este repositorio a tu máquina local:

git clone https://github.com/tu-usuario/IllBeatYouFirst.git


2. Abre el proyecto en tu IDE IntelliJ  

3. Compila todos los archivos .java:

javac *.java

4. Ejecuta la clase Main.java:

java Main


5. Sigue las instrucciones en pantalla para seleccionar personajes y jugar

## Pruebas Unitarias

El proyecto incluye una clase CombatTest.java con pruebas JUnit para verificar el funcionamiento básico del combate:

- Testeo de ataques básicos y especiales
- Pruebas de escape exitoso y fallido

Para ejecutar las pruebas unitarias:

javac -cp "junit.jar" CombatTest.java java -cp ".;junit.jar" org.junit.runner.JUnitCore CombatTest

