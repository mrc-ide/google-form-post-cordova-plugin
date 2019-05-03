package org.imperial.dide;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestManager {

    public int Post(String formUrl, String parameters) throws IOException {

        byte[] postData = parameters.getBytes("UTF-8");
        int postDataLength = postData.length;
        URL url = new URL(formUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

        try {
            wr.write(postData);
        } finally {
                wr.close();
        }

        return conn.getResponseCode();
    }
}
