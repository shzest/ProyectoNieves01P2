public class Main {

    public static void main(String[] args) {
        CentroControl centro = new CentroControl();

        Vehiculo camion1 = new CamionAutonomo("CAM-001", "CAMION", "Tesla Semi", "180 km/h");
        Vehiculo dron1 = new DronTransporte("DRON-001", "DRON", "DJI Cargo", "120 km/h");
        Vehiculo dron2 = new DronTransporte("DRON-002", "DRON", "FlyBox X", "150 km/h");

        centro.registrarVehiculo(camion1);
        centro.registrarVehiculo(dron1);
        centro.registrarVehiculo(dron2);

        System.out.println("\n===== LISTA DE VEHICULOS =====");
        centro.listarVehiculos();

        System.out.println("\n===== BUSQUEDA POR ID =====");
        Vehiculo encontrado = centro.buscarVehiculo("DRON-001");
        if (encontrado != null) {
            System.out.println("Vehiculo encontrado: " + encontrado.getModelo()
            );
        }

        System.out.println("\n===== MODIFICACION =====");
        centro.modificarDatosVehiculo("CAM-001", "CAMION", "Tesla Semi 2026", "200 km/h");

        centro.listarVehiculos();

        System.out.println("\n===== ELIMINACION =====");
        centro.eliminarVehiculo("DRON-002");
        centro.listarVehiculos();

        System.out.println("\n===== VEHICULOS CONECTABLES =====");
        centro.mostrarConectables();

        System.out.println("\n===== LISTA DE IDS =====");
        centro.listaIds();

        System.out.println("\n===== CANTIDAD DE VEHICULOS =====");
        System.out.println("Total: " + centro.contarVehiculos());

        System.out.println("\n===== BUSQUEDA POR TIPO =====");
        centro.buscarVehiculoPorTipo("DRON");

        System.out.println("\n===== ORDENADOS POR ID =====");
        centro.ordenarPorId();

        System.out.println("\n===== ORDENADOS POR TIPO =====");
        centro.ordenarPorTipo();

        System.out.println("\n===== MONITOREO DE FLOTA =====");
        centro.monitorearFlota();
    }
}
