package com.jessetzh.request;

import com.google.gson.Gson;
import com.jessetzh.handler.SdResHandler;
import com.jessetzh.handler.StableDiffusionException;
import com.jessetzh.res.SdResponses;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStreamReader;

public class RequestExecutor {

	public static SdResponses execute(HttpClientBuilder builder, StringEntity entity, HttpPost httpPost) throws IOException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		SdResponses responses = new SdResponses();
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		try {
			httpClient = builder.build();
			long startTime = System.currentTimeMillis();
			response = httpClient.execute(httpPost);
			System.out.println("Request duration: " + (System.currentTimeMillis() - startTime) + "ms");
			// Process the request result.
			SdResHandler.process(response);
			Gson gson = new Gson();
			responses = gson.fromJson(new InputStreamReader(response.getEntity().getContent()), SdResponses.class);
		} catch (StableDiffusionException e) {
			System.err.println("Stable-Diffusion request error!");
			throw new StableDiffusionException(e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (response != null) {
				response.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return responses;
	}
}
