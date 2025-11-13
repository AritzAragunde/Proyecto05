
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int respuesta = 0;

    do {
        try {
            System.out.println("\n========= MENU =========\n" +
                    "1) Inscribir Equipos \n" +
                    "2) Inscribir Jugadores\n" +
                    "3) Salir");

            respuesta = sc.nextInt();
            sc.nextLine();

            switch (respuesta) {
                case 1:
                    equipos();
                    break;
                case 2:
                    jugadores();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } catch (Exception e) {
            System.err.println("Error: Debe introducir un número válido.");
            sc.nextLine();
        }

    } while (respuesta != 3);

    sc.close();

    }
}


