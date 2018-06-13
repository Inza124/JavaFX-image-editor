/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapro;

import javafx.scene.CacheHint;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Piotr
 */
public class ImageEdit {

    private ImageView Image;
    private ColorAdjust AdjustEffect = new ColorAdjust();

    public ImageView getImage() {
        return Image;
    }

    public void setImage(ImageView myImage) {
        this.Image = myImage;
    }

    public void BrightSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setBrightness(newValue.doubleValue());
            Image.setEffect(AdjustEffect);

        });
    }

    public void SaturationSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setSaturation(newValue.doubleValue());
            Image.setEffect(AdjustEffect);
            Image.setCache(true);
            Image.setCacheHint(CacheHint.SPEED);

        });
    }

    public void HueSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setHue(newValue.doubleValue());
            Image.setEffect(AdjustEffect);
            Image.setCache(true);
            Image.setCacheHint(CacheHint.SPEED);

        });
    }

    public void ContrastSliderEvent(Slider mySlider) {
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            AdjustEffect.setContrast(newValue.doubleValue());
            Image.setEffect(AdjustEffect);
            Image.setCache(true);
            Image.setCacheHint(CacheHint.SPEED);

        });
    }
}
