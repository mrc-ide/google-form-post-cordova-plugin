package org.imperial.dide;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GoogleFormPost extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("submit")) {
            String message = args.getString(0);
            this.submit(message, callbackContext);
            return true;
        }
        return false;
    }

    private void submit(String message, CallbackContext callbackContext) {
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSdG0fcvkwm5S0inTCld5Q1ZW8iK5jAItqLh7Yon0tSOYXbzaA/formResponse"

        String questionOne = "entry.480071232"
        HttpRequest mReq = new HttpRequest();
        String response = mReq.sendPost(url, "entry.480071232=Option 1");

        callbackContext.success(response);
    }
}