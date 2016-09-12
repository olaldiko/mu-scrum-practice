import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Joseba on 12/09/2016.
 */
public class Jugador {
    SimpleIntegerProperty posX;

    public int getPosY() {
        return posY.get();
    }

    public SimpleIntegerProperty posYProperty() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY.set(posY);
    }

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
}
