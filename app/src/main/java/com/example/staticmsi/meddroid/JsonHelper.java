package com.example.staticmsi.meddroid;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamadalmarri on 2015-07-22.
 */
public class JsonHelper {

    static String TAG = "JsonHelper";

    //    private static String domain = "http://10.0.2.2:8080/MyPatients_Spring";
    private static String domain = "http://69.11.16.153/mypatients";

    private static String loginPath = "/resources/j_spring_security_check";

    static BasicCookieStore cookieStore = null;


    public static String GET(String path) {


        Requesting rq = new Requesting();
        rq.execute("get", domain + path);

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (rq.lock);


        return rq.result;
    }

    public static String PUT(String path, String json) {
        Requesting rq = new Requesting();
        rq.execute("put", domain + path, json);

        return rq.result;
    }

    public static String POST(String path, String json) {
        Requesting rq = new Requesting();
        rq.execute("post", domain + path, json);

        return rq.result;
    }

    public static String LOGIN_POST(String username, String password) {
        Requesting rq = new Requesting();
        rq.execute("loginPost", domain + loginPath, username, password);

        return rq.result;
    }

    public static String DELETE(String path) {
        Requesting rq = new Requesting();
        rq.execute("delete", domain + path);

        return rq.result;
    }

    public static boolean ASSERT_LOGIN() {
        Requesting rq = new Requesting();
        rq.execute("assertLogin");

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (rq.lock);

        return rq.isLoggedIn;
    }

    private static class Requesting extends AsyncTask<String, Void, String> {

        public static String result = null;
        public static boolean lock = false;
        public static boolean isLoggedIn = false;

        @Override
        protected String doInBackground(String... urls) {

            synchronized (this) {

                while (lock) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                result = null;
                lock = true;


                if (urls[0].equals("get"))
                    return GET(urls[1]);
                else if (urls[0].equals("put"))
                    return PUT(urls[1], urls[2]);
                else if (urls[0].equals("post"))
                    return POST(urls[1], urls[2]);
                else if (urls[0].equals("loginPost"))
                    return LOGIN_POST(urls[1], urls[2], urls[3]);
                else if (urls[0].equals("delete"))
                    return DELETE(urls[1]);
                else if (urls[0].equals("assertLogin")) {
                    assertLogin();
                    return "";
                }
            }


            return "-1";
        }

        public static String DELETE(String url) {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpDelete delete = new HttpDelete(url);


            if (cookieStore != null)
                httpClient.setCookieStore(cookieStore);

            delete.addHeader("Accept", "application/json");

            try {
                HttpResponse response = httpClient.execute(delete, localContext);
//                HttpEntity entity = response.getEntity();
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }

            result = "done";

            lock = false;
            return result;
        }


        public static String POST(String url, String json) {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost post = new HttpPost(url);
            StringEntity se = null;


            if (cookieStore != null)
                httpClient.setCookieStore(cookieStore);

            try {
                se = new StringEntity(json);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

            post.addHeader("Accept", "application/json");
            post.addHeader("Content-type", "application/json");
            post.setEntity(se);


            try {
                HttpResponse response = httpClient.execute(post, localContext);
                HttpEntity entity = response.getEntity();
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }

            result = "done";

            lock = false;
            return result;
        }


        public static String LOGIN_POST(String url, String username, String password) {

//            Log.i(TAG, url);
//            Log.i(TAG, username);
//            Log.i(TAG, password);


            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost post = new HttpPost(url);
            cookieStore = new BasicCookieStore();

            post.addHeader("Accept", "application/html");

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("j_username", username));
            params.add(new BasicNameValuePair("j_password", password));

            try {
                post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


            try {
                HttpResponse response = httpClient.execute(post, localContext);
                HttpEntity entity = response.getEntity();


                List<Cookie> cookies = httpClient.getCookieStore().getCookies();
                for (Cookie cookie : cookies) {
                    Log.i(TAG, cookie.toString());
                    cookieStore.addCookie(cookie);
                }


            } catch (Exception e) {
                return e.getLocalizedMessage();
            }

            result = "done";

            lock = false;
            return result;
        }


        public static String PUT(String url, String json) {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPut put = new HttpPut(url);
            StringEntity se = null;


            if (cookieStore != null)
                httpClient.setCookieStore(cookieStore);

            try {
                se = new StringEntity(json);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

            put.addHeader("Accept", "application/json");
            put.addHeader("Content-type", "application/json");
            put.setEntity(se);


            try {
                HttpResponse response = httpClient.execute(put, localContext);
                HttpEntity entity = response.getEntity();
//                result = getASCIIContentFromEntity(entity);
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }

            result = "done";

            lock = false;
            return result;
        }

        public static String GET(String url) {

            InputStream inputStream = null;
            String result = "";

            try {

                // create HttpClient
                DefaultHttpClient httpclient = new DefaultHttpClient();
                HttpGet get = new HttpGet(url);

                if (cookieStore != null)
                    httpclient.setCookieStore(cookieStore);

                get.addHeader("Accept", "application/json");
                get.addHeader("Content-type", "application/json");

                // make GET request to the given URL
                HttpResponse httpResponse = httpclient.execute(get);

//                Log.i("Json2", url);

                // receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                // convert inputstream to string
                if (inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "-1";

            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            Requesting.result = result;

            lock = false;
            return result;
        }

        private static boolean assertLogin() {
            try {
                DefaultHttpClient httpclient = new DefaultHttpClient();
                HttpGet get = new HttpGet(domain + "/patients");

                if (cookieStore != null)
                    httpclient.setCookieStore(cookieStore);

                get.addHeader("Accept", "application/json");
                get.addHeader("Content-type", "application/json");

                // make GET request to the given URL
                HttpResponse httpResponse = httpclient.execute(get);

                String contentType = httpResponse.getHeaders("Content-Type")[0].getValue();
                if (contentType.equals("text/html;charset=UTF-8")) {
                    lock = false;

                    isLoggedIn = false;
                    return false;
                }

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            lock = false;

            isLoggedIn = true;
            return true;
        }

        private static String convertInputStreamToString(InputStream inputStream) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null)
                result.append(line);

            inputStream.close();
            return result.toString();
        }

    }

}
