public class CamionAutonomo extends Vehiculo {
    public CamionAutonomo( String id, String tipoVehiculo, String modelo, String velMax) {
        super(id, tipoVehiculo, modelo, velMax);
    }

    @Override
    public void patronMovimiento(){
        System.out.println("El Camion se mueve hacia al norte a 80km/h.");
    }
}
