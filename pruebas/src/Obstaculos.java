
import java.util.Random;

public class Obstaculos {
    int cantidad;
    Random rand;
    int contador;
    boolean posibleNuevo;

    public Obstaculos() {
      cantidad = 5;
      rand = new Random();
      contador = 0;
      posibleNuevo=false;
  }
  public boolean crearObstaculo() {
      if(posibleNuevo) {
          if (rand.nextBoolean() != false) {
              if (contador < cantidad) {
                  contador++;
                  posibleNuevo=false;
                  return true;
              }
          }
      }
      return false;
  }
  public void setObstaculo(){
      posibleNuevo=true;
  }
  public boolean quitarObstaculo() {
      if (contador < cantidad && contador != 0) {
          contador--;
          if (contador < 0) {
              contador = 0;
          }
          return true;
      }else{
          return false;
      }
  }
}
