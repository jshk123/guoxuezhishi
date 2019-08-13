package com.guoxuezhishi.utils;

import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/4
 */
public class Protocol {
    private static final Map PROTOCOLS = Collections.synchronizedMap(new HashMap());
    private String scheme;
    private ProtocolSocketFactory socketFactory;
    private int defaultPort;
    private boolean secure;

    public static void registerProtocol(String id, Protocol protocol) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        } else if (protocol == null) {
            throw new IllegalArgumentException("protocol is null");
        } else {
            PROTOCOLS.put(id, protocol);
        }
    }

    public Protocol(String scheme, ProtocolSocketFactory factory, int defaultPort) {
        if (scheme == null) {
            throw new IllegalArgumentException("scheme is null");
        } else if (factory == null) {
            throw new IllegalArgumentException("socketFactory is null");
        } else if (defaultPort <= 0) {
            throw new IllegalArgumentException("port is invalid: " + defaultPort);
        } else {
            this.scheme = scheme;
            this.socketFactory = factory;
            this.defaultPort = defaultPort;
            this.secure = factory instanceof SecureProtocolSocketFactory;
        }
    }
}
