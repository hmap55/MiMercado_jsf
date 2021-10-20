package MiMercado.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MiMercado.jta.model.Conexion;

public class ProductoDao {
	
static Conexion con = null;
List <String> productoCompleto= new ArrayList<String>();
	
	public void getProducto(String parNombre){
		
       Conexion objeto_conexion=null;
       Connection conexion_bd = null;
       PreparedStatement prdStmt = null;
       
       
       
       try{
           
    	    objeto_conexion = new Conexion();
            conexion_bd = objeto_conexion.conectar();
            String sentenciaSql = 	"	SELECT   	* "
            						+ "	FROM 		mimercado.producto"
            						+ "	where  		nombre =?";
            
            
            prdStmt = conexion_bd.prepareStatement(sentenciaSql);
            
		    prdStmt.setString (1, parNombre);
		    //prdStmt.setString (2, parClave);
		    
            ResultSet resultado = prdStmt.executeQuery();
            while(resultado.next())
            {
                String id = resultado.getString(1);
                productoCompleto.add(id);
                
                String nombre = resultado.getString(2);
                productoCompleto.add(nombre);
                
                String precio = resultado.getString(3);
                productoCompleto.add(precio);
                
                String inventario = resultado.getString(4);
                productoCompleto.add(inventario);
                
                String url = resultado.getString(5);
                productoCompleto.add(url);
                
                String seccion = resultado.getString(6);
                productoCompleto.add(seccion);
                
                
            }
            System.out.println(productoCompleto.size());

           
       }catch(Exception e)
       {
           System.out.println("Se presento un ERROR al realizar la seleccion a la BD "+e);
       }
      
   }
	
	
	
	public void setProducto(){
		
	       Conexion objeto_conexion=null;
	       Connection conexion_bd = null;
	       PreparedStatement prdStmt = null;
	       
	       try{
	           
	    	    objeto_conexion = new Conexion();
	            conexion_bd = objeto_conexion.conectar();
	            String sentenciaSql = 	"	UPDATE seleccion SET"
	            						+ " id=?, nombre=?, precio=?, inventario=?, url=?, seccion=?";
	            
	            
	            prdStmt = conexion_bd.prepareStatement(sentenciaSql);
	            
			    prdStmt.setString (1, productoCompleto.get(0));
			    prdStmt.setString (2, productoCompleto.get(1));
			    prdStmt.setString (3, productoCompleto.get(2));
			    prdStmt.setString (4, productoCompleto.get(3));
			    prdStmt.setString (5, productoCompleto.get(4));
			    prdStmt.setString (6, productoCompleto.get(5));
			    
			    
			    prdStmt.executeUpdate();
	            

	           
	       }catch(Exception e)
	       {
	           System.out.println("Se presento un ERROR al realizar la actualizacion a la BD "+e);
	       }
	      
		
	

}
	
	public void limpiarTabla(){
		
	       Conexion objeto_conexion=null;
	       Connection conexion_bd = null;
	       PreparedStatement prdStmt = null;
	       
	       try{
	           
	    	    objeto_conexion = new Conexion();
	            conexion_bd = objeto_conexion.conectar();
	            String sentenciaSql = 	"truncate table compra";
	            						
	            
	            prdStmt = conexion_bd.prepareStatement(sentenciaSql);
			    
			    
			    prdStmt.execute();
	            

	           
	       }catch(Exception e)
	       {
	           System.out.println("Se presento un ERROR al limpiar la tabla compras "+e);
	       }
	      
		
	

}
	
	
}



