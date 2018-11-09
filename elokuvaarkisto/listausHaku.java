/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elokuvaarkisto;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jesse
 */
public class listausHaku {
    public void grafiikka(){
        Stage ikkuna = new Stage();
        BorderPane paneeli = new BorderPane();
        Arkisto arkisto = new Arkisto();
        arkisto.lataa();
        ComboBox valinta = new ComboBox();
        paneeli.setTop(valinta);
        ObservableList<String> data = FXCollections.observableArrayList();

        ListView<String> listView = new ListView<String>(data);
        listView.setPrefSize(200, 250);
        StackPane root = new StackPane();
        root.getChildren().add(listView);
        paneeli.setCenter(root);
        valinta.getItems().addAll(arkisto.eriLajit());
        valinta.setPromptText("Eri Lajit");
        valinta.setEditable(true);        
        valinta.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                ArrayList<String> lista = arkisto.elokuvatLajinMukaan(t1);
                data.clear();
                for(int k=0;k<lista.size();k++){
                    data.add(lista.get(k));
                }
                listView.setItems(data);
        }    
    });
        
        Scene nakymaa = new Scene(paneeli);
        ikkuna.setScene(nakymaa);
        double korkeus = ikkuna.getHeight();
        double leveys = ikkuna.getWidth();
        ikkuna.show();
        listView.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String> ov, String old_val, 
            String new_val) -> {
                BorderPane box = new BorderPane();
                Button nappi = new Button("Takaisin");
                box.setTop(nappi);
                nappi.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                     public void handle(ActionEvent event) {
                         ikkuna.setScene(nakymaa);
                         ikkuna.setHeight(korkeus);
                         ikkuna.setWidth(leveys);
                    }
                });
                BorderPane asettelu = new BorderPane();
                box.setCenter(asettelu);
                BorderPane keski = new BorderPane();
                Elokuva elokuva = arkisto.getElokuva(new_val);
                BorderPane yla = new BorderPane();
                yla.setPadding(new Insets(10, 20, 10, 20));
                keski.setPadding(new Insets(10, 20, 10, 20));
                
                yla.setLeft(new Label(elokuva.getTitle()));
                yla.setRight(new Label("Kesto: "+elokuva.getKesto() + " min"));
              //  HBox apu = new HBox();
              //  apu.getChildren().add(new Label(elokuva.getPaikka()));
              //  apu.getChildren().add(new Label(elokuva.getLaji()));
              //  apu.setPadding(new Insets(15, 12, 15, 12));
               // apu.setSpacing(10);
                yla.setCenter(new Label("Paikka: " +elokuva.getPaikka() + "    Laji: " + elokuva.getLaji()));
                
                asettelu.setTop(yla);
                asettelu.setCenter(keski);
                if(elokuva.getKuva().contains("null")){
                    keski.setLeft(new Label("Ei kuvaa"));
                } else{
                    Image image = new Image(elokuva.getKuva());
                    ImageView iv2 = new ImageView();
                    iv2.setImage(image);
                     iv2.setFitWidth(100);
                    iv2.setPreserveRatio(true);
                    iv2.setSmooth(true);
                     iv2.setCache(true);
                     keski.setLeft(iv2);
                }
                ScrollPane roott = new ScrollPane();
        
                keski.setCenter(roott);
                Scene nakyma = new Scene(box);
                ikkuna.setScene(nakyma);
                ikkuna.setHeight(500);
                ikkuna.setWidth(500);
                Text text = new Text(elokuva.getKuvaus());
        text.wrappingWidthProperty().bind(nakyma.widthProperty());
        roott.setFitToWidth(true);
        
        roott.setContent(text);
    });
    }
}
