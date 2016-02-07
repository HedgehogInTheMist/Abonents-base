package by.resulting.project.AccountingAbonents.Utils;


public class Constants {
//-----------------------------------JSP PAGES CONSTANTS
    public static final String PAGE_INDEX_PAGE = "index.jsp";
    public static final String PAGE_LIST_COURSES = "/pages/courselist.jsp";
    public static final String PAGE_DELETE_COURSES = "/pages/deletecourses.jsp";
    public static final String PAGE_EDIT_COURSES = "/pages/editcourses.jsp";
    public static final String PAGE_ADD_COURSES = "/pages/addcours.jsp";


    public static final String PAGE_LIST_PERSON = "/pages/personlist.jsp";
    public static final String PAGE_LIST_STUDENTS = "/pages/studentslist.jsp";
    public static final String PAGE_DELETE_PERSON = "/pages/deleteperson.jsp";
    public static final String PAGE_REGISTRATION = "pages/registration.jsp";




    //------------------------------------SQL REQUESTS PARAM CONSTANTS
    public static final String GET_PERSONS = "SELECT * FROM users";
    public static final String GET_ONE_PERSON = "SELECT * FROM users WHERE id = ?";
//    public static final String ADD_PERSON = "INSERT INTO person (first_name, last_name, role, PASSWORD, login) VALUES (?,?, ?, ?, ?);";
    public static final String ADD_PERSON = "INSERT INTO users (first_name, second_name, login, password, email) VALUES (?, ?, ?, ?, ?);";
    public static final String EDIT_PERSON = "UPDATE users SET first_name = ?, second_name = ?, login = ?, password = ?,  WHERE id = ?";
    public static final String DELETE_PERSON = "DELETE FROM users WHERE id = ?";

    public static final String ADD_TO_ARCHIVE = "INSERT INTO archive  (id_person, id_cources, mark) VALUES (?, ?, ?)";

    public static final String ADD_COURSE = "INSERT INTO cources (name_cources) VALUES (?)"; //Name of cource is reserved with "?" sign
    public static final String DELETE_COURSE = "DELETE FROM cources WHERE id_cources=?"; // Cources id

    public  static final String DELETE_FROM_ARCHIVE = "DELETE FROM cources_person WHERE  id_cources`=? AND id_person=? LIMIT 1";
    public static final String EDIT_COURSES = "UPDATE cources SET name_cources = ? WHERE id_cources = ?";
    public static final String GET_COURSES = "SELECT * FROM services";
    public static final String GET_ONE_PERSON_COURSES = "SELECT p.first_name, p.last_name, c.name_cources, p.role FROM cources c, cources_person cp, person p WHERE c.id_cources = cp.id_cources AND p.id_person = cp.id_person AND cp.id_person=?";


//-----------------------------------DB CONNECTION PARAM CONSTANTS

    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String dbURL = "jdbc:mysql://localhost:3306/call_office";
    public static final String USER = "root";
    public static final String PASSWORD = "1234";
}