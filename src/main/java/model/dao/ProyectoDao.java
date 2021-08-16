package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.Lider;
import model.vo.Proyecto;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

public class ProyectoDao {

    public ArrayList<Proyecto> query_requerimiento_1() throws SQLException {

        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conexion = JDBCUtilities.getConnection();
        try {
            String consulta = "SELECT Fecha_Inicio , Numero_Habitaciones, Clasificacion FROM Proyecto  WHERE Ciudad == 'Manizales'";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(resultSet.getInt("Numero_Habitaciones"));
                objProyecto.setClasificacion(resultSet.getString("Clasificacion"));
                proyectos.add(objProyecto);
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la consulta " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
        return proyectos;

    }

    public ArrayList<Proyecto> query_requerimiento_2() throws SQLException {
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conexion = JDBCUtilities.getConnection();
        try {
            ResultSet query = conexion.createStatement().executeQuery(
                    "SELECT p.Fecha_Inicio, p.Numero_Habitaciones, p.Clasificacion, l.Nombre, l.Primer_Apellido, t.Estrato FROM Proyecto p INNER JOIN Lider l ON p.ID_Lider = l.ID_Lider INNER JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo WHERE p.Ciudad == 'Manizales'");
            while (query.next()) {
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(query.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(query.getInt("Numero_Habitaciones"));
                objProyecto.setClasificacion(query.getString("Clasificacion"));
                objProyecto.setEstrato_proyecto(query.getInt("Estrato"));
                String nombre_lider = query.getString("Nombre");
                String apellido_lider = query.getString("Primer_Apellido");
                Lider objLider = new Lider(nombre_lider, apellido_lider);
                objProyecto.setLider(objLider);
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return proyectos;

    }// Fin del método query_requerimiento_2

    public ArrayList<Proyecto> query_requerimiento_3() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        try {
            ResultSet query = conexion.createStatement().executeQuery(
                    "SELECT COUNT(p.Clasificacion) as 'Condominios', p.Constructora as 'Constructora' FROM Proyecto p WHERE p.Clasificacion  == 'Condominio' GROUP BY Constructora");
            while (query.next()) {
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_condominios(query.getInt("Condominios"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return proyectos;

    }// Fin del método query_requerimiento_3

    public ArrayList<Proyecto> query_requerimiento_5() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        try {
            ResultSet query = conexion.createStatement().executeQuery(
                    "SELECT COUNT(p.clasificacion) as 'Condominios', p.Constructora as 'Constructora' FROM Proyecto p WHERE p.Clasificacion  == 'Condominio'GROUP BY Constructora HAVING Condominios > 11 ORDER BY Condominios");
            while (query.next()) {
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_condominios(query.getInt("Condominios"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return proyectos;

    }// Fin del método query_requerimiento_4

}