package android.org.imperial.dide;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GoogleFormPost extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
            throws JSONException {

        if (action.equals("submit")) {
            String url = args.getString(0);
            String urlParameters = args.getString(1);

            this.submit(url, urlParameters, callbackContext);
            return true;

        }

        return false;
    }

    private void submit(String formUrl, String urlParameters, CallbackContext callbackContext) {

        try {
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
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
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);
            }
            int statusCode = conn.getResponseCode();
            if (statusCode == 200) {
                callbackContext.success(statusCode);
            }
            else{
                callbackContext.error(statusCode);
            }
        }
        catch (Exception e) {
            callbackContext.error(e.toString());
            e.printStackTrace();
        }
    }
}