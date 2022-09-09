package Worker;

import Constant.Constant;
import Constant.ServieCall.ServiceCalling;

public class GetData extends ServiceCalling {

    @Override
    public void successResponse(String response) {

    }

    @Override
    public void errorResponse(String response) {

    }

    public void main() {
        callRequestApi(Constant.GET);
    }

}