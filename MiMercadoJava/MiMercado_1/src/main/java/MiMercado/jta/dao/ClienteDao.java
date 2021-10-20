package MiMercado.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import MiMercado.jta.model.Cliente;
import MiMercado.jta.model.Conexion;

public class ClienteDao {
static Conexion con = null;
	
	public boolean guardar_Cliente(Cliente cliente)
	{
       Conexion con = null;
       Connection conexionBaseDatos  = null;
       boolean ingresoDatos = true;
       if(conexionBaseDatos==null)
       {
    	   con = new Conexion();
           conexionBaseDatos= con.conectar();
       }
        /*
        Cuando construimos una consulta normal de JDBC utilizamos un Statement, este Statement o sentencia 
        lo que se encarga es de definir una consulta SQL a ejecutar contra mysql.
        El uso de JDBC Prepared Statement es obligatorio. 
        */
       PreparedStatement prdStmt     = null;
       try
       {
           String strSenciaInsert = "insert into mimercado.usuarios  " +
                                    "(cedula, nombre, apellido, correo, celular, contraseña) " +
                                    "values " +
                                    "(?, ?, ?, ?, ?, ?) ";
           
           prdStmt = conexionBaseDatos.prepareStatement(strSenciaInsert);
           prdStmt.setString(1, cliente.getCedula());
           prdStmt.setString(2, cliente.getNombre());
           prdStmt.setString(3, cliente.getApellido());
           prdStmt.setString(4, cliente.getCorreo());
           prdStmt.setString(5, cliente.getCelular());
           prdStmt.setString(6, cliente.getPassword());
           
           prdStmt.execute();
       }catch(Exception e)
       {
           System.out.println("Se presento error al crear el registro "+e);
           ingresoDatos = false;
       }
       finally{
           try
           {
                conexionBaseDatos.close();
                Conexion.cerrar();
           }
           catch(Exception errorException)
           {
               System.out.println("Se presento error al cerrar la conexion a la base de datos "+errorException);
           }
       }
       
       return ingresoDatos;
   }

}
