package org.imperial.dide;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class GoogleFormPost extends CordovaPlugin {

    private HttpRequestManager httpRequestManager;

    public GoogleFormPost() {
        this.httpRequestManager = new HttpRequestManager();
    }

    public GoogleFormPost(HttpRequestManager httpRequestManager) {
        this.httpRequestManager = httpRequestManager;
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
            throws JSONException {

        if (action.equals("submit")) {
            String url = args.getString(0);
            String parameters = args.getString(1);

            this.submit(url, parameters, callbackContext);
            return true;

        }

        return false;
    }

    private void submit(String formUrl, String parameters, CallbackContext callbackContext) {

        try {

            int statusCode = httpRequestManager.post(formUrl, parameters);
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