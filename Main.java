public class Main {
    public static void main(String[] args) {
        CentroControl centro = new CentroControl();

        Vehiculo dron = new DronTransporte("Dron1");
        Vehiculo camion = new CamionAutonomo("Camion1");

        centro.registrarUnidad(dron);
        centro.registrarUnidad(camion);

        centro.monitorearFlota();
    }
}