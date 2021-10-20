package MiMercado.jta.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conexion = null;
	 //usando JDBC con mysql
	private static final String CONTROLADOR ="com.mysql.jdbc.Driver";
    //ubicacion y puerto de la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mimercado?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //usuario mysql
    private static final String JDBC_USER ="root";
    //password de ingreso
    private static final String JDBC_PASSWORD = "admin";
    //private static final String JDBC_PASSWORD = "root";
    
    static {
    	try {
    		Class.forName(CONTROLADOR);
    		
    	}catch(ClassNotFoundException e){
    		System.out.println("error al cargar el controlador");
			e.printStackTrace();
    	}
    }
    
    public Connection conectar() {
    	
    	try {
			
			conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			System.out.println("conexion ok");
		} catch (SQLException e) {
			System.out.println("error en la conexion");
			e.printStackTrace();
			
		}
    	
    	return conexion;
    	
    	
    }
    
    public static void cerrar() 
    {
            //metodo que cierra la conexion a la base de datos
            if (conexion != null) 
            {
                try
                {
                    conexion.close();
                }catch(Exception error)
                {
                    System.out.println("Se presento error al cerrar la conexion "+error);
                }   
	

}
    }
}
