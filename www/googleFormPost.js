/*global cordova, module*/

module.exports = {
    submit: function (url, params, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "GoogleFormPost", "submit", [url, params]);
    }
};