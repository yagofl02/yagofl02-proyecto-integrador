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

        do {
            System.out.println("Bienvenido a Cold War! ");

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
                System.out.println("Próximamente");
            }

        } while (opSelec != 5);

        sc.close();

    }
    private static void jugar() { //clase en la que estaria el juego como tal actualmente
        System.out.print("Has elegido la opción 1 (Jugar) ->");
        System.out.println(" Comienza el juego");
        Scanner nm = new Scanner(System.in); // Clase Scanner para seleccionar combre y las eleccciones que realizan los jugadores
        System.out.println("Introduce el nombre de los jugadores");
        String[] nombres = new String[5]; // Array donde se almacenan los nombres elegidos por los jugadores 
        for (int i = 0; i < 5; i++) { // para que no se salgan del array
            nombres[i] = nm.next();
        }
    
        System.out.printf("Los nombres elegidos son: %s, %s, %s, %s, %s\n", nombres[0], nombres[1], nombres[2], nombres[3], nombres[4]);
    
        int[] vidas = {200, 200, 200, 200, 200}; // Vector que almacena las vidas de los jugadores
    
        while (vidas[0] > 0 && vidas[1] > 0 && vidas[2] > 0 && vidas[3] > 0 && vidas[4] > 0) { // bucle inicial para que finalice el juego (Hay que cambiarlo ya que solo sirve para que pierda 1 jugador)
            for (int i = 0; i < 5; i++) {
                System.out.printf("Vidas de %s: %d \n", nombres[i], vidas[i]); // El nombre y el número de vidas que tiene cada jugador 
            }
    
            System.out.println("Que quieres hacer? (1) Atacar (2) Defenderte");
            int eleccion = nm.nextInt();
    
            if (eleccion == 1) {
                System.out.println("Elegiste Atacar");
                System.out.println("¿A qué jugador quieres atacar? (1-5)");
                int jugadorObjetivo = nm.nextInt() - 1; // Se resta uno para que la eleccion coincida con la que esta en el array
    
                if (jugadorObjetivo >= 0 && jugadorObjetivo < 5 && vidas[jugadorObjetivo] > 0) {
                    int daño = 50; // Suponiendo que el daño de un ataque es 50
                    vidas[jugadorObjetivo] -= daño; // Reducir la vida del jugador objetivo
                    System.out.printf("%s ha atacado a %s causando %d de daño.\n", nombres[0], nombres[jugadorObjetivo], daño);
                } else {
                    System.out.println("Jugador objetivo no válido o ya está fuera del juego.");
                }
            } else if (eleccion == 2) {
                System.out.println("Has elegido defenderte"); // Elección 2 del jugador
                // No se hace daño al defenderse por ahora solo por comodidad
            
            } else {
                System.out.println("No es una opción válida");
                continue; // Si la elección no es válida, el bucle se repetiria hasta que elijas una eleccion valida
            }
        }
    
        nm.close();
    }
}
