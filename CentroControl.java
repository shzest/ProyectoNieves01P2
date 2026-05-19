import java.util.ArrayList;
public class CentroControl {
    private ArrayList<Vehiculo> flota;

    public CentroControl(){
        flota = new ArrayList<>();
    }

    // CRUD
    public void registrarVehiculo(Vehiculo v) {
        flota.add(v);
    }

    public void listarVehiculos(){
        flota.forEach(veh -> {
            System.out.println("ID #"+veh.getId()+" | [Tipo: "+veh.getTipoVehiculo()+" ] | [Modelo: "+veh.getModelo()+" ] | [Velocidad Maxima: "+veh.getVelMax()+" ]");
        });
    }

    public Vehiculo buscarVehiculo(String id) {
        for ( Vehiculo veh :flota ){
            if (veh.getId().equals(id)){
                return veh;
            }
        }
        System.out.println("Vehiculo no encontrado.");
        return null;
    }

    public void modificarDatosVehiculo(String id,String tipoVehiculo, String modelo, String velMaxima  ){
        Vehiculo veh = buscarVehiculo(id);
        if (veh==null){
            return;
        }
        veh.setTipoVehiculo(tipoVehiculo);
        veh.setModelo(modelo);
        veh.setVelMax(velMaxima);
        System.out.println("Los datos del vehiculo han sido actualizados correctamente.");
    }

    public void eliminarVehiculo (String id){
        flota.remove(buscarVehiculo(id));
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
