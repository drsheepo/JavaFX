
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.FileInputStream;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;


public class Main extends Application {
    int numOfCookies = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("THEN");

        // Controls
        Label label1 = new Label("Welcome to Cookie Clicker");
        label1.setLineSpacing(10);
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        Text text1 = new Text("# of Cookies: "+ numOfCookies);
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 36));;

        FileInputStream input = new FileInputStream("src/cookie.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        ProgressBar progressBar = new ProgressBar(0);
        //radio
        RadioButton radioButton1 = new RadioButton("Mystery");
        RadioButton radioButton2 = new RadioButton("Mystery");
        RadioButton radioButton3 = new RadioButton("Mystery");
        RadioButton radioButton4 = new RadioButton("Mystery");

        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);
        radioButton1.setOnAction(actionEvent -> {
            numOfCookies = 0;
            text1.setText("# of Cookies: "+ numOfCookies);
        });

        radioButton2.setOnAction(actionEvent -> {
            numOfCookies = numOfCookies + 20;
            text1.setText("# of Cookies: "+ numOfCookies);
        });

        radioButton3.setOnAction(actionEvent -> {
            numOfCookies = numOfCookies -20;
        });

        radioButton4.setOnAction(actionEvent -> {
            numOfCookies = 30;
        });

        TextField textField = new TextField();
           textField.setOnAction(actionEvent -> {
               if (textField.getText().contentEquals("Cookies")) {
                   numOfCookies = 150;
                   text1.setText("# of Cookies: "+ numOfCookies);

               }

           });
        Button button1 = new Button("Click Me", imageView);
        //Button button1 = new Button("Click Me");
        button1.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        button1.setMinSize(200,200);
        button1.setOnAction(actionEvent -> {
            System.out.println("NOW");
            numOfCookies = numOfCookies + 1;
            text1.setText("# of Cookies: "+ numOfCookies);

            progressBar.setProgress(numOfCookies*.001);

        });
        //ProgressBar


        //Menu

        MenuItem menuItem1 = new MenuItem("Settings");
        MenuItem menuItem2 = new MenuItem("Instructions");
        MenuItem menuItem3 = new MenuItem("Coming Soon!");

        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);

        menuItem1.setOnAction(actionEvent -> {
            System.out.println("Not out yet.");
        });
        menuItem2.setOnAction(actionEvent -> {
            System.out.println("Click the cookie to play.");
        });
        menuItem1.setOnAction(actionEvent -> {
            System.out.println("Coming Soon.");
        });

        radioButton3.setOnAction(actionEvent -> {
            numOfCookies = numOfCookies -20;
            text1.setText("# of Cookies: "+ numOfCookies);
        });

        radioButton4.setOnAction(actionEvent -> {
            numOfCookies = 30;
            text1.setText("# of Cookies: "+ numOfCookies);
        });

        ChoiceBox choiceBox = new ChoiceBox();

        choiceBox.getItems().add("???");
        choiceBox.getItems().add("???");
        choiceBox.getItems().add("???");

        choiceBox.setOnAction((event) -> {
                    int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
                    if (selectedIndex == 0) {
                        numOfCookies = numOfCookies + 2;
                        text1.setText("# of Cookies: "+ numOfCookies);
                    }
                    if (selectedIndex == 1) {
                        numOfCookies = numOfCookies - 1;
                        text1.setText("# of Cookies: "+ numOfCookies);
                    }
                    if (selectedIndex == 2) {
                        numOfCookies = numOfCookies * 10;
                        text1.setText("# of Cookies: "+ numOfCookies);
                    }
                }
        );

        // VBox vBox = new VBox(progressBar);

        // Layouts
        HBox hbox1 = new HBox(button1, text1, radioButton1, radioButton2, radioButton3, radioButton4, textField, menuButton, choiceBox);
        VBox vbox2 = new VBox(label1, hbox1, progressBar);


        // Scenes
        Scene scene1 = new Scene(vbox2,800,300);

        // Stages
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.show();
      //  HBox hbox = new HBox(radioButton1, radioButton2, radioButton3, radioButton4);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

