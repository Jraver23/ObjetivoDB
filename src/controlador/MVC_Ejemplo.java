package controlador;

import view.*;
import model.*;

public class MVC_Ejemplo {

    public static void main(String[] args) {
        // TODO code application logic here

    Student model = retriveStudentFromDatabase();
    StudentView view = new StudentView();
    StudentController controller = new StudentController(model, view);
    controller.updateView ();

    // Update model data controller.setStudentName ( "John");
    controller.updateView ();
}

private static Student retriveStudentFromDatabase() {
      Student student = new Student ();
      student.setName ( "Robert");
      student.setRollNo ( "10");
      return student;
   }
}
