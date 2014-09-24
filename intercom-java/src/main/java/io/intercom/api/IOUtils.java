package io.intercom.api;

import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.net.HttpURLConnection;

class IOUtils {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("intercom-java");

    /**
     * Close a HttpURLConnection, ignores checked Exceptions and nulls,
     * but rethrows RuntimeExceptions.
     *
     * @param connection the connection to disconnect
     */
    public static void disconnectQuietly(HttpURLConnection connection) {
        if (connection != null) {
            try {
                connection.disconnect();
            } catch (RuntimeException rethrow) {
                throw rethrow;
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
        }
    }

    /**
     * Close a stream, ignores checked Exceptions and nulls,
     * but rethrows RuntimeExceptions.
     *
     * @param stream the object to close
     */
    public static void closeQuietly(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (RuntimeException rethrow) {
                throw rethrow;
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
        }
    }
}
