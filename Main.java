public class Main {
    public static void main(String[] args) {
        CentroControl centro = new CentroControl();

        Vehiculo dron = new DronTransporte("DRON-001","DRON","KZN","20");
        Vehiculo camion = new CamionAutonomo("CAM-001","CAMION","CANIA","100");

        centro.registrarVehiculo(dron);
        centro.registrarVehiculo(camion);
        centro.listarVehiculos();
        centro.buscarVehiculo("DRON-001");
        centro.monitorearFlota();
        centro.modificarDatosVehiculo("CAM-001","CAMION","SCANIA","110");
        centro.listarVehiculos();
        centro.mostrarConectables();
    }
}
