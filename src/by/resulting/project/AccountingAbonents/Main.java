package by.resulting.project.AccountingAbonents;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import by.resulting.project.AccountingAbonents.entity.Abonent;
import by.resulting.project.AccountingAbonents.entity.Entity;
import by.resulting.project.AccountingAbonents.entity.Services;
import by.resulting.project.AccountingAbonents.service.AbonentService;
import by.resulting.project.AccountingAbonents.service.ServicesService;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {

//------------------------------- Testing Abonent DAO Implementation
/*
 * Getting Abonent by Id
 */
    	AbonentService abonentService = new AbonentService();
    	Abonent test =  abonentService.getAbonentById(1);
    	System.out.println(test.getFirstName() + " " + test.getSecondName() + " " + test.getLogin() + " " + test.getPassword() + " " + test.getEmail() + " " + test.getIsActive());
    	//Getting List Of Abonents
    	System.out.println();
    	List<Abonent> abonentList = abonentService.getAllAbonents();
    		for (Abonent element:abonentList){
    			System.out.println(element.getId() + " " + element.getFirstName() + " " + element.getSecondName() + " " + element.getLogin()
    					+ " " + element.getPassword() + " " + element.getRole() + " " + element.getEmail() + " " + element.getIsActive());
    		}
/*
 *Testing method unBlockAbonent() 
 */
    		abonentService.resetIsActive(4, "yes");
    		Abonent abonent = null;
    		System.out.println("\nИзменили значение isActive у абонента: ");
    		abonent = abonentService.getAbonentById(4);
    		System.out.println(abonent.getFirstName() + " " + abonent.getSecondName() + " на " + abonent.getIsActive());
    		
/*
 * Testing method getAbonentByEmail()
 */
    		Abonent byLogin = abonentService.getAbonentByLogin("admin");
    		System.out.println("\nПолучили абонента по логину: " + byLogin.getLogin());
    		System.out.println(byLogin.getFirstName() + " " + byLogin.getSecondName() + " " + byLogin.getPassword() + " " + byLogin.getEmail() + " " + byLogin.getIsActive());
/*
 * Testing method deleteAbonent()    		
 */
    		abonentService.deleteAbonent(11);
    		abonent = abonentService.getAbonentById(13);
    		System.out.println(abonent.getFirstName() + " " + abonent.getSecondName() + " " + abonent.getIsActive());
// It works!

/*
 * Testing method getAllServices()
 */
    		ServicesService servicesService = new ServicesService();
    		List<Services> servicesList = servicesService.getAllServices();
    		System.out.println();	
    		for(Services element: servicesList) {
    				System.out.println(element.getId() + " " + element.getServiceName() + " " + element.getServiceCost() + " " + element.getDescription());
    			}


//----------------------------Проверяем Courses DAO

//        CoursesService coursesService = new CoursesService();
//        coursesService.addCourses("Проверка добавления новых куров");
//        coursesService.deleteCourses(5);
//        coursesService.editCourses(7, "Проверка проверки редактирования записи");


/*        List<Courses> coursesList = coursesService.getCourses();
        for (Courses c : coursesList){
            System.out.println("c.getCourceName() + \" \" + c.getId() = " + c.getCourceName() + " " + c.getId());
        }
*/


/*       Person person = personService.getPerson(2);
        List <Courses> coursesList = coursesService.getOnePersonCourses(person);
        for (Courses c :coursesList){
            System.out.println("c.getCourceName() + \" \" + c.getId() = " + c.getCourceName() + " " + c.getId());
        }
*/



    }
}
