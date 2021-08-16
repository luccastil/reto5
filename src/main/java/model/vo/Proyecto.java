package model.vo;

public class Proyecto {

    private String fecha_inicio;
    private int num_habitaciones;
    private String clasificacion;
    private int estrato_proyecto;
    private Lider lider;
    private int num_condominios;
    private String nombre_constructora;

    public Proyecto() {

    }

    /*******************************
     * Consultores y modificadores
     ********************************/

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getNum_habitaciones() {
        return num_habitaciones;
    }

    public void setNum_habitaciones(int num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Lider getLider() {
        return lider;
    }

    public void setLider(Lider lider) {
        this.lider = lider;
    }

    public int getEstrato_proyecto() {
        return estrato_proyecto;
    }

    public void setEstrato_proyecto(int estrato_proyecto) {
        this.estrato_proyecto = estrato_proyecto;
    }

    public int getNum_condominios() {
        return num_condominios;
    }

    public void setNum_condominios(int num_condominios) {
        this.num_condominios = num_condominios;
    }

    public String getNombre_constructora() {
        return nombre_constructora;
    }

    public void setNombre_constructora(String nombre_constructora) {
        this.nombre_constructora = nombre_constructora;
    }

    

}