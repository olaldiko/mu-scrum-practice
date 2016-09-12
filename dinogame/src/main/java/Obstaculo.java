import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class Obstaculo {

    SimpleIntegerProperty posX;
    SimpleIntegerProperty posY;


    public int getPosX() {
        return posX.get();
    }

    public SimpleIntegerProperty posXProperty() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX.set(posX);
    }

    public int getPosY() {
        return posY.get();
    }

    public SimpleIntegerProperty posYProperty() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY.set(posY);
    }





}
