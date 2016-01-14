import java.sql.Connection;
import java.sql.DriverManager;
 
public class PatronSingletonDBCon {
 
    static Connection con; // atributo para guardar el objeto conexion.
    private static PatronSingletonDBCon INSTANCE = null;
 
    /**M�todo constructor que ejecuta el m�todo para conectar con la base de datos
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
     * @return retorna una instancia de la conexi�n a la base de datos
     */
    public static PatronSingletonDBCon getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
 
    /**M�todo para eliminar la instancia de la conexi�n
     *
     */
    public static void delInstance() {
        INSTANCE = null;
        closeConnection();
    }
 
    /**M�todo que crea la conexi�n a la base de datos
     *
     */
    public void performConnection() {
 
        String host = "127.0.0.1";//cambiar por tu host de la base de datos
        String user = "exampleUser";//cambiar por tu usuario de la base de datos
        String pass = "examplePass";//cambiar por tu contrase�a de la base de datos
        String dtbs = "exampleDB";//cambiar por tu nombre de la base de datos
 
        try { // preparamos la conexi�n
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            con = DriverManager.getConnection(newConnectionURL);
        } catch (Exception e) {
            System.out.println("Error al abrir la conexi�n.");
        }
    }
 
    /**M�todo para cerrar la conexi�n con la base de datos
     *
     */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexi�n.");
        }
    }
}
