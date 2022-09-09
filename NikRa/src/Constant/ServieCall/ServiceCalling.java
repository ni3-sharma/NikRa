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
    OkHttpClient client = new OkHttpClient();

    // Callin api frm this method with type
    public void callRequestApi(String apiType) {
        Request request;
        if (apiType.equals(Constant.GET)) {
            request = new Request.Builder()
                    .url(Constant.BASEURL)
                    .get()
                    .build();
        } else if (apiType.equals(Constant.PUT)) {
            request = new Request.Builder()
                    .url(Constant.BASEURL)
                    .build();
        } else {
            request = new Request.Builder()
                    .url(Constant.BASEURL)
                    .build();
        }
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                new Thread(new Runnable() {
                    public void run() {
                        // success response and pass it to abstract function
                        successResponse(request.body().toString());
                    }
                }).start();
                ;
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
