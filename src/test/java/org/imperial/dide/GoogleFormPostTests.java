package org.imperial.dide;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GoogleFormPostTests {

    private HttpRequestManager httpRequestManagerMock = mock(HttpRequestManager.class);
    private CallbackContext callbackContextMock = mock(CallbackContext.class);

    @Test
    public void ReturnsSuccessIfFormPostSuccessful() throws JSONException, IOException {

        when(httpRequestManagerMock.Post(anyString(), anyString())).thenReturn(200);

        GoogleFormPost sut = new GoogleFormPost(httpRequestManagerMock);
        sut.execute("submit", new JSONArray("['url', 'params']"), callbackContextMock);

        verify(callbackContextMock).success(200);
    }


    @Test
    public void ReturnsErrorIfFormPostUnSuccessful() throws JSONException, IOException {

        when(httpRequestManagerMock.Post(anyString(), anyString())).thenReturn(404);

        GoogleFormPost sut = new GoogleFormPost(httpRequestManagerMock);
        sut.execute("submit", new JSONArray("['url', 'params']"), callbackContextMock);

        verify(callbackContextMock).error(404);
    }
}
