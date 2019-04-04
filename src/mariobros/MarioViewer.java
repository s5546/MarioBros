//Spencer Finch
package mariobros;

import java.awt.Point;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Ipotane
 */
public class MarioViewer {

    //package-private needed so listeners can be set and pane can be updated by the game loop
    Pane root = new Pane();
    private ArrayList<Node> actorNodes = new ArrayList<>();
    final Label CONTROLS = new Label("Use the W, A, S, and D keys to move Up, Left, Down, and Right respectively."
            + "\nClick the mouse for a console log of what keys are currently held down, ignoring any keys longer than one character."
            + "\n   (this may be limited to 3ish keys, depending on your keyboard- tested working on a corsair k65)"
            + "\nControls will be better explained in a future version.");

    public MarioViewer() {
    }

    /**
     * adds nodes to the javafx pane for viewing. This doesn't control the
     * logical position! It only controls the display of the nodes.
     *
     * @param actors
     */
    void addChildren(ArrayList<Actor> actors) {
        int childCount = 0;
        for (Actor temp : actors) {
            Rectangle rect = temp.getRect();
            actorNodes.add(rect);
            root.getChildren().add(rect);
            rect.setFill(temp.color);
            ++childCount;
        }
        System.out.println("DEBUG: " + childCount + " children added!");
    }

    /**
     * moves the position of a node. purely visual- coordinate tracking should
     * be supplied by the model class
     *
     * @param index
     * @param newCoords
     */
    void moveChildren(int index, Point newCoords) {
        Node nodeToMove = root.getChildren().get(index);
        nodeToMove.relocate(newCoords.x, newCoords.y);
    }
}
