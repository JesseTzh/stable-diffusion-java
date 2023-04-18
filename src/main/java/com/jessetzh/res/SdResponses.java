package com.jessetzh.res;


import com.jessetzh.parameters.SdParameter;

public class SdResponses {

	private String[] images;

	private SdParameter parameters;

	private String info;

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public SdParameter getParameters() {
		return parameters;
	}

	public void setParameters(SdParameter parameters) {
		this.parameters = parameters;
	}

		public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SdResponses() {
	}

	public SdResponses(String[] images, SdParameter parameters, String info) {
		this.images = images;
		this.parameters = parameters;
		this.info = info;
	}
}
