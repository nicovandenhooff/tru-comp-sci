//********************************************************************************************************
// PizzaCost.Java
// 
// COMP 1231 Assignment 5: GUI (Question 1)
//
// JavaFX Application that allows a user to pick a set of pizza toppings using different CheckBox
// objects.  The base price for a plain pizza is $10.00 and each topping added to the pizza costs 
// $0.50.  When the user checks or unchecks a CheckBox the pizza price is updated automatically.
//********************************************************************************************************

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import java.text.NumberFormat;

public class PizzaCost extends Application {
    // to store the text representation of the current pizza cost
    private Text pizza;

    // constants for a plain pizza and per topping price
    private static final double PLAIN_COST = 10;
    private static final double TOPPING_COST = 0.5;

    // CheckBox objects for each topping
    private CheckBox salamiCheckBox, pepperoniCheckBox, sausageCheckBox;
    private CheckBox mushroomCheckBox, onionCheckBox, baconCheckBox;

    // to format the cost of a pizza nicely
    private NumberFormat fmt = NumberFormat.getCurrencyInstance();

    // ---------------------------------------------------------------------------------------------------
    // Allows the user to select the toppings they prefer on a pizza. Different
    // CheckBox objects
    // display the topping, and a Text object displays the total pizza cost.
    // ---------------------------------------------------------------------------------------------------
    public void start(Stage primaryStage) {
        // set the initial pizza cost to $10
        pizza = new Text("Pizza Cost: " + fmt.format(PLAIN_COST));
        pizza.setFont(new Font(20));

        // create checkbox for salami topping option and set event handler
        salamiCheckBox = new CheckBox("Salami");
        salamiCheckBox.setOnAction(this::processCheckBoxAction);

        // create checkbox for pepperoni topping option and set event handler
        pepperoniCheckBox = new CheckBox("Pepperoni");
        pepperoniCheckBox.setOnAction(this::processCheckBoxAction);

        // create checkbox for sausage topping option and set event handler
        sausageCheckBox = new CheckBox("Sausage");
        sausageCheckBox.setOnAction(this::processCheckBoxAction);

        // create checkbox for mushroom topping option and set event handler
        mushroomCheckBox = new CheckBox("Mushroom");
        mushroomCheckBox.setOnAction(this::processCheckBoxAction);

        // create checkbox for onion topping option and set event handler
        onionCheckBox = new CheckBox("Onion");
        onionCheckBox.setOnAction(this::processCheckBoxAction);

        // create checkbox for bacon topping option and set event handler
        baconCheckBox = new CheckBox("Bacon");
        baconCheckBox.setOnAction(this::processCheckBoxAction);

        // create GridPane to hold CheckBox and Text objects
        GridPane gridPane = new GridPane();

        // set GridPane spacing gaps, alignment and background color
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: cornsilk");

        // add each topping CheckBox to the GridPane
        gridPane.add(salamiCheckBox, 0, 0);
        gridPane.add(pepperoniCheckBox, 0, 1);
        gridPane.add(sausageCheckBox, 0, 2);
        gridPane.add(mushroomCheckBox, 1, 0);
        gridPane.add(onionCheckBox, 1, 1);
        gridPane.add(baconCheckBox, 1, 2);

        // add the pizza cost Text object to the GridPane
        // column and row span are included in this constructor to display Text object
        // nicely
        gridPane.add(pizza, 0, 3, 2, 1);

        // create a scene with the above
        Scene scene = new Scene(gridPane, 450, 175);

        // add a title to the scene and display the scene
        primaryStage.setTitle("Pizza Cost");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ---------------------------------------------------------------------------------------------------
    // Updates the price of a pizza when a CheckBox for a topping is selected
    // ---------------------------------------------------------------------------------------------------
    public void processCheckBoxAction(ActionEvent event) {
        // sets the cost of a pizza to the base cost
        double totalCost = PLAIN_COST;

        // calculates the # of toppings selected
        int toppings = (salamiCheckBox.isSelected() ? 1 : 0) + (pepperoniCheckBox.isSelected() ? 1 : 0)
                + (sausageCheckBox.isSelected() ? 1 : 0) + (mushroomCheckBox.isSelected() ? 1 : 0)
                + (onionCheckBox.isSelected() ? 1 : 0) + (baconCheckBox.isSelected() ? 1 : 0);

        // calculates the total price of the pizza with toppings
        totalCost += toppings * TOPPING_COST;

        // updates the pizza cost text displayed to the user
        pizza.setText("Pizza Cost: " + fmt.format(totalCost));
    }

    // ---------------------------------------------------------------------------------------------------
    // Launches the JavaFX application.
    // ---------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }
}