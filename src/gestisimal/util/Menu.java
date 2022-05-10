package gestisimal.util;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Clase de menu para otros programas.
 * 
 * @author Jose Luis Perez Lara
 *
 */
public class Menu {

  private String cabecera;
  private String[] opciones;
  private Scanner sc = new Scanner(System.in);
  /**
   * Crea un menu con los paremetros asociados.
   * @param cabecera
   * @param opciones
   */
  public Menu(String cabecera, String ... opciones) {
    this.cabecera = cabecera;
    this.opciones = opciones;
  }
  /**
   * Establece la cabecera del menu
   * @param cabecera
   */
  public void setCabecera(String cabecera) {
    this.cabecera = cabecera;
  }
  /**
   * Lee la opcion que el usuario elige
   * @return option
   */
  private int leerOpciones() {
    System.out.print("Introduzca una opción (1-" + opciones.length + "): ");
    int option = sc.nextInt();
    sc.nextLine();  // sacamos el salto de línea del buffer de teclado
    System.out.println();
    return option;
  }
  /**
   * Elimina una opcion del menu
   * @param opcion
   */
  public void remove(int opcion) { 
    if (opcion < 1 || opcion > this.opciones.length) {
      throw new IndexOutOfBoundsException("Opción seleccionada fuera del rango de opciones");
    }
    String[] opciones = Arrays.copyOf(this.opciones, this.opciones.length-1);
    for (int i = opcion; i < this.opciones.length; i++) {
      opciones[i-1] = this.opciones[i];
    }
    this.opciones = opciones;
  }
  /**
   * Le permite al usuario elegir una opcion
   * @return option
   */
  public int choose() {
    while (true) {
      if (cabecera != null && !cabecera.isEmpty()) {
        System.out.println(cabecera);
        System.out.println("-".repeat(cabecera.length()));
      }
      int aux = 0;
      for (String opcionDelMenu: this.opciones) {
        System.out.println(++aux + ". " + opcionDelMenu);
      }
      System.out.println();
      int opcion = leerOpciones();
      if (opcion >= 1 && opcion <= this.opciones.length) {
        return opcion;
      }
      System.out.println("Opción incorrecta. Pulse Intro para continuar...");
      sc.nextLine();
      System.out.println();
    }
  }  
  /**
   * Añade una opcion al menu
   * @param opcion
   */
  public void add(String opcion) {
    String[] opcionesAux = Arrays.copyOf(this.opciones, this.opciones.length+1);
    opcionesAux[opcionesAux.length-1] = opcion;
    this.opciones = opcionesAux;
  }

  @Override
  public String toString() {
    return "Menu [title=" + cabecera + ", options=" + Arrays.toString(opciones) + "]";
  }
  /**
   * Devuelve la longitud de las opciones del menu
   * @return opciones.length
   */
  public int lastOption() {
    return opciones.length;
  }

}