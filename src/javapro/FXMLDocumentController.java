/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapro;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.scene.image.Image;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.effect.Effect;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javax.imageio.ImageIO;


/**
 *
 * @author Piotr
 */
public class FXMLDocumentController implements Initializable {
    
    private ImageEdit Images = new ImageEdit();
    @FXML private TextField test;
    @FXML private Slider bright;
    @FXML private Slider saturation;
    @FXML private StackPane root;
    @FXML private Button buttonLoadImage = new Button();
    @FXML private Button buttonSaveImage = new Button();
    @FXML private ImageView myImageView = new ImageView();
    
    @FXML
    private void LoadImage(ActionEvent event) {
        System.out.println("You clicked me!");
        FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
                       
            try 
            {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                myImageView.setImage(image);
                Images.setImage(myImageView);
            } catch (IOException ex) {
               // smf goes wrong
            }      
    }
    
    @FXML
    private void SaveImage(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Image");
                 
                File file = fileChooser.showSaveDialog(null);
                if (file != null) {
                    try {
                        BufferedImage bImage = SwingFXUtils.fromFXImage(myImageView.snapshot(null, null), null);
                        ImageIO.write(bImage,"png", file);
                    } catch (IOException ex) {
                    }
                }
            }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Images.BrightSliderEvent(bright);
        Images.SaturationSliderEvent(saturation);
        myImageView.fitWidthProperty().bind(root.widthProperty());
        myImageView.fitHeightProperty().bind(root.heightProperty());
   }   
    
    
}
