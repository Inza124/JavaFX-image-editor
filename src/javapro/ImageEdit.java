/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapro;

import javafx.scene.CacheHint;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author Piotr
 */
public class ImageEdit {

    private ImageView Image;
    private ColorAdjust AdjustEffect = new ColorAdjust();
    private DropShadow shadow = new DropShadow(5, Color.CRIMSON);

    public ImageView getImage() {
        return Image;
    }

    public void setImage(ImageView myImage) {
        this.Image = myImage;
        AdjustEffect.setInput(shadow);
        Image.setEffect(AdjustEffect);
        Image.setCache(true);
        Image.setCacheHint(CacheHint.SPEED);
    }

    public void ImgEffects() {
 
    }

    public void DropShadow(CheckBox myCheckbox) {
        myCheckbox.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if (oldValue == false) {
                shadow.setHeight(40);
                shadow.setWidth(40);
            } else  { shadow.setWidth(0); shadow.setHeight(0); }
        }));
    }

    public void BrightSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setBrightness(newValue.doubleValue());
       

        });
    }

    public void SaturationSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setSaturation(newValue.doubleValue());
           

        });
    }

    public void HueSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setHue(newValue.doubleValue());
        

        });
    }

    public void ContrastSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setContrast(newValue.doubleValue());
       

        });
    }
}
