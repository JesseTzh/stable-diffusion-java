package com.jessetzh.parameters;

public class BasicParameter {

	private String apiUrl;

	private boolean proxyEnable;

	private String proxyHost;

	private int proxyPort;

	private boolean authEnable;

	private String user;

	private String password;

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public boolean isProxyEnable() {
		return proxyEnable;
	}

	public void setProxyEnable(boolean proxyEnable) {
		this.proxyEnable = proxyEnable;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public boolean isAuthEnable() {
		return authEnable;
	}

	public void setAuthEnable(boolean authEnable) {
		this.authEnable = authEnable;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BasicParameter(String url) {
		this.proxyEnable = false;
		this.authEnable = false;
		if (url != null) {
			if ( url.endsWith("/")) {
				url = url.substring(0, url.length() - 1);
			}
		}
		this.apiUrl = url;
	}

	public BasicParameter() {
	}
}
