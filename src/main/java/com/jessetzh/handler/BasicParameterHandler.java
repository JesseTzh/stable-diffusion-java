package com.jessetzh.handler;

import com.jessetzh.parameters.BasicParameter;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;

/**
 * Basic parameter validation.
 */
public class BasicParameterHandler {

    public static void check(BasicParameter basicParameter, HttpClientBuilder builder) {
        if (basicParameter.isAuthEnable()) {
            if (basicParameter.getUser() == null || basicParameter.getPassword() == null) {
                throw new StableDiffusionException("The username and password cannot be empty when authentication is enabled!");
            }
            // Identity verification information
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials(basicParameter.getUser(), basicParameter.getPassword());
            provider.setCredentials(AuthScope.ANY, credentials);
            // Set CredentialsProvider object to HttpClientBuilder
            builder.setDefaultCredentialsProvider(provider);
        }
        if (basicParameter.isProxyEnable()) {
            if (basicParameter.getProxyHost() == null || basicParameter.getProxyPort() == 0) {
                throw new StableDiffusionException("When using a proxy server, please specify the proxy server address and port.");
            }
            // Access an API using a proxy server.
            builder.setRoutePlanner(new DefaultProxyRoutePlanner(new HttpHost(basicParameter.getProxyHost(), basicParameter.getProxyPort())));
        }
        if (basicParameter.getApiUrl() == null) {
            throw new StableDiffusionException("API url can not be empty!");
        }
    }
}
