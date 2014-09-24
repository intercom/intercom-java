package io.intercom.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

public interface HttpConnectorSupplier {

    HttpURLConnection connect(URI uri) throws IOException;

    HttpConnectorSupplier defaultSupplier = new HttpConnectorSupplier() {
        public HttpURLConnection connect(URI uri) throws IOException {
            return (HttpURLConnection) uri.toURL().openConnection();
        }
    };
}
