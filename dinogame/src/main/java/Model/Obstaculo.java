package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class Obstaculo extends ImageView{

    public Obstaculo() {
        Image image = new Image(Principal.class.getResource("/Asteroide.png").toString());
        this.setImage(image);
        this.setCache(true);
    }
}
