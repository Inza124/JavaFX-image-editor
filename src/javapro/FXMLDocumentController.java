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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.Button; 
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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
    @FXML private CheckBox shadow;
    @FXML private CheckBox blur;
    @FXML private CheckBox light;
    @FXML private CheckBox innshadow;
    @FXML private Slider Sepia;
    @FXML private Slider Glow;
    @FXML private Slider Gauss;
    @FXML private Slider Bloom;
    @FXML private Slider MotionRadius;
    @FXML private Slider MotionAngle;
    @FXML private Slider bright;
    @FXML private Slider saturation;
    @FXML private Slider Hue;
    @FXML private Slider contrast;
    @FXML private StackPane root;
    @FXML private Button buttonLoadImage = new Button();
    @FXML private Button buttonSaveImage = new Button();
    @FXML private Button resetBtn = new Button();
    @FXML private Button infobtn = new Button();
    @FXML private ImageView myImageView = new ImageView();
    
    
    @FXML 
    private void buttonInfo(ActionEvent event){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setWidth(300);
        alert.setTitle("Okno Informacyje");
        alert.setHeaderText("Informacje dotyczące aplikacji");
        alert.setContentText("Jest to aplikacja przygotowana na zaliczenie przedmiotu Programowanie w Języku Java. Prowadzącym jest Dr.inż Jan Prokop. "
                + "Aplikacja służy do edycji zdjęć oraz grafik, Aplikacja została podzielona na dwa podobne do siebie moduły, które rożni stopień "
                + "zaawansowania udostępnianych przez nie funkcji. Autorem aplikacji jest Piotr Stachaczyński, nr albumu: 148899. Przykładowe zdjęcia "
                + "zostały podrane z internetu (z wyjątkiem loga programu)");
        alert.showAndWait().ifPresent(rs -> {
    if (rs == ButtonType.OK) {
        System.out.println("Pressed OK.");
    }
});
    }
    
    @FXML 
    private void reset() {
        contrast.setValue(0);
        Hue.setValue(0);
        saturation.setValue(0);
        bright.setValue(0);
        shadow.setSelected(false);
        blur.setSelected(false);
        Sepia.setValue(0);
        Glow.setValue(0);
        Gauss.setValue(0);
        Bloom.setValue(1);
        MotionAngle.setValue(0);
        MotionRadius.setValue(0);
        innshadow.setSelected(false);
        light.setSelected(false);
    }
    
    @FXML
    private void LoadImage(ActionEvent event) {
      //  System.out.println("You clicked me!");
        FileChooser fileChooser = new FileChooser();
             
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            File file = fileChooser.showOpenDialog(null);
                       
            try 
            {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                myImageView.setImage(image);
                reset();
                Images.setImage(myImageView);
            } catch (IOException ex) {

            }      
    }
    
    @FXML
    private void SaveImage(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Image");
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
                 
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
        Images.Light(light);
        Images.InnerShadow(innshadow);
        Images.BloomSliderEvent(Bloom);
        Images.GaussSliderEvent(Gauss);
        Images.GlowSliderEvent(Glow);
        Images.SepiaSliderEvent(Sepia);
        Images.Blur(blur);
        Images.MotionAngleEvent(MotionAngle);
        Images.MotionRadiusEvent(MotionRadius);
        Images.DropShadow(shadow);
        Images.BrightSliderEvent(bright);
        Images.SaturationSliderEvent(saturation);
        Images.HueSliderEvent(Hue);
        Images.ContrastSliderEvent(contrast);
        myImageView.fitWidthProperty().bind(root.widthProperty());
        myImageView.fitHeightProperty().bind(root.heightProperty());
   }   
    
    
}
