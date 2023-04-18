package com.jessetzh.handler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SdResHandler {

    public static void process(CloseableHttpResponse response) throws IOException {
        if (response.getStatusLine().getStatusCode() != 200) {
            if (response.getStatusLine().getStatusCode() == 401) {
                throw new StableDiffusionException("Identity verification failed. Please check if your username and password are correct!");
            } else if (response.getStatusLine().getStatusCode() == 500) {
                throw new StableDiffusionException(EntityUtils.toString(response.getEntity()));
            } else {
                throw new StableDiffusionException("Interface call error, please check if the URL is correct.");
            }
        } else {
            if (response.getEntity() == null) {
                System.err.println("The result is empty!");
            }
        }
    }
}
