//Spencer Finch
package mariobros;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Ipotane
 */
public class MarioModel {

    ArrayList<Actor> activeActors = new ArrayList<>(); //element 0 is player, element 1+ is AI

    /**
     * adds an actor to be tracked
     *
     * @param newActor
     */
    void setNewActor(Actor newActor) {
        activeActors.add(newActor);
    }

    void applyActorGravity() {
        for (Actor temp : activeActors) {
            if (temp instanceof Player && ((Player) temp).jumpTimer > 0){
                ((Player) temp).jumpTimer--;
                if (((Player) temp).jumpTimer == 0){
                    temp.gravityAffected = true;
                }
            }else if (temp.coords.y < 440 && temp.gravityAffected) {
                temp.coords.y += 2;
            }
        }
    }
    
    void checkActorCollsion(){
        //inefficent, but works
        for (Actor tempA : activeActors){
            for (Actor tempB : activeActors){
                if (tempA != tempB){
                    if (tempA.getRect().intersects(tempB.coords.x, tempB.coords.y, tempB.size.x, tempB.size.y)){
                        tempA.onCollision(tempB);
                    }else{
                        tempB.gravityAffected = true;
                    }
                }
            }
        }
    }

    public MarioModel() {
        Player player = new Player();
        Platform centerPlatform = new Platform(new Point(400, 400));
        setNewActor(player);
        setNewActor(centerPlatform);
    }

}
