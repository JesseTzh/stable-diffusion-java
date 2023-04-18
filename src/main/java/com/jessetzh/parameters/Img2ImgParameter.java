package com.jessetzh.parameters;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Img2ImgParameter extends SdParameter {

    String[] init_images;

    @SerializedName("denoising_strength")
    private BigDecimal denoisingStrength;

    public BigDecimal getDenoisingStrength() {
        return denoisingStrength;
    }

    public void setDenoisingStrength(BigDecimal denoisingStrength) {
        this.denoisingStrength = denoisingStrength;
    }

    public String[] getInit_images() {
        return init_images;
    }

    public void setInit_images(String[] init_images) {
        this.init_images = init_images;
    }

    public Img2ImgParameter() {
        super();
    }

    public Img2ImgParameter(String url) {
        super(url);
    }
}
