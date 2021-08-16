//********************************************************************************************************
// FontSlider.Java
// 
// COMP 1231 Assignment 5: GUI (Question 2)
//
// JavaFX Application that displays a Text object and allows a user to control the font size of the Text
// object via a Slider.  The slider allows the font size to be set at any value between 0 to 100.  The
// font size of the Text object is bound to the slider, so it automatically updates whenever the slider
// is moved.
//********************************************************************************************************

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class FontSlider extends Application {
    private Text text; // the text that is displayed
    private Slider fontSizeSlider; // controls the font size

    // ---------------------------------------------------------------------------------------------------
    // Allows the user set the font size of the Text object via a slider.
    // ---------------------------------------------------------------------------------------------------
    public void start(Stage stage) {
        // create some text to display
        text = new Text("COMP 1231");

        // create a slider with values between 0 to 100, initial value 50
        fontSizeSlider = new Slider(0, 100, 50);

        // turn on Slider's tickmarks and tick labels
        fontSizeSlider.setShowTickMarks(true);
        fontSizeSlider.setShowTickLabels(true);

        // set the tick unit and tick counts
        fontSizeSlider.setMajorTickUnit(10);
        fontSizeSlider.setMinorTickCount(5);

        // set the Slider padding
        fontSizeSlider.setPadding(new Insets(0, 20, 20, 20));

        // bind the Text font size to the current slider value
        text.fontProperty().bind(Bindings.createObjectBinding(() -> new Font(fontSizeSlider.valueProperty().get()),
                fontSizeSlider.valueProperty()));

        // create a new BorderPane to display the above
        BorderPane pane = new BorderPane();

        // add the Slider and Text to the BorderPane
        pane.setBottom(fontSizeSlider);
        pane.setCenter(text);

        // create a scene with the above
        Scene scene = new Scene(pane, 600, 400);

        // add a title to the scene and display the scene
        stage.setTitle("Font Size Slider");
        stage.setScene(scene);
        stage.show();
    }

    // ---------------------------------------------------------------------------------------------------
    // Launches the JavaFX application.
    // ---------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }
}