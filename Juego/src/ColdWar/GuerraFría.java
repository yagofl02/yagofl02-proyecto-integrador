package ColdWar;

import java.util.ArrayList;
import java.util.Scanner;

public class GuerraFría {
    // Creando el metodo para finalizar el programa
    public static boolean finPrograma() {
        boolean intentos = true;
        Scanner sc2 = new Scanner(System.in);
        // Bucle while para que se ejecute infinitamente mientras intentos sea true
        while (intentos) {
            // preguntando el usuario que desea hacer despues de acabar el juego
            System.out.println("¿Desea Salir del Juego? (\u001B[32m1: NO\u001B[0m, 2: SÍ)");
            int opcion2 = sc2.nextInt();
            // Dependiendo de la opción elegida por el usuario se ejecuta una cosa o la otra
            // (2 para para el programa)
            if (opcion2 == 2) {
                intentos = false;
                System.out.println("Vuelve Pronto");
                break;
            } else if (opcion2 == 1) {
                intentos = true;
                break;
            } else {
                // Si el usuario introduce un numero no válido o una cadena de texto aparecera
                // este mensaje y le volvera a preguntar
                System.out.println("\33[31mERROR: Introduce una opción válida.\u001B[0m");
            }
        }
        sc2.close();
        // retornando true o false (se parara o continuara el programa)
        return intentos;
    }

    // Creando la lógica del juego
    static void jugar() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Equipo equipo3 = new Equipo();
        Equipo equipo4 = new Equipo();
        Equipo equipo5 = new Equipo();

        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(equipo1);
        equipos.add(equipo2);
        equipos.add(equipo3);
        equipos.add(equipo4);
        equipos.add(equipo5);

        System.out.println("Nombre de los equipos: ");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Nombre equipo " + i + " ->");
            equipos.get(i - 1).setNombre(sc.nextLine());
        }

        // Numero del equipo
        for (int i = 0; i < equipos.size(); i++) {
            equipos.get(i).setNumero(i);
        }

        // Vidas de los jugadores (5 Humanos)
        int[] vidas = { equipos.get(0).getVidas(), equipos.get(1).getVidas(), equipos.get(2).getVidas(),
                equipos.get(3).getVidas(), equipos.get(4).getVidas() };

        // Contadores
        int contadorRondas = 1;

        boolean condicionBucle = true;

        // La lógica del juego de como se desarrollara este según las decisiones de cada
        // uno por ronda
        while (condicionBucle) {
            // Contador para llevar el registro de si los jugadores estan vivos o no
            int vivos = 0;
            for (int vida : vidas) {
                if (vida > 0) {
                    vivos++;
                }
            }

            // Numero de vidas de los jugadores al inicio de la ronda
            int vidaInicioRondaJugador1 = vidas[0];
            int vidaInicioRondaJugador2 = vidas[1];
            int vidaInicioRondaJugador3 = vidas[2];
            int vidaInicioRondaJugador4 = vidas[3];
            int vidaInicioRondaJugador5 = vidas[4];

            /*
             * Si solo queda un jugador con vida el jugador
             * que queda con vida gana
             */
            if (vivos == 1) {
                break;
            }

            // Contador con las rondas
            System.out.println("-----------------------------------------------------");
            System.out.println("RONDA " + contadorRondas);
            System.out.println("-----------------------------------------------------");

            /*
             * Bucle que pregunta por el numero de misiles con los que quiere atacar el
             * jugador
             */
            for (int i = 0; i < 5; i++) {
                if (vidas[i] > 0) { // Ignora los jugadores que ya no estan en la partida ya que no les quedan vidas
                    // Funcionamiento de los misiles
                    int misilesAtaque = 0;
                    System.out.println(equipos.get(i).getNombre()
                            + ", ¿Con cuantos misiles atacas y con cuantos defiendes? (Tienen que sumar 50)");
                    // Cantidad de misiles de defensa
                    System.out.println("¿Misiles defensa?");
                    equipos.get(i).setMisilesDefensa(sc.nextInt());
                    // Si usa todos los misiles en defensa no se le preguntaria por los de ataque
                    if (equipos.get(i).getMisilesDefensa() == 25) {
                        System.out.println("Te defiendes con " + equipos.get(i).getMisilesDefensa() + " misiles");
                        vidas[i] += equipos.get(i).getMisilesDefensa() * 2;
                    } else if (equipos.get(i).getMisilesDefensa() < 25) { // Si no usa todos en defensa se le pregunta
                                                                          // con cuantos quiere atacar
                        while ((equipos.get(i).getMisilesDefensa() * 2) + misilesAtaque != 50) {
                            System.out.println("¿Misiles ataque?");
                            equipos.get(i).setMisilesAtaque(sc.nextInt());
                            if ((equipos.get(i).getMisilesDefensa() * 2)
                                    + equipos.get(i).getMisilesAtaque() != 50) { /*
                                                                                  * Si no da 50 misiles de forma
                                                                                  * exacta se le pide que vuelva a poner
                                                                                  * los misiles que quiere usar
                                                                                  */

                                System.out.println("Los misiles usados en ataque y en defensa deben sumar 50");
                            } else {
                                break;
                            }
                        }

                        System.out.printf("¿A quién quieres atacar, %s? (1-5)\n", equipos.get(i).getNombre());
                        int decisionAtacar = sc.nextInt() - 1; // Para que coincida con el vector
                        // Sistema con el que se seleccionan a los jugadores a los que se quiera atacar
                        while (true) {
                            if (decisionAtacar == equipos.get(i).getNumero()) {
                                System.out.println("No te puedes atacar a ti mismo, elige una opción correcta");
                                System.out.printf("¿A quién quieres atacar, %s? (1-5)\n", equipos.get(i).getNombre());
                                decisionAtacar = sc.nextInt() - 1;
                            } else if (decisionAtacar < 0 || decisionAtacar > 4) {
                                System.out.println("Opción inválida, elige una opción correcta");
                                System.out.printf("¿A quién quieres atacar, %s? (1-5)\n", equipos.get(i).getNombre());
                                decisionAtacar = sc.nextInt() - 1;
                            } else if (decisionAtacar >= 0 && decisionAtacar < 5 && vidas[decisionAtacar] > 0
                                    && decisionAtacar != i) {
                                vidas[decisionAtacar] -= equipos.get(i).getMisilesAtaque();
                                System.out.printf("%s ataca a %s con %d %s\n", equipos.get(i).getNombre(),
                                        equipos.get(decisionAtacar).getNombre(), equipos.get(i).getMisilesAtaque(),
                                        (equipos.get(i).getMisilesAtaque() == 1 ? "misil" : "misiles"));
                                break;
                            } else {
                                System.out.println("El jugador elegido esta muerto, elige una opción correcta");
                                System.out.printf("¿A quién quieres atacar, %s? (1-5)\n", equipos.get(i).getNombre());
                                decisionAtacar = sc.nextInt() - 1;
                            }
                        }

                        if (equipos.get(i).getMisilesDefensa() != 1) {
                            System.out.println("Te defiendes con " + equipos.get(i).getMisilesDefensa() + " misiles");
                            vidas[i] += equipos.get(i).getMisilesDefensa() * 2;
                        } else {
                            System.out.println("Te defiendes con 1 misil");
                            vidas[i] += equipos.get(i).getMisilesDefensa() * 2;
                        }
                    }
                    // Mira que no se sumen vidas a los juegadores

                    if (vidas[0] > vidaInicioRondaJugador1) {
                        vidas[0] = vidaInicioRondaJugador1;
                    } else if (vidas[0] <= 0) {
                        vidas[0] = 0;
                    }

                    if (vidas[1] > vidaInicioRondaJugador2) {
                        vidas[1] = vidaInicioRondaJugador2;
                    } else if (vidas[1] <= 0) {
                        vidas[1] = 0;
                    }

                    if (vidas[2] > vidaInicioRondaJugador3) {
                        vidas[2] = vidaInicioRondaJugador3;
                    } else if (vidas[2] <= 0) {
                        vidas[2] = 0;
                    }

                    if (vidas[3] > vidaInicioRondaJugador4) {
                        vidas[3] = vidaInicioRondaJugador4;
                    } else if (vidas[3] <= 0) {
                        vidas[3] = 0;
                    }

                    if (vidas[4] > vidaInicioRondaJugador5) {
                        vidas[4] = vidaInicioRondaJugador5;
                    } else if (vidas[4] <= 0) {
                        vidas[4] = 0;
                    }
                }
            }
            contadorRondas++;

            // Mensaje que muestra las vidas restantes de cada equipo al acabar la ronda
            System.out.println();
            System.out.println("\33[33mVidas después de la ronda: ");
            System.out.printf("%s: %d   %s: %d   %s: %d   %s: %d   %s: %d\u001B[0m\n", equipos.get(0).getNombre(),
                    vidas[0], equipos.get(1).getNombre(), vidas[1], equipos.get(2).getNombre(), vidas[2],
                    equipos.get(3).getNombre(), vidas[3], equipos.get(4).getNombre(), vidas[4]);
        }

        // Muestra por pantalla el ultimo jugador con vida aka ganador de la partida
        for (int j = 0; j < 5; j++) {
            if (vidas[j] > 0) {
                System.out.println();
                System.out.printf("\u001B[32m%s ha GANADO la partida\u001B[0m\n", equipos.get(j).getNombre());
                break;
            }
        }

        // Mensaje de fin de
        System.out.println("fin de juego");
    }

    public static void main(String[] args) {
        // variables y Clases
        boolean intentos = true;
        Scanner sc = new Scanner(System.in);

        /*
         * Eleccion de opcion del usuario dentro de un bucle while para que siga
         * ejecutandose si no se selecciona cierta opcion
         */

        System.out.println("Bienvenido al Juego de la Guerra Fría ");
        while (intentos) {
            System.out
                    .println("Elige una opción (1: Jugar, 2: Reglas, 3: Información, 4: Apartado Abierto , 0: Salir):");
            int opcionElegida = sc.nextInt();
            // Se ejecuta el codigo de la opccion elegida
            if (opcionElegida == 1) {
                System.out.print("Has elegido la opción 1 (Jugar) ->");
                System.out.println(" Comienza el juego!!");
                jugar();
                System.out.println();
            } else if (opcionElegida == 2) {
                // Mensaje que muestra las reglas del juego
                System.out.println("\33[31mREGLAS DEL JUEGO (IMPORTANTE)");
                System.out.println("\33[33mHay 5 jugadores, cada jugador tiene 200 de vida y 50 misiles por ronda." +
                        "\n\33[33mLos misiles usados en defensa cuestan el doble que los usados en ataque." +
                        "\nEstos no se conservan entre rondas. La suma de los misiles para la defensa y\n" +
                        "ataque deben sumar 50 misiles.\nEJEMPLO: (10 misiles ataque + 20 misiles defensa = 50 misiles).\u001B[0m");
                System.out.println();
            } else if (opcionElegida == 3) {
                // Apartado de informacion adicional (Nombre, email y version del juego)
                System.out.println("Autor: Yago Fernandez Loza");
                System.out.println("Email: yagofl02@educastur.es");
                System.out.println("Version 1.0");
                System.out.println();
            } else if (opcionElegida == 4) {
                // Mensaje proximamente, no acabado
                System.out.println("PRÓXIMAMENTE");
                System.out.println();
            } else if (opcionElegida == 0) {
                // Finaliza el bucle del programa y acaba las acciones
                if (!finPrograma()) {
                    intentos = false;
                }
                System.out.println();
            } else { // Muestra que no es una opcion correcta
                System.out.println("\33[31mNo has elegido ninguna opción válida\u001B[0m");
                System.out.println();
            }
        }
        sc.close();
    }
}
