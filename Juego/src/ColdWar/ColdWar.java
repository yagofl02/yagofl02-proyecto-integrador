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
                System.out.println("Vuelve Pronto!!");
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
        boolean intentos = true;
        Scanner sc = new Scanner(System.in);

        // Sistema para dar a elegir la opcion al usuario
        while (intentos) {
            System.out.println("Bienvenido a Cold War! ");
            System.out.println(
                    "Elige una opción (1. Jugar (2. Reglas del juego (3. Informacion (4.Apartado abierto (5.Salir");
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

            if (!finPrograma()) {
                intentos = false;
            }

        }

        sc.close();

    }

    private static void jugar() {
        System.out.print("Has elegido la opción 1 (Jugar) ->");
        System.out.println(" Comienza el juego");
        Scanner nm = new Scanner(System.in);
        System.out.println("Introdue el nombre del jugardor");
        String nom = nm.next();
        System.out.println("El nombre elegido es: "+nom);
        int vidasJ = 200;
        int vidasM = 200;

        while (vidasJ > 0 && vidasM > 0) {
            System.out.println("Que quieres Atacar (1) o Defenderte(2)");
            int eleccionM = (int) Math.random();
            int eleccion = nm.nextInt();

            if (eleccion == 1) {
                System.out.println("Elegiste Atacar");
                vidasM = vidasM - 50;

                if (eleccion == 2) {
                    System.out.println("Has elegido defenderte");
                }
                

            }
            if (eleccionM == 1) {
                System.out.println("La maquina ha elegido atacar");
                vidasJ = vidasJ - 50;

                if (eleccionM == 2) {

                    System.out.println("La maquina ha elegido defenderse");

                }

            }

        }


        nm.close();


    }

}
