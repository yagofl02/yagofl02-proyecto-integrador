package ColdWar;

import java.util.Scanner;

public class ColdWar {
    // Metodo para que finalice el programa
    public static boolean finPrograma() {
        boolean intentos = true;
        // Bucle infinito hasta que se de un valor que finalice el bucle
        while (intentos) {
            Scanner sc2 = new Scanner(System.in);
            // Confirmacion de la salida del juego
            System.out.println("¿Quieres salir? (\u001B[32m1: Si\u001B[0m, \\ NO");
            int opcion2 = sc2.nextInt();
            // Se ejecutara la eleccion del usuario
            if (opcion2 == 0) {
                intentos = true;
                System.out.println("Vuelve Pronto!");
                break;
            } else if (opcion2 == 1) {
                intentos = false;
                break;
            } else {
                // Mensaje por si se elige una opción no valida en el menu
                System.out.println("\33[31mERROR: Introduce una opción válida.\u001B[0m");
            }
            sc2.close();
        }
        // si devuelve false el programa se acabará
        return intentos;
    }

    public static void main(String[] args) {
        // Variables y Clases
        int opSelec;

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a Cold War! ");

        do {

            System.out.println(
                    "------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println(
                    "Elige una opción (1. Jugar (2. Reglas del juego (3. Informacion (4.Apartado abierto (5.Salir");
            System.out.println();
            System.out.println(
                    "------------------------------------------------------------------------------------------");
            opSelec = sc.nextInt();
            // Se selecciona

            if (opSelec == 1) {
                jugar();
                break;
            }

            // Funcionamiento del juego
            else if (opSelec == 2) {

                System.out.println("\33[35mReglas de la partida");
                System.out.println(
                        "\33[35mConsta de 5 equipos, cada equipo empieza con 200 puntos de vida y cada ronda serecargan 50 misiles."
                                +
                                "\n\33[35mCon los misiles puedes atarcar o defenderte, en defensa los misiles cuestan el doble."
                                +
                                "\nLa cantidad de misiles se reinicia cada ronda. La suma de los misiles usados para la densa o\n"
                                +
                                "el ataque siempre tienen que sumar 50 misiles si no se invalidaria la ronda.\u001B[0m");
            }

            // Informacion de contacto

            else if (opSelec == 3) {
                String amarillo = "\033[93m";

                String reset = "\033[0m";

                System.out.println(amarillo);
                System.out.println("Autor: Yago Fernandez Loza");
                System.out.println("Correo: yagofl02@educastur.es");
                System.out.println("Version actual 1.0");
                System.out.println(reset);

                System.out.println();
                System.out.println();
            }
            // apartado abierto

            else if (opSelec == 4) {
                System.out.println();
                System.out.println("Próximamente");
                System.out.println();
            }


        } while (opSelec != 5);

        sc.close();
    }

    private static void jugar() { // Clase que contiene la primera versión de lo que sería el juego
        System.out.print("Has elegido la opción 1 (Jugar) ->");
        System.out.println(" Comienza el juego");
        Scanner nm = new Scanner(System.in);
        System.out.println("Introduce el nombre de los jugadores");
        String[] nombres = new String[5];
        for (int i = 0; i < 5; i++) {
            nombres[i] = nm.next();
        }

        System.out.printf("Los nombres elegidos son: %s, %s, %s, %s, %s\n", nombres[0], nombres[1], nombres[2],
                nombres[3], nombres[4]); //Muestra por pantalla los nombres elegidos por los jugadores

        int[] vidas = {200, 200, 200, 200, 200}; // Vector que almacena las vidas de los jugadores
        int ronda = 1; // Inicializamos el contador de rondas

        while (true) { // Esto haria qeu el bucle sea un bucle infinito
            // Contador para contbilizar los jugadores que queden con vida
            int jugadoresVivos = 0;
            for (int vida : vidas) {
                if (vida > 0) {
                    jugadoresVivos++;
                }
            }

            // Cuando solo quede un jugador con vida acabaria la partida
            if (jugadoresVivos <= 1) {
                break; // Al solo quedar uno con vida saldria del bucle y acabaria la partida
            }

            System.out.println("---------");
            System.out.println();
            System.out.printf("RONDA %d\n", ronda); // Mostrar el número de ronda
            System.out.println();
            System.out.println("---------");
            for (int i = 0; i < 5; i++) {
                System.out.printf("Vidas de %s: %d \n", nombres[i], vidas[i]); // El nombre y el número de vidas que
                                                                               // tiene cada jugador
            }

            // Cada jugador elige si ataca o se defiende
            for (int i = 0; i < 5; i++) {
                if (vidas[i] > 0) { // Este if hace que solo los jugadores vivos puedan realizar acciones
                    System.out.printf("%s, ¿Qué quieres hacer? (1) Atacar (2) Defenderte: ", nombres[i]);
                    int eleccion = nm.nextInt();

                    if (eleccion == 1) {
                        System.out.println("Elegiste Atacar");
                        System.out.println("¿A qué jugador quieres atacar? (1-5)");
                        int jugadorObjetivo = nm.nextInt() - 1; // Restamos 1 para que coincida con el índice del array

                        if (jugadorObjetivo >= 0 && jugadorObjetivo < 5 && vidas[jugadorObjetivo] > 0
                                && jugadorObjetivo != i) {
                            int daño = 50; // Suponiendo que el daño de un ataque es 50
                            vidas[jugadorObjetivo] -= daño; // Reducir la vida del jugador objetivo
                            System.out.printf("%s ha atacado a %s causando %d de daño.\n", nombres[i],
                                    nombres[jugadorObjetivo], daño);
                        } else {
                            System.out.println("Jugador seleccionado no es válido o ya no está en la partida.");
                        }
                    } else if (eleccion == 2) {
                        System.out.println("Has elegido defenderte"); // Elección 2 del jugador
                        // No se hace daño al defenderse
                    } else {
                        System.out.println("No es una opción válida");
                    }
                }
            }
            ronda++; // Incrementar el número de ronda al final de cada iteración
        }

        for (int i = 0; i < 5; i++) {
            if (vidas[i] > 0) {
                System.out.printf(("\u001B[33m%s gano la partida con %d vidas restantes\u001B[0m\n"), nombres[i], vidas[i]);
                break;
            }
        }

        nm.close();
    }
}