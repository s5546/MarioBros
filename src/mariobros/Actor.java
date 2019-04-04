//Spencer Finch
package mariobros;

import java.awt.Point;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Used by model: tracks entity's position and determines movement patterns Used by view: draws
 * sprite at current position with given color
 */
public abstract class Actor {

    //package-private needed so the coordinates can be updated elsewhere
    Point coords = new Point(320, 240);
    //package-private needed so the color can be read
    Color color;
    //
    boolean gravityAffected;
    Point size = new Point(20, 20); //represents height (y) and width (x) instead of an xy coordinate
    Rectangle rect = new Rectangle(this.coords.x, this.coords.y, this.size.x, this.size.y);
    
    public Actor(Point startingCoords) {
        this.coords = startingCoords;
        this.gravityAffected = true;
        
    }

    public Actor() {
        this.gravityAffected = true;
    }
    
    public void onCollision(Actor collider){
        System.out.println(this.getClass() + ", " + collider.getClass());
        if (this instanceof Platform){
            collider.gravityAffected = false;
            if (collider instanceof Player){
                ((Player)collider).touchedGround = true;
                ((Player) collider).jumpTimer = 0;
            }
        }
    }
    
    public Rectangle getRect(){
        return rect;
    }

    /**
     * moves an actor one pixel in many given directions. this provides multidirectional support.
     *
     * @param direction
     */
    public void moveActor(ArrayList<Character> direction) {
        for (char dir : direction) {
            switch (dir) {
                case 'a':
                    this.coords.x -= 1;
                    break;
                case 'd':
                    this.coords.x += 1;
                    break;
                case 'w':
                    this.coords.y -= 1;
                    break;
                case 's':
                    this.coords.y += 1;
                    break;
                default:
                    break;
            }
        }
    }
    public void moveActor(char direction) {
            switch (direction) {
                case 'a':
                    this.coords.x -= 1;
                    break;
                case 'd':
                    this.coords.x += 1;
                    break;
                case 'w':
                    this.coords.y -= 1;
                    break;
                case 's':
                    this.coords.y += 1;
                    break;
                default:
                    break;
        }
    }
    public void moveActor(char direction, int distance) {
            switch (direction) {
                case 'a':
                    this.coords.x -= distance;
                    break;
                case 'd':
                    this.coords.x += distance;
                    break;
                case 'w':
                    this.coords.y -= distance;
                    break;
                case 's':
                    this.coords.y += distance;
                    break;
                default:
                    break;
        }
    }
}
