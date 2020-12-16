import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoadDatabase {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path fileName = Path.of("SQLite_TworzenieTabel.txt");
        String InitialCreation = Files.readString(fileName);
        System.out.println(InitialCreation);

        try
        {
            Connection conMySql;
            String login = "bd2_projekt";
            String haslo = "BD2haslo";
            conMySql = DriverManager.getConnection("jdbc:mysql://pma.janowski.xyz:3306/bd2_projekt?allowMultiQueries=true",login,haslo);

            Statement st2;
            st2 = conMySql.createStatement();
            //st2.executeUpdate(InitialCreation);
            ResultSet rs = st2.executeQuery("SELECT * FROM alejka");

        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }
}
