package tallermrrobot_ciclo3;

import tallermrrobot_ciclo3.Empleado;
import tallermrrobot_ciclo3.Empresa;
import tallermrrobot_ciclo3.MovimientoDinero;
import java.util.Scanner;

public class TallerMrRobot_Ciclo3 {

    public static void main(String[] args) {
        
        Empresa empresa1 = new Empresa("Exito", "Avenida 86", "1233456", "123456789");
       
        empresa1.setNombreEmpresa("MasXMenos");
        System.out.println(empresa1.getNombreEmpresa());
        empresa1.setDireccion("Carrera 33");
        System.out.println(empresa1.getDireccion());
        empresa1.setTelefono("7654321");
        System.out.println(empresa1.getTelefono());
        empresa1.setNit("987654321");
        System.out.println(empresa1.getNit());
        
        Empleado empleado1 = new Empleado("Mariana", "mariana@hotmail.com", "Exito", "Contadora");
       
        empleado1.setNombre("Maria");
        System.out.println(empleado1.getNombre());
        empleado1.setCorreo("marianac532@gmail.com");
        System.out.println(empleado1.getCorreo());
        empleado1.setEmpresa("MasXMenos");
        System.out.println(empleado1.getEmpresa());
        empleado1.setRol("Administradora");
        System.out.println(empleado1.getRol());
        
        MovimientoDinero movimiento1 = new MovimientoDinero (3200000, "Venta de verduras");
        
        movimiento1.setMonto(-1200000);
        System.out.println(movimiento1.getMonto());
        movimiento1.setConcepto("Compra de frutas");
        System.out.println(movimiento1.getConcepto());   
    }
}
