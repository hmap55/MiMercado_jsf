package MiMercado.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import MiMercado.jta.model.Conexion;
import MiMercado.jta.model.Producto;

public class TablaDao {
	
static Conexion con = null;
	
	public static ArrayList getProductos(){
		
       Conexion objeto_conexion=null;
       Connection conexion_bd = null;
       PreparedStatement prdStmt = null;
       ResultSet rstProductos = null;
       ArrayList productos= new ArrayList();
       
       try{
           
    	    String strStm = null;
    	    int intTamColumnas = 0;
    	    int intTamFilas = 0;
    	    objeto_conexion = new Conexion();
            conexion_bd = objeto_conexion.conectar();
            strStm = 	"	SELECT   	* "
            						+ "	FROM 		mimercado.compra";
            
            
            prdStmt = conexion_bd.prepareStatement(strStm);
            
            rstProductos = prdStmt.executeQuery();
            ResultSetMetaData rsMetaData = rstProductos.getMetaData(); 
            intTamColumnas = rsMetaData.getColumnCount();
		    
           
            while(rstProductos.next())
            {
            	ArrayList  arrListFila = new ArrayList (intTamColumnas);
				for (int i = 1; i <= intTamColumnas; i++) {
					arrListFila.add(new String((rstProductos.getString(i) == null) ? "" : (rstProductos.getString(i))));
				}
				productos.add(arrListFila);
				intTamFilas ++;
            	
            }
            
           
           
       }catch(Exception e)
       {
           System.out.println("Se presento un ERROR al realizar la consulta a la BD compras "+e);
       }
       
       finally{
           try
           {
        	   conexion_bd.close();
                Conexion.cerrar();
           }
           catch(Exception errorException)
           {
               System.out.println("Se presento error al cerrar la conexion a la base de datos "+errorException);
           }
       }
       
       
       return productos;
   }
	
	public boolean modificar_cantidad(String id, int cantidad, double total)
	{
      
	   Conexion objeto_conexion=null;
       Connection conexionBaseDatos  = null;
       boolean ingresoDatos = true;
       if(conexionBaseDatos==null)
       {
    	   
    	   objeto_conexion = new Conexion();
    	   conexionBaseDatos = objeto_conexion.conectar();
       }
        /*
        Cuando construimos una consulta normal de JDBC utilizamos un Statement, este Statement o sentencia 
        lo que se encarga es de definir una consulta SQL a ejecutar contra mysql.
        El uso de JDBC Prepared Statement es obligatorio. 
        */
       PreparedStatement prdStmt     = null;
       try
       {
           String strSenciaInsert = "	update  mimercado.compra "
           							+ " set 	cantidad=?, total=?"
           							+ "	where 	id=? ";
           
           prdStmt = conexionBaseDatos.prepareStatement(strSenciaInsert);
           prdStmt.setInt(1, cantidad);
           prdStmt.setDouble(2, total);
           
           prdStmt.setString(3, id);
        
           prdStmt.execute();
       }catch(Exception e)
       {
           System.out.println("Se presento error al crear el modificar a la tabla compra "+e);
           ingresoDatos = false;
       }
       finally{
           try
           {
                conexionBaseDatos.close();
                con.cerrar();
           }
           catch(Exception errorException)
           {
               System.out.println("Se presento error al cerrar la conexion a la base de datos "+errorException);
           }
       }
       
       return ingresoDatos;
   }
	
	
	public boolean eliminar(String id)
	{
      
	   Conexion objeto_conexion=null;
       Connection conexionBaseDatos  = null;
       boolean eliminar = true;
       if(conexionBaseDatos==null)
       {
    	   
    	   objeto_conexion = new Conexion();
    	   conexionBaseDatos = objeto_conexion.conectar();
       }
        /*
        Cuando construimos una consulta normal de JDBC utilizamos un Statement, este Statement o sentencia 
        lo que se encarga es de definir una consulta SQL a ejecutar contra mysql.
        El uso de JDBC Prepared Statement es obligatorio. 
        */
       PreparedStatement prdStmt     = null;
       try
       {
           String strSenciaInsert = "	delete from mimercado.compra "
                  							+ "	where 	id=? ";
           
           prdStmt = conexionBaseDatos.prepareStatement(strSenciaInsert);
           prdStmt.setString(1, id);
        
           prdStmt.execute();
       }catch(Exception e)
       {
           System.out.println("Se presento error al crear el modificar a la tabla compra "+e);
           eliminar = false;
       }
       finally{
           try
           {
                conexionBaseDatos.close();
                con.cerrar();
           }
           catch(Exception errorException)
           {
               System.out.println("Se presento error al cerrar la conexion a la base de datos "+errorException);
           }
       }
       
       return eliminar;
   }
	
	
	
	

}
