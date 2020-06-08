package DB_Source;

import Person.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInfo {
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "azad", "azad");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static int save(Employees employees) {
        int st = 0;
        String sql = "INSERT INTO users ('fname','lname','salary','age','department','address','dateOfBirth','gender','education','experience','contractStart','contractEnd','nationaly','motherLanguage','otherLanguage') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        String sql2="INSERT INTO `users` ( `fname`, `lname`, `salary`, `age`, `department`, `address`, `dateOfBirth`, `gender`, `education`, `experience`, `contractStart`, `conrtactEnd`, `nationaly`, `motherLanguage`, `otherLanguage`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try (
                Connection connection = DBInfo.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql2);
        ) {


            pst.setString(1, employees.getFname());
            pst.setString(2, employees.getLname());
            pst.setFloat(3, employees.getSalary());
            pst.setInt(4, employees.getAge());
            pst.setString(5, employees.getDepartment());
            pst.setString(6, employees.getAddress());
            pst.setString(7, employees.getDateOfBirth());
            pst.setString(8, employees.getGender());
            pst.setString(9, employees.getEducation());
            pst.setString(10, employees.getExperience());
            pst.setString(11, employees.getContractStart());
            pst.setString(12, employees.getContractEnd());
            pst.setString(13, employees.getNationaly());
            pst.setString(14, employees.getMotherLanguage());
            pst.setString(15, employees.getOtherLanguage());

            st=pst.executeUpdate();

            System.out.println(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;

    }

    public static int update(Employees employees){
        int st=0;
        String sql="UPDATE  `users` SET  `fname`=?, `lname`=?, `salary`=?, `age`=?, `department`=?, `address`=?, `dateOfBirth`=?, `gender`=?, `education`=?, `experience`=?, `contractStart`=?, `conrtactEnd`=?, `nationaly`=?, `motherLanguage`=?, `otherLanguage`=? WHERE  `users`.`id`="+employees.getId()+";";
        System.out.println(sql);
        try (
                Connection connection=DBInfo.getConnection();
                PreparedStatement pst=connection.prepareStatement(sql);
                ){
            pst.setString(1, employees.getFname());
            pst.setString(2, employees.getLname());
            pst.setFloat(3, employees.getSalary());
            pst.setInt(4, employees.getAge());
            pst.setString(5, employees.getDepartment());
            pst.setString(6, employees.getAddress());
            pst.setString(7, employees.getDateOfBirth());
            pst.setString(8, employees.getGender());
            pst.setString(9, employees.getEducation());
            pst.setString(10, employees.getExperience());
            pst.setString(11, employees.getContractStart());
            pst.setString(12, employees.getContractEnd());
            pst.setString(13, employees.getNationaly());
            pst.setString(14, employees.getMotherLanguage());
            pst.setString(15, employees.getOtherLanguage());
            st=pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;

    }

    public static int delete(int id) {
        int st = 0;
        String sql = "DELETE from users WHERE id=?";
        try (
                Connection connection = DBInfo.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
        ) {
            pst.setInt(1, id);
            st = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;

    }

    public static Employees getEmployee(int id) {
        Employees emp = new Employees();
        String sql = "SELECT * from users WHERE id=?";

        try (
                Connection connection = DBInfo.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
        ) {
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {

                emp.setId(rst.getInt(1));
                emp.setFname(rst.getString(2));
                emp.setLname(rst.getString(3));
                emp.setSalary(rst.getFloat(4));
                emp.setAge(rst.getInt(5));
                emp.setDepartment(rst.getString(6));
                emp.setAddress(rst.getString(7));
                emp.setDateOfBirth(rst.getString(8));
                emp.setGender(rst.getString(9));
                emp.setEducation(rst.getString(10));
                emp.setExperience(rst.getString(11));
                emp.setContractStart(rst.getString(12));
                emp.setContractEnd(rst.getString(13));
                emp.setNationaly(rst.getString(14));
                emp.setMotherLanguage(rst.getString(15));
                emp.setOtherLanguage(rst.getString(16));
            }

            rst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public static List<Employees> getEmployee() {
        List<Employees> employeesList = new ArrayList<>();
        String sql = "SELECT * from 'users' WHERE 1";
        try (
                Connection connection = DBInfo.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
        ) {

            while (rst.next()){
                Employees emp=new Employees();
                emp.setId(rst.getInt(1));
                emp.setFname(rst.getString(2));
                emp.setLname(rst.getString(3));
                emp.setSalary(rst.getFloat(4));
                emp.setAge(rst.getInt(5));
                emp.setDepartment(rst.getString(6));
                emp.setAddress(rst.getString(7));
                emp.setDateOfBirth(rst.getString(8));
                emp.setGender(rst.getString(9));
                emp.setEducation(rst.getString(10));
                emp.setExperience(rst.getString(11));
                emp.setContractStart(rst.getString(12));
                emp.setContractEnd(rst.getString(13));
                emp.setNationaly(rst.getString(14));
                emp.setMotherLanguage(rst.getString(15));
                emp.setOtherLanguage(rst.getString(16));
                employeesList.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }
}
