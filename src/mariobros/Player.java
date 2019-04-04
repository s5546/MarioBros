//Spencer Finch
package mariobros;

import java.awt.Point;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Ipotane
 */
public class Player extends Actor {

    //needed for an arcing jump
    int jumpTimer = 0;

    boolean touchedGround = false;

    //jump method
    public Player(Point startingCoords) {
        this.color = Color.RED;
    }

    @Override
    public void moveActor(ArrayList<Character> direction) {
        for (char dir : direction) {

            switch (dir) {
                case 'a':
                    this.coords.x -= 2;
                    break;
                case 'd':
                    this.coords.x += 2;
                    break;
                case 'w':
                    if (this.coords.y >= 440) {
                        this.touchedGround = true;
                        this.jumpTimer = 0;
                    }
                    //QoL: make it a parobola arc instead of a V arc
                    //take the jump timer and move upwards by that amount
                    if (this.jumpTimer == 0 && this.touchedGround) {
                        this.jumpTimer = 50;
                        this.gravityAffected = false;
                        this.touchedGround = false;
                        ++this.coords.y;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public Player() {
        this.color = Color.RED;
    }
}
