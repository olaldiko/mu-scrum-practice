import static java.lang.Math.cos;

/**
 * Created by Joseba on 12/09/2016.
 */
public class Bola {
    int x;
    int y;

    public Bola(){
        x=10;
        y=10;
    }

    public boolean MoverBola(int x1,int parametroSalto){
        int i=1;
        for(i=1;i<=10;i++){
            x = x1;
            y += y * cos(parametroSalto) / i;
        }
        if(i==10) {
            return true;
        }else return false;
    }
}
