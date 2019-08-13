package com.guoxuezhishi.utils;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/4
 */
public class SimpleHttpsClient {
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);
    private Map<Integer, Integer> registerPortList = new HashMap();

    public SimpleHttpsClient() {
        org.apache.commons.httpclient.protocol.Protocol.registerProtocol("https", new org.apache.commons.httpclient.protocol.Protocol("https", new SimpleHttpsClient.SimpleHttpsSocketFactory(), 443));
        this.registerPort(443);
    }

    public HttpSendResult postRequest(String url, Map<String, String> params, int timeout, String characterSet) {
        if (characterSet == null || "".equals(characterSet)) {
            characterSet = "UTF-8";
        }

        HttpSendResult result = new HttpSendResult();
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Connection", "close");
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + characterSet);
        NameValuePair[] data = this.createNameValuePair(params);
        logger.info("data: " + data.toString());
        postMethod.setRequestBody(data);
        Integer port = this.getPort(url);
        if (this.isRegisterPort(port)) {
            org.apache.commons.httpclient.protocol.Protocol client = new org.apache.commons.httpclient.protocol.Protocol("https", new SimpleHttpsClient.SimpleHttpsSocketFactory(), port);
            org.apache.commons.httpclient.protocol.Protocol.registerProtocol("https ", client);
            this.registerPort(port);
        }

        HttpClient client = new HttpClient();
        client.getParams().setSoTimeout(timeout);

        try {
            int ex = client.executeMethod(postMethod);
            InputStream is = postMethod.getResponseBodyAsStream();
            String responseBody = IOUtils.toString(is, characterSet);
            result.setStatus(ex);
            result.setResponseBody(responseBody);
        } catch (Exception var16) {
            var16.printStackTrace();
        } finally {
            postMethod.releaseConnection();
        }

        return result;
    }

    public HttpSendResult jsonPostRequest(String url, String params, int timeout, String characterSet) {
        if (characterSet == null || "".equals(characterSet)) {
            characterSet = "UTF-8";
        }

        HttpSendResult result = new HttpSendResult();
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Connection", "close");
        postMethod.addRequestHeader("Content-Type", "application/json;charset=" + characterSet);
        postMethod.setRequestBody(params);
        Integer port = this.getPort(url);
        if (this.isRegisterPort(port)) {
            org.apache.commons.httpclient.protocol.Protocol client = new org.apache.commons.httpclient.protocol.Protocol("https", new SimpleHttpsClient.SimpleHttpsSocketFactory(), port);
            org.apache.commons.httpclient.protocol.Protocol.registerProtocol("https ", client);
            this.registerPort(port);
        }

        HttpClient client = new HttpClient();
        client.getParams().setSoTimeout(timeout);

        try {
            int ex = client.executeMethod(postMethod);
            InputStream is = postMethod.getResponseBodyAsStream();
            String responseBody = IOUtils.toString(is, characterSet);
            result.setStatus(ex);
            result.setResponseBody(responseBody);
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            postMethod.releaseConnection();
        }

        return result;
    }

    public HttpSendResult postRequest(String url, Map<String, String> params, int timeout) {
        return this.postRequest(url, params, timeout, "UTF-8");
    }

    public HttpSendResult getRequest(String url, Map<String, String> params, int timeout, String characterSet) {
        if (characterSet == null || "".equals(characterSet)) {
            characterSet = "UTF-8";
        }

        HttpSendResult result = new HttpSendResult();
        Integer port = this.getPort(url);
        if (this.isRegisterPort(port)) {
            org.apache.commons.httpclient.protocol.Protocol httpclient = new org.apache.commons.httpclient.protocol.Protocol("https", new SimpleHttpsClient.SimpleHttpsSocketFactory(), port);
            org.apache.commons.httpclient.protocol.Protocol.registerProtocol("https ", httpclient);
            this.registerPort(port);
        }

        url = this.appendUrlParam(url, params);
        HttpClient httpclient = new HttpClient();
        GetMethod httpget = new GetMethod(url);

        try {
            int ex = httpclient.executeMethod(httpget);
            InputStream is = httpget.getResponseBodyAsStream();
            String responseBody = IOUtils.toString(is, characterSet);
            result.setStatus(ex);
            result.setResponseBody(responseBody);
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }

        return result;
    }

    public HttpSendResult jsonGetRequest(String url, Map<String, String> params, int timeout, String characterSet) {
        if (characterSet == null || "".equals(characterSet)) {
            characterSet = "UTF-8";
        }

        HttpSendResult result = new HttpSendResult();
        Integer port = this.getPort(url);
        if (this.isRegisterPort(port)) {
            org.apache.commons.httpclient.protocol.Protocol httpclient = new org.apache.commons.httpclient.protocol.Protocol("https", new SimpleHttpsClient.SimpleHttpsSocketFactory(), port);
            Protocol.registerProtocol("https ", httpclient);
            this.registerPort(port);
        }

        url = this.appendUrlParam(url, params);
        HttpClient httpclient = new HttpClient();
        GetMethod httpget = new GetMethod(url);

        try {
            int ex = httpclient.executeMethod(httpget);
            InputStream is = httpget.getResponseBodyAsStream();
            String responseBody = IOUtils.toString(is, characterSet);
            result.setStatus(ex);
            result.setResponseBody(responseBody);
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }

        return result;
    }

    public HttpSendResult getRequest(String url, Map<String, String> params, int timeout) {
        return this.getRequest(url, params, timeout, "UTF-8");
    }

    private boolean isRegisterPort(Integer port) {
        return this.registerPortList.get(port) != null;
    }

    private void registerPort(Integer port) {
        this.registerPortList.put(port, port);
    }

    private Integer getPort(String uri) {
        try {
            URL e = new URL(uri);
            int port = e.getPort();
            if (port == -1) {
                if (uri.indexOf("https://") == 0) {
                    port = 443;
                } else {
                    port = 80;
                }
            }

            return port;
        } catch (MalformedURLException var4) {
            throw new RuntimeException(var4);
        }
    }

    private NameValuePair[] createNameValuePair(Map<String, String> params) {
        NameValuePair[] pairs = new NameValuePair[params.size()];
        int index = 0;

        String key;
        for (Iterator var5 = params.keySet().iterator(); var5.hasNext(); pairs[index++] = new NameValuePair(key, (String) params.get(key))) {
            key = (String) var5.next();
        }

        return pairs;
    }

    private String appendUrlParam(String url, Map<String, String> params) {
        String result = "";
        if (url.contains("?") && url.contains("=")) {
            result = url + "&";
        } else {
            result = url + "?";
        }

        String key;
        for (Iterator var5 = params.keySet().iterator(); var5.hasNext(); result = result + key + "=" + (String) params.get(key) + "&") {
            key = (String) var5.next();
        }

        if (result.charAt(result.length() - 1) == '&') {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    private class SimpleHttpsSocketFactory implements ProtocolSocketFactory {
        private SSLContext sslcontext = null;

        public SimpleHttpsSocketFactory() {
        }

        private SSLContext createEasySSLContext() {
            try {
                X509TrustManager e = new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                };
                TrustManager[] trustMgrs = new TrustManager[]{e};
                SSLContext context = SSLContext.getInstance("SSL");
                context.init((KeyManager[]) null, trustMgrs, (SecureRandom) null);
                return context;
            } catch (Exception var4) {
                var4.printStackTrace();
                throw new HttpClientError(var4.toString());
            }
        }

        private SSLContext getSSLContext() {
            if (this.sslcontext == null) {
                this.sslcontext = this.createEasySSLContext();
            }

            return this.sslcontext;
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException, UnknownHostException {
            return this.getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localAddress, int localPort, HttpConnectionParams params) throws IOException, UnknownHostException, ConnectTimeoutException {
            if (params == null) {
                throw new IllegalArgumentException("Parameters may not be null");
            } else {
                int timeout = params.getConnectionTimeout();
                SSLSocketFactory socketfactory = this.getSSLContext().getSocketFactory();
                if (timeout == 0) {
                    return socketfactory.createSocket(host, port, localAddress, localPort);
                } else {
                    Socket socket = socketfactory.createSocket();
                    InetSocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
                    InetSocketAddress remoteaddr = new InetSocketAddress(host, port);
                    socket.bind(localaddr);
                    socket.connect(remoteaddr, timeout);
                    return socket;
                }
            }
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            return this.getSSLContext().getSocketFactory().createSocket(host, port);
        }

        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
            return this.getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override
        public boolean equals(Object obj) {
            return obj != null && obj.getClass().equals(SSLSocketFactory.class);
        }

        @Override
        public int hashCode() {
            return SimpleHttpsClient.SimpleHttpsSocketFactory.class.hashCode();
        }
    }
}
