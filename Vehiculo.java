public abstract class Vehiculo {
    private final String id;
    private String tipoVehiculo;
    private String velMax;
    private String modelo;

    public Vehiculo( String id, String tipoVehiculo, String modelo, String velMax) {
        this.id=id;
        this.velMax =velMax;
        this.tipoVehiculo=tipoVehiculo;
        this.modelo=modelo;
    }

    public String getId(){ return id; }
    public String getVelMax() {
        return velMax;
    }
    public String getTipoVehiculo(){ return tipoVehiculo;}
    public String getModelo() {return modelo; }

    public void setVelMax(String velMax) {this.velMax = velMax; }
    public void setTipoVehiculo( String tipoVehiculo) {this.tipoVehiculo=tipoVehiculo; }
    public void setModelo (String modelo ) {this.modelo=modelo;}

    public abstract void patronMovimiento();
}
