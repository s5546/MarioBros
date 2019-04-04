//Spencer Finch
package mariobros;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ipotane
 */
public class MarioControl {

    //main needs to access this for the gameloop
    ArrayList<Character> keysPressed = new ArrayList<>();

    public MarioControl(MarioModel model, MarioViewer view) {
        view.root.requestFocus();
        //get ready for the most ardious listener section ever 
        view.root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getText().length() == 1) {
                    if (!(keysPressed.contains(t.getText().charAt(0)))) {
                        keysPressed.add(t.getText().charAt(0));
                    }
                }
            }
        });
        view.root.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                //dumb workaround because java casts chars to ints otherwise
                //remove(int) is called instead of remove(object) smh
                if (t.getText().length() == 1) {
                    keysPressed.remove(Character.valueOf(t.getText().charAt(0)));
                }
            }
        });
        view.root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println(keysPressed); //debug
                view.root.requestFocus();

            }
        }
        );
        view.addChildren(model.activeActors);

    }

}
