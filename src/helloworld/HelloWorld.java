/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javafx.scene.image.*;

/**
 *
 * @author NickD
 */
public class HelloWorld extends Application {
    Image icon;
    int i;
    String[] GeraldoSays = {"Hi, I'm Geraldo. Click me!", "That felt nice!", "Geeze! At least buy a girl dinner first!", "Pull my hair!"};
    FileInputStream geraldo;
    File geraldofile = new File ("C:\\Users\\NickD\\Documents\\NetBeansProjects\\HelloWorld\\Geraldo.png");
    private static final String[] MEDIA_PATH  = {  "file:///C:/Users/NickD/Documents/NetBeansProjects/HelloWorld/Audio/SVU_dun_dun.mp3",
                                        "file:///C:/Users/NickD/Documents/NetBeansProjects/HelloWorld/Audio/Bike_Horn.mp3",
                                        "file:///C:/Users/NickD/Documents/NetBeansProjects/HelloWorld/Audio/Howard_Dean_Screaming.mp3",
                                        "file:///C:/Users/NickD/Documents/NetBeansProjects/HelloWorld/Audio/PicardEngage.mp3"};
    Media svu = new Media(MEDIA_PATH[i]);
    MediaPlayer player = new MediaPlayer(svu);
    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                if(i + 1 == GeraldoSays.length)
                {
                    i = 1;
                }
                else
                {
                 i++;   
                }
                Button greg = (Button)event.getSource();
                greg.setText(GeraldoSays[i]); 
                svu = new Media(MEDIA_PATH[i]);
                player = new MediaPlayer(svu);
                player.play();
                
                }
            };
      
    @Override
    public void start(Stage primaryStage) {
        try
        {
            geraldo = new FileInputStream(geraldofile);
        }
        catch (IOException e)
        {
            System.out.println("Shit be cray!");
        }
        
        javafx.scene.image.Image image = new javafx.scene.image.Image(geraldo);
        ImageView view = new ImageView();
        view.setImage(image);
                
        i = 0; 
        Button btn = new Button();
        btn.setText(GeraldoSays[i]);
        btn.setOnAction(handler);
        btn.setGraphic(view);
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 750, 450);
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        player.play();
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
