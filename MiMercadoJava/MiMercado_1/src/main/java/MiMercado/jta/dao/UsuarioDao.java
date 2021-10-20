package MiMercado.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import MiMercado.jta.model.Conexion;

public class UsuarioDao {
	
static Conexion con = null;
	
	public String getUsuario(String parCorreo, String parClave){
		
       Conexion objeto_conexion=null;
       Connection conexion_bd = null;
       PreparedStatement prdStmt = null;
       
       String nombreCompleto="";
       
       try{
           
    	    objeto_conexion = new Conexion();
            conexion_bd = objeto_conexion.conectar();
            String sentenciaSql = 	"	SELECT   	CONCAT(rtrim(nombre) , ' ' , rtrim(apellido)) as nombres "
            						+ "	FROM 		mimercado.usuarios"
            						+ "	where  		correo =? and contraseña=?";
            
            
            prdStmt = conexion_bd.prepareStatement(sentenciaSql);
            
		    prdStmt.setString (1, parCorreo);
		    prdStmt.setString (2, parClave);
		    
            ResultSet resultado = prdStmt.executeQuery();
            while(resultado.next())
            {
                String nombreTemp = resultado.getString(1);
                nombreCompleto = nombreTemp ;
            }

           
       }catch(Exception e)
       {
           System.out.println("Se presento un ERROR al realizar la consulta a la BD "+e);
       }
       return nombreCompleto;
   }
	
	
	

}


