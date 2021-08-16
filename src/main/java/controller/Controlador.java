package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

import model.dao.LiderDao;
import model.dao.ProyectoDao;
import model.vo.Lider;
import model.vo.Proyecto;

//Librerías para bases de datos
import java.sql.SQLException;

public class Controlador {

    private final ProyectoDao proyectoDao;
    private final LiderDao liderDao;

    public Controlador() {
        this.proyectoDao = new ProyectoDao();
        this.liderDao = new LiderDao();
    }

    public ArrayList<Proyecto> Solucionar_requerimiento_1() throws SQLException {
        return this.proyectoDao.query_requerimiento_1();
    }

    public ArrayList<Proyecto> Solucionar_requerimiento_2() throws SQLException {
        return this.proyectoDao.query_requerimiento_2();

    }

    public ArrayList<Proyecto> Solucionar_requerimiento_3() throws SQLException {
        return this.proyectoDao.query_requerimiento_3();
    }

    public ArrayList<Lider> Solucionar_requerimiento_4() throws SQLException {
        return this.liderDao.query_requerimiento_4();
    }

    public ArrayList<Proyecto> Solucionar_requerimiento_5() throws SQLException {
        return this.proyectoDao.query_requerimiento_5();
    }

}
