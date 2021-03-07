/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
    // Define numbers
    Sorting sorting = new Sorting();
    
    /* Below is for GUI data members */
    private int canvas_width = (int) (20 * sorting.getRadius()); // canvas width
    private int canvas_height = (int) (11 * sorting.getRadius()); // canvas height
    private Canvas canvas = new Canvas(canvas_width, canvas_height);
    private GraphicsContext gc = canvas.getGraphicsContext2D(); // define the
                                                                // canvas brush

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /* Define the layout */
        primaryStage.setTitle("Sorting Balls");
        Sorting sorting = new Sorting(canvas, gc);
        sorting.reshuffleBalls();
        sorting.showBalls(0, sorting.getNumbers());

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //R for reshuffle
                if (ke.getCode().equals(KeyCode.N)) {
                    sorting.reshuffleBalls();
                    //M for merge sort
                } else if (ke.getCode().equals(KeyCode.M)) {
	                sorting.mergeSort();
	                //R for radix sort
	            } else if (ke.getCode().equals(KeyCode.R)) {
                	sorting.radixSort();
                }
            }
        });

        Group root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
    
    public int getCanvas_height() {
		return canvas_height;
	}

	public void setCanvas_height(int canvas_height) {
		this.canvas_height = canvas_height;
	}

}
