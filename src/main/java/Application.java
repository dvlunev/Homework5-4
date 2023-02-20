import hw54.dao.EmployeeDao;
import hw54.dao.impl.EmployeeDaoImpl;
import hw54.model.City;
import hw54.model.Employee;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {
        // Задание 1
        System.out.println("Задание 1");
        final String user = "postgres";
        final String password = "311090222";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        int cityNumber = 0;

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")
        ) {

            statement1.setInt(1, 1);

            final ResultSet resultSet = statement1.executeQuery();

            while (resultSet.next()) {

                String firstName = "First name: " + resultSet.getString("first_name");
                String lastName = "Last name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                int age = resultSet.getInt(5);
                cityNumber = resultSet.getInt(6);

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println("Age: " + age);
            }
        }

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM city WHERE city_id = (?)")
        ) {

            statement2.setInt(1, cityNumber);

            final ResultSet resultSet = statement2.executeQuery();

            while (resultSet.next()) {

                String city = "City: " + resultSet.getString("city_name");

                System.out.println(city);
            }
        }
        System.out.println();

        //Задание 2
        System.out.println("Задание 2");
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        City city = new City(1, "Saint-Petersburg");

        Employee dLunev = new Employee("Dmitrii", "Lunev", "male",32);

        employeeDao.createEmployee(dLunev);

        System.out.println(employeeDao.getEmployeeById(23));

        System.out.println();

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

        employeeDao.updateEmployeeAgeById(new Employee(24,"Dmitrii", "Lunev", "male",31, city));

        employeeDao.deleteEmployeeById(24);
    }
}
