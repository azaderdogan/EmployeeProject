package DB_Source;

import Person.Admins;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminsDB {
    static Connection con=null;

    public static Connection getCon() {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/employee","azad","azad");
            System.out.println("connected");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static List<Admins> getAdmins(){

        List<Admins> list=new ArrayList<>();
        Connection connection=AdminsDB.getCon();
        String sql="SELECT * FROM `admin` WHERE 1";
        try (
                PreparedStatement pst=connection.prepareStatement(sql);
                ResultSet rst=pst.executeQuery();
                ){

            while (rst.next()){
                Admins admins=new Admins();
                admins.setId(rst.getInt(1));
                admins.setUsername(rst.getString(2));
                admins.setPassword(rst.getString(3));
                list.add(admins);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
