package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Lider;

public class LiderDao {

    public ArrayList<Lider> query_requerimiento_4() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        ArrayList<Lider> lideres = new ArrayList<Lider>();
        // Consultas
        try {
            ResultSet query = conexion.createStatement().executeQuery(
                    "SELECT l.Nombre, l.Primer_Apellido FROM Proyecto p INNER JOIN Lider l ON p.ID_Lider = l.ID_Lider  WHERE p.Ciudad =='Manizales'");
            while (query.next()) {
                Lider objLider = new Lider(query.getString("Nombre"), query.getString("Primer_Apellido"));
                lideres.add(objLider);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return lideres;
    }// Fin del método query_requerimiento_4

}