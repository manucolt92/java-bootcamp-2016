import java.sql.Connection;
import java.sql.DriverManager;
 
public class PatronSingletonDBCon {
 
    static Connection con; // atributo para guardar el objeto conexion.
    private static PatronSingletonDBCon INSTANCE = null;
 
    /**Método constructor que ejecuta el método para conectar con la base de datos
     *
     */
    private PatronSingletonDBCon() {
        performConnection();
    }
 
    /**Crea una instancia de la base de datos en caso de no estar creada.
     *
     */
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PatronSingletonDBCon();
        }
    }
 
    /**Metodo para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return retorna una instancia de la conexión a la base de datos
     */
    public static PatronSingletonDBCon getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
 
    /**Método para eliminar la instancia de la conexión
     *
     */
    public static void delInstance() {
        INSTANCE = null;
        closeConnection();
    }
 
    /**Método que crea la conexión a la base de datos
     *
     */
    public void performConnection() {
 
        String host = "127.0.0.1";//cambiar por tu host de la base de datos
        String user = "exampleUser";//cambiar por tu usuario de la base de datos
        String pass = "examplePass";//cambiar por tu contraseña de la base de datos
        String dtbs = "exampleDB";//cambiar por tu nombre de la base de datos
 
        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            con = DriverManager.getConnection(newConnectionURL);
        } catch (Exception e) {
            System.out.println("Error al abrir la conexión.");
        }
    }
 
    /**Método para cerrar la conexión con la base de datos
     *
     */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
}
