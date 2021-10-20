package MiMercado.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MiMercado.jta.model.Conexion;
import MiMercado.jta.model.Producto;

public class cargaDao {
	
static Conexion con = null;
	
	public List<String> getProducto(){
		
       Conexion objeto_conexion=null;
       Connection conexion_bd = null;
       PreparedStatement prdStmt = null;
       
       List <String> producto= new ArrayList<String>();
       
       try{
           
    	    objeto_conexion = new Conexion();
            conexion_bd = objeto_conexion.conectar();
            String sentenciaSql = 	"	SELECT   	* "
            						+ "	FROM 		mimercado.seleccion";
            
            
            prdStmt = conexion_bd.prepareStatement(sentenciaSql);
            
		    
            ResultSet resultado = prdStmt.executeQuery();
            while(resultado.next())
            {
                String id = resultado.getString(1);
                producto.add(id) ;
                
                String nombre = resultado.getString(2);
                producto.add(nombre) ;
                
                String precio = resultado.getString(3);
                producto.add(precio) ;
                
                String inventario = resultado.getString(4);
                producto.add(inventario) ;
                
                String url = resultado.getString(5);
                producto.add(url) ;
                
                String seccion = resultado.getString(6);
                producto.add(seccion) ;
                
            }
            
           
           
       }catch(Exception e)
       {
           System.out.println("Se presento un ERROR al realizar la consulta a la BD "+e);
       }
       
       finally{
           try
           {
        	   conexion_bd.close();
                con.cerrar();
           }
           catch(Exception errorException)
           {
               System.out.println("Se presento error al cerrar la conexion a la base de datos "+errorException);
           }
       }
       return producto;
   }
	
	public boolean guardar_Producto(Producto producto)
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
           String strSenciaInsert = "INSERT into mimercado.compra  " +
                                    "(id, nombre, precio, cantidad, url, total) " +
                                    "values " +
                                    "(?, ?, ?, ?, ?, ?) ";
           
           prdStmt = conexionBaseDatos.prepareStatement(strSenciaInsert);
           prdStmt.setString(1, producto.getId());
           prdStmt.setString(2, producto.getNombre());
           prdStmt.setString(3, String.valueOf(producto.getPrecio()));
           prdStmt.setString(4, String.valueOf(producto.getCantidad()));
           prdStmt.setString(5, producto.getUrl());
           prdStmt.setString(6, String.valueOf(producto.getTotal()));
          
          
           
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

	
	public String getTotal(){
		
	       Conexion objeto_conexion=null;
	       Connection conexion_bd = null;
	       PreparedStatement prdStmt = null;
	       
	       String total= "";
	       
	       try{
	           
	    	    objeto_conexion = new Conexion();
	            conexion_bd = objeto_conexion.conectar();
	            String sentenciaSql = 	"	SELECT   	SUM(total) "
	            						+ "	FROM 		mimercado.compra";
	            
	            
	            prdStmt = conexion_bd.prepareStatement(sentenciaSql);
	            
			    
	            ResultSet resultado = prdStmt.executeQuery();
	            while(resultado.next())
	            {
	                String salida = resultado.getString(1);
	                total = salida;
	            }
	            
	           
	           
	       }catch(Exception e)
	       {
	           System.out.println("Se presento un ERROR al realizar la consulta a la BD "+e);
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
	       
	       
	       return total;
	   }
	
	
	
	

}
