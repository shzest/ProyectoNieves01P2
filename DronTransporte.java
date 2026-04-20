public class DronTransporte extends Vehiculo implements IConectable {
    public DronTransporte(String id) {
        super(id);
    }

    @Override
    public void patronMovimiento() {
        System.out.print("El dron vuela al oeste a 20 metros del suelo. ");
    }

    @Override
    public void sincronizarGPS() {
        System.out.println("El GPS esta sincronizado.");
    }
}
