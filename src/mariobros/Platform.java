//Spencer Finch
package mariobros;

import java.awt.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Meltdown
 */
public class Platform extends Actor {

    //default is 4 tall 60 wide
    public Platform() {
        this.color = color.GREY;
        this.size = new Point(240, 8);
        this.rect = new Rectangle(this.coords.x, this.coords.y, this.size.x, this.size.y);
    }

    public Platform(int height, int width) {
        this.color = color.GREY;
        this.size = new Point(height, width);
    }

    public Platform(int height, int width, Point startingCoords) {
        this.color = color.GREY;
        this.size = new Point(height, width);
        this.coords = startingCoords;
    }

    public Platform(Point startingCoords) {
        this.color = color.GREY;
        this.coords = startingCoords;
        this.size = new Point(240, 8);
        this.rect = new Rectangle(this.coords.x, this.coords.y, this.size.x, this.size.y);
    }
}
