/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elokuvaarkisto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jesse
 */
public class ElokuvaArkisto extends Application{
    public static void main(String[] args){
        launch(ElokuvaArkisto.class);
    }

    @Override
    public void start(Stage ikkuna) throws Exception {
        VBox box = new VBox();
        Button nappi1 = new Button("Listaus");
        BorderPane paneeli = new BorderPane();
        Button nappi2 = new Button("Laji haku");
        Button nappi3 = new Button("Haku");
        paneeli.setCenter(box);
        nappi1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                     public void handle(ActionEvent event) {
                         Listaa list = new Listaa();
                        try {
                            list.aloita();
                        } catch (Exception ex) {
                            Logger.getLogger(ElokuvaArkisto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        nappi2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                     public void handle(ActionEvent event) {
                         listausHaku haku = new listausHaku();
                        try {
                            haku.grafiikka();
                        } catch (Exception ex) {
                            Logger.getLogger(ElokuvaArkisto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        nappi3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                     public void handle(ActionEvent event) {
                         haku hakua = new haku();
                        try {
                            hakua.hakeeKayttoliittyma();
                        } catch (Exception ex) {
                            Logger.getLogger(ElokuvaArkisto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        box.getChildren().add(nappi1);
        box.getChildren().add(nappi2);
        box.getChildren().add(nappi3);
        box.setPadding(new Insets(10, 50, 50, 50));
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);
        Scene nakyma = new Scene(paneeli);
        ikkuna.setScene(nakyma);
        ikkuna.setHeight(250);
        ikkuna.setWidth(234);
        ikkuna.show();
    }
}
