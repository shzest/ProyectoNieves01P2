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

    // STREAMS
    public void mostrarConectables(){
        System.out.println(" Vehiculos conectables:");
        flota.stream().filter(veh ->
            veh instanceof IConectable).forEach(veh ->
                System.out.println("[ID #"+veh.getId()+" ] | [Tipo: "+veh.getTipoVehiculo()+" ] | [Modelo: "+veh.getModelo()+" ]")
        );
    }

    public void listaIds(){
        System.out.println(" Lista de Id's:");
        flota.stream()
                .map( veh -> veh.getId())
                .forEach(id ->
                    System.out.println(id)
                );
    }

    public long contarVehiculos(){
        return flota.stream().count();
    }

    public void buscarVehiculoPorTipo(String tipo){
        flota.stream().filter(veh -> veh.getTipoVehiculo().equalsIgnoreCase(tipo))
                .forEach(veh -> System.out.println("[ID #"+veh.getId()+" ] | [Tipo: "+veh.getTipoVehiculo()+" ] | [Modelo: "+veh.getModelo()+" ]"));
    }

    // ORDENAMIENTO
    public void ordenarPorId(){
        flota.stream().sorted((v1 , v2) -> v1.getId().compareTo(v2.getId()))
                .forEach( veh -> {
                    System.out.println("[ID #"+veh.getId()+" ] | [Tipo: "+veh.getTipoVehiculo()+" ] | [Modelo: "+veh.getModelo()+" ]");
                });
    }

    public void ordenarPorTipo(){
        flota.stream().sorted((v1 , v2) -> v1.getTipoVehiculo().compareTo(v2.getTipoVehiculo()))
                .forEach( veh -> {
                    System.out.println("[ID #"+veh.getId()+" ] | [Tipo: "+veh.getTipoVehiculo()+" ] | [Modelo: "+veh.getModelo()+" ]");
                });
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
