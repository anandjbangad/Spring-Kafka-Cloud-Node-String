package com.codenotfound.kafka.CloudNode;

import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.model.Response;

public class ProcessRequest {
    public Response requestProcess (Request request){
        Response response = new Response();
        response.setResult(request.getRequestValue() + "Cloud Key Cloud");
        response.setProcessedBy("CloudNode");
        response.setSendingTo(request.getResponseGivenBackTo());
        return response;
    }
}
