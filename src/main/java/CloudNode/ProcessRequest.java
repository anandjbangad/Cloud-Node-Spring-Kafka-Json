package CloudNode;

import com.codenotfound.model.Request;
import com.codenotfound.model.Response;

public class ProcessRequest {
    public Response requestProcess (Request request){
        Response response = new Response();
        response.setResult(request.getRequestValue() + "Cloud Key Cloud");
        response.setProcessedBy("CloudNode");
        response.setSendingTo(request.getrequestSentTo());
        return response;
    }
}
