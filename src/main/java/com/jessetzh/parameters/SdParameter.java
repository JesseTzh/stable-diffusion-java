package com.jessetzh.parameters;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class SdParameter {

	private transient BasicParameter basicParameter;

	private String prompt;

	@SerializedName("negative_prompt")
	private String negativePrompt;

	private int steps;

	@SerializedName("resize_mode")
	private int resizeMode;

	@SerializedName("cfg_scale")
	private int cfgScale;

	private int seed;

	private int width;

	private int height;

	@SerializedName("sampler_name")
	private String samplerName;

	public int getResizeMode() {
		return resizeMode;
	}

	public void setResizeMode(int resizeMode) {
		this.resizeMode = resizeMode;
	}

	public int getCfgScale() {
		return cfgScale;
	}

	public void setCfgScale(int cfgScale) {
		this.cfgScale = cfgScale;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getSamplerName() {
		return samplerName;
	}

	public void setSamplerName(String samplerName) {
		this.samplerName = samplerName;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getNegativePrompt() {
		return negativePrompt;
	}

	public void setNegativePrompt(String negativePrompt) {
		this.negativePrompt = negativePrompt;
	}

	public BasicParameter getBasicParameter() {
		return basicParameter;
	}

	public void setBasicParameter(BasicParameter basicParameter) {
		this.basicParameter = basicParameter;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public SdParameter() {

	}

	public SdParameter(String url) {
		this.basicParameter = new BasicParameter(url);
	}
}
