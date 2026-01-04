import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
  int id;
  String department;
  String  name;
  double salary;


  // UserRepo 

  @Autowired
  UserRepo userRepo;



  public Employee(int id, String department,String name, doulbe salary ){
     this.id = id;
     this.department = department;
     this.name = name;
     this.salary = salary;
  }


  // sql syntax 

  // request details - request_id  - // order details - order_id - FK - request_id
  
    select order_id from request_details as rd
    left join order_details as od on rd.request_id = od.order_id
    where rd.order_id 


  public static void main(String[] args) {
          Employee mani = new Employee(1, "IT", "Mani", 10000);
          Employee kernal = new Employee(3, "HR", "Mani", 143000000);
          Employee venkat = new Employee(4, "Business", "Mani", 100430000);
          Employee john = new Employee(5, "HR", "Mani", 10003000);
          Employee james = new Employee(2, "IT", "Mani", 100000330);
          Employee vijay = new Employee(4, "Business", "Vijay", 10000);


          List<Employee> listOfEmployees = new ArrayList<>();
          listOfEmployees.add(mani);
          listOfEmployees.add(kernal);
          listOfEmployees.add(venkat);
          listOfEmployees.add(john);
          listOfEmployees.add(james);
          listOfEmployees.add(vijay);

          listOfEmployees.stream().max(null)




        }

}
