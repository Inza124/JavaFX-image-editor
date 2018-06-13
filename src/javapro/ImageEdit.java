/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapro;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Piotr
 */
public class ImageEdit {

    private ImageView Image;
    
    public ImageView getImage()
    {
        return Image;
    }
    
    public void setImage(ImageView myImage)
    {
        this.Image = myImage;
    }

    public void BrightSliderEvent(Slider mySlider, TextField textField) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            textField.setText(Double.toString(newValue.doubleValue()));

        });
    }
}
