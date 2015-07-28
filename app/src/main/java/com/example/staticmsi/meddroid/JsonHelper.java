package com.example.staticmsi.meddroid;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by hamadalmarri on 2015-07-22.
 */
public class JsonHelper {


    private static String domain = "http://10.0.2.2:8080/MyPatients_Spring";

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

    public static String DELETE(String path) {
        Requesting rq = new Requesting();
        rq.execute("delete", domain + path);

        return rq.result;
    }

    private static class Requesting extends AsyncTask<String, Void, String> {

        public static String result = null;
        public static boolean lock = false;

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
                else if (urls[0].equals("delete"))
                    return DELETE(urls[1]);
            }


            return "-1";
        }

        public static String DELETE(String url) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpDelete delete = new HttpDelete(url);

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
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost post = new HttpPost(url);
            StringEntity se = null;

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


        public static String PUT(String url, String json) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPut put = new HttpPut(url);
            StringEntity se = null;

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
                HttpClient httpclient = new DefaultHttpClient();

                // make GET request to the given URL
                HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

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
