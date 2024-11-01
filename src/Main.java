
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
        RadioButton radioButton1 = new RadioButton("Left");
        RadioButton radioButton2 = new RadioButton("Right");
        RadioButton radioButton3 = new RadioButton("Up");
        RadioButton radioButton4 = new RadioButton("Down");

        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);
        Button button1 = new Button("Click Me", imageView);
        //Button button1 = new Button("Click Me");
        button1.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        button1.setMinSize(200,200);
        button1.setOnAction(actionEvent -> {
            System.out.println("NOW");
            numOfCookies = numOfCookies + 1;
            text1.setText("# of Cookies: "+ numOfCookies);

            progressBar.setProgress(numOfCookies*.01);

        });
        //ProgressBar


       // VBox vBox = new VBox(progressBar);

        // Layouts
        HBox hbox1 = new HBox(button1, text1, radioButton1, radioButton2, radioButton3, radioButton4);
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

