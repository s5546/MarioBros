//Spencer Finch
package mariobros;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Meltdown
 */
public class MarioMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("DEBUG: JavaFX init!");
        System.out.println("DEBUG: CREATING MODEL");
        MarioModel model = new MarioModel();
        System.out.println("DEBUG: CREATING VIEWER");
        MarioViewer view = new MarioViewer();
        System.out.println("DEBUG: CREATING CONTROLLER");
        MarioControl control = new MarioControl(model, view);

        Scene scene = new Scene(view.root, 640, 480);
        view.root.getChildren().add(view.CONTROLS);
        primaryStage.setTitle("Mario Bros");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.requestFocus();

        //game loop- needed to repeatedly update
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                //checks all actors for collision. may want to limit, as this could be costly
                model.checkActorCollsion();
                //responds to player input, and mvoes player's xy coord in model
                model.activeActors.get(0).moveActor(control.keysPressed);
                if (((Player) model.activeActors.get(0)).jumpTimer > 0) {
                    ((Player) model.activeActors.get(0)).moveActor('w', 2);
                }
                //moves an actor down until they land on a surface (or the bottom of the screen)
                model.applyActorGravity();

                //moves player's node in view
                view.moveChildren(0, model.activeActors.get(0).coords);
                //sleeps for 10ms, then updates again. This results in a 100hz tickrate,
                //  higher than many competitive games. Not that we really need it...
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("thread interrupted!");
                    //admittedly I don't fully understand why, but from what documentation I can find
                    //  this is best practice so that other loops dont go out of sync?
                    //  in this program it should never execute, but its better to do this than
                    //  it is to do nothing
                    Thread.currentThread().interrupt();
                }
            }
        }.start();

        System.out.println("DEBUG: JavaFX init ended!");
    }

}
