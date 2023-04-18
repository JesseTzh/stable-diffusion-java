package com.jessetzh.request;

import com.google.gson.GsonBuilder;
import com.jessetzh.handler.BasicParameterHandler;
import com.jessetzh.parameters.Img2ImgParameter;
import com.jessetzh.res.SdResponses;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Img2Img {

	private static final String API_PATH = "/sdapi/v1/img2img";

	public static SdResponses generate(Img2ImgParameter parameter) throws IOException {
		HttpClientBuilder builder = HttpClients.custom();
		BasicParameterHandler.check(parameter.getBasicParameter(), builder);
		parameter.getBasicParameter().setApiUrl(parameter.getBasicParameter().getApiUrl() + API_PATH);
		HttpPost httpPost = new HttpPost(parameter.getBasicParameter().getApiUrl());
		StringEntity entity = new StringEntity(new GsonBuilder().create().toJson(parameter));
		return RequestExecutor.execute(builder, entity, httpPost);
	}

}
