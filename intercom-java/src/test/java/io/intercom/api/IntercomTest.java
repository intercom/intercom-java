package io.intercom.api;

import org.junit.After;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class IntercomTest {

    @After
    public void tearDown() {
        Intercom.setUseThreadLocal(false);
    }

    @Test
    public void testUseThreadLocal() {
        Intercom.setUseThreadLocal(false);
        assertFalse(Intercom.usesThreadLocal());
        Intercom.setUseThreadLocal(true);
        assertTrue(Intercom.usesThreadLocal());
    }

    @Test
    public void testApiKey() {
        Intercom.setApiKey("k1");
        assertEquals("k1", Intercom.getApiKey());
        assertEquals(Intercom.AuthKeyType.API_KEY, Intercom.getAuthKeyType());
        assertNull(Intercom.getToken());
    }

    @Test
    public void testToken() {
        Intercom.setToken("t1");
        assertEquals("t1", Intercom.getToken());
        assertEquals(Intercom.AuthKeyType.TOKEN, Intercom.getAuthKeyType());
        assertNull(Intercom.getApiKey());
    }

    @Test
    public void testStaticContext() throws Exception {
        Intercom.setApiKey("k1");
        assertEquals("k1", Intercom.getApiKey());
        assertNull(Intercom.getToken());
        assertEquals(Intercom.AuthKeyType.API_KEY, Intercom.getAuthKeyType());
        Intercom.setAppID("app1");
        assertEquals("app1", Intercom.getAppID());
        Intercom.setConnectionTimeout(98765);
        assertEquals(98765, Intercom.getConnectionTimeout());
        Intercom.setRequestTimeout(12345);
        assertEquals(12345, Intercom.getRequestTimeout());
        Intercom.setRequestUsingCaches(true);
        assertTrue(Intercom.isRequestUsingCaches());

        ThreadTester tt1 = new ThreadTester();
        ThreadTester tt2 = new ThreadTester();
        new Thread(tt1).run();
        new Thread(tt2).run();
        tt1.waitUntilComplete();
        tt2.waitUntilComplete();

        assertEquals(Intercom.getApiKey(), tt1.apiKey);
        assertEquals(Intercom.getAuthKeyType(), tt1.authKeyType);
        assertEquals(Intercom.getToken(), tt1.token);
        assertEquals(Intercom.getConnectionTimeout(), tt1.connectionTimeout);
        assertEquals(Intercom.getRequestTimeout(), tt1.requestTimeout);
        assertEquals(Intercom.isRequestUsingCaches(), tt1.requestUsingCaches);

        assertEquals(Intercom.getApiKey(), tt2.apiKey);
        assertEquals(Intercom.getAuthKeyType(), tt2.authKeyType);
        assertEquals(Intercom.getToken(), tt2.token);
        assertEquals(Intercom.getConnectionTimeout(), tt2.connectionTimeout);
        assertEquals(Intercom.getRequestTimeout(), tt2.requestTimeout);
        assertEquals(Intercom.isRequestUsingCaches(), tt2.requestUsingCaches);
    }

    @Test
    public void testThreadLocalContext() throws Exception {
        Intercom.setUseThreadLocal(true);

        ThreadLocalTester1 tt1 = new ThreadLocalTester1();
        ThreadLocalTester2 tt2 = new ThreadLocalTester2();
        new Thread(tt1).run();
        new Thread(tt2).run();
        tt1.waitUntilComplete();
        tt2.waitUntilComplete();

        assertEquals(tt1.localToken, tt1.token);
        assertNull(tt1.apiKey);
        assertEquals(Intercom.AuthKeyType.TOKEN, tt1.authKeyType);
        assertEquals(tt1.localConnectionTimeout, tt1.connectionTimeout);
        assertEquals(tt1.localRequestTimeout, tt1.requestTimeout);
        assertEquals(tt1.localRequestUsingCaches, tt1.requestUsingCaches);

        assertEquals(tt2.localApiKey, tt2.apiKey);
        assertNull(tt2.token);
        assertEquals(Intercom.AuthKeyType.API_KEY, tt2.authKeyType);
        assertEquals(tt2.localConnectionTimeout, tt2.connectionTimeout);
        assertEquals(tt2.localRequestTimeout, tt2.requestTimeout);
        assertEquals(tt2.localRequestUsingCaches, tt2.requestUsingCaches);
    }

    class ThreadTester implements Runnable {
        String apiKey, appId, token;
        Intercom.AuthKeyType authKeyType;
        int connectionTimeout = -1;
        int requestTimeout = -1;
        Boolean requestUsingCaches;
        boolean completed = false;

        @Override
        public void run() {
            apiKey = Intercom.getApiKey();
            authKeyType = Intercom.getAuthKeyType();
            token = Intercom.getToken();
            appId = Intercom.getAppID();
            connectionTimeout = Intercom.getConnectionTimeout();
            requestTimeout = Intercom.getRequestTimeout();
            requestUsingCaches = Intercom.isRequestUsingCaches();
            completed = true;
            synchronized (this) {
                notify();
            }
        }

        void waitUntilComplete() throws InterruptedException {
            synchronized (this) {
                while(!completed) {
                    wait(5000);
                }
            }
        }
    }

    class ThreadLocalTester1 extends ThreadTester {
        final Random rnd = new Random();
        final String localToken = "tx";
        final String localAppId = "appx";
        final int localConnectionTimeout = rnd.nextInt();
        final int localRequestTimeout = rnd.nextInt();
        final boolean localRequestUsingCaches = rnd.nextBoolean();

        @Override
        public void run() {
            Intercom.setToken(localToken);
            Intercom.setAppID(localAppId);
            Intercom.setConnectionTimeout(localConnectionTimeout);
            Intercom.setRequestTimeout(localRequestTimeout);
            Intercom.setRequestUsingCaches(localRequestUsingCaches);
            super.run();
        }
    }

    class ThreadLocalTester2 extends ThreadTester {
        final Random rnd = new Random();
        final String localApiKey = "api";
        final String localAppId = "appId";
        final int localConnectionTimeout = rnd.nextInt();
        final int localRequestTimeout = rnd.nextInt();
        final boolean localRequestUsingCaches = rnd.nextBoolean();

        @Override
        public void run() {
            Intercom.setApiKey(localApiKey);
            Intercom.setAppID(localAppId);
            Intercom.setConnectionTimeout(localConnectionTimeout);
            Intercom.setRequestTimeout(localRequestTimeout);
            Intercom.setRequestUsingCaches(localRequestUsingCaches);
            super.run();
        }
    }
}