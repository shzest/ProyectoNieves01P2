import java.util.ArrayList;
public class CentroControl {
    private ArrayList<Vehiculo> flota;

    public CentroControl(){
        flota = new ArrayList<>();
    }

    public void registrarUnidad( Vehiculo v) {
        flota.add(v);
    }

    public void monitorearFlota() {
        flota.forEach(vehicl -> {
            vehicl.patronMovimiento();

            if (vehicl instanceof IConectable) {
                ((IConectable) vehicl).sincronizarGPS();
            }
        });
    }
}
