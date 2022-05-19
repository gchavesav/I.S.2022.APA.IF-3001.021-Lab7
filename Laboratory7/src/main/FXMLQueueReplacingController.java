/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import com.sun.beans.WeakCache;
import domain.Climate;
import domain.LinkedQueue;
import domain.Place;
import domain.Queue;
import domain.QueueException;
import domain.Weather;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class FXMLQueueReplacingController implements Initializable {

    private Queue queue;
    @FXML
    private BorderPane bp;
    @FXML
    private TableView<List<String>> queueTableView;
    @FXML
    private TableColumn<List<String>, String> placeTableColumn;
    @FXML
    private TableColumn<List<String>, String> weatherTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.queue = loadQueue();
            
        } catch (QueueException ex) {
            Logger.getLogger(FXMLQueueReplacingController.class.getName()).log(Level.SEVERE, null, ex);
        }
       placeTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });
       
       weatherTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });
        
       this.queueTableView.setEditable(true);
       weatherTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       
       if(this.queue!=null && !this.queue.isEmpty()){
           this.queueTableView.setItems(getData());
       }
    }    

    private Queue loadQueue() throws QueueException {
        LinkedQueue q = new LinkedQueue();
        q.enQueue(new Climate(new Place("San Jose"), new Weather("rainy")));
        q.enQueue(new Climate(new Place("Cartago"), new Weather("cloudy")));
        q.enQueue(new Climate(new Place("Guanacaste"), new Weather("sunny")));
        return q;
    }

   private ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if(this.queue!=null&&!this.queue.isEmpty()){
            try{
                LinkedQueue aux = new LinkedQueue();
                while(!queue.isEmpty()){
                    Climate c = (Climate) queue.front();
                    List<String> arrayList = new ArrayList<>();
                    
                    arrayList.add(c.getPlace().getName());
                    arrayList.add(c.getWeather().getWeather());
                
                    //Agrego el arrayList a ObservableList<List<String>> data
                    data.add(arrayList);
                    aux.enQueue(queue.deQueue());
                }
                //al final dejamos la cola en su estado original
                while(!aux.isEmpty()){
                    queue.enQueue(aux.deQueue());
                }
            }catch(QueueException ex){
                System.out.println(ex.getMessage());
            }
        }
        return data;
    }

    @FXML
    private void weatherOnEditCommit(TableColumn.CellEditEvent<List<String>, String> event) {
        List<String> arrayList = queueTableView.getSelectionModel().getSelectedItem();
        String place = event.getRowValue().get(0);
        
    }
    
}
