package Constant.ServieCall;

import java.io.IOException;

import Constant.Constant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//Create abstract class to call api
public abstract class ServiceCalling {
    // Use singleton pattern for OkHttpClient to reuse connection pool and improve performance
    private static final OkHttpClient client = new OkHttpClient();

    // Callin api frm this method with type
    public void callRequestApi(String apiType) {
        Request request;
        // Use switch statement for better performance than if-else chain
        switch (apiType) {
            case Constant.GET:
                request = new Request.Builder()
                        .url(Constant.BASEURL)
                        .get()
                        .build();
                break;
            case Constant.PUT:
                request = new Request.Builder()
                        .url(Constant.BASEURL)
                        .put(null)
                        .build();
                break;
            default:
                request = new Request.Builder()
                        .url(Constant.BASEURL)
                        .build();
                break;
        }
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                // No need to create a new thread - we're already in an async callback
                // Read response body and ensure it's closed to prevent resource leaks
                try {
                    if (response.body() != null) {
                        String responseBody = response.body().string();
                        successResponse(responseBody);
                    } else {
                        successResponse("");
                    }
                } finally {
                    // Always close the response to prevent resource leaks
                    if (response != null) {
                        response.close();
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                // if api fail
                errorResponse(Constant.errorMsg);
            }
        });
    }

    abstract public void successResponse(String response);// pass sucess response

    abstract public void errorResponse(String response);// pass error response

}
