package tallermrrobot_ciclo3;
import tallermrrobot_ciclo3.Empleado;
import java.util.Scanner;


public class TallerMrRobot_Ciclo3 {

   
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado();
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Ingresa el nombre del empleado");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el correo del empleado");
        String correo = sc.nextLine();
        System.out.println("Ingresa la empresa del empleado");
        String empresa = sc.nextLine();
        System.out.println("Ingresa el rol del empleado");
        String rol = sc.nextLine();
     
        System.out.println(empleado1.getNombre());
        System.out.println(empleado1.getCorreo());
        System.out.println(empleado1.getEmpresa());
        System.out.println(empleado1.getRol());
        
        
        
    }

}
