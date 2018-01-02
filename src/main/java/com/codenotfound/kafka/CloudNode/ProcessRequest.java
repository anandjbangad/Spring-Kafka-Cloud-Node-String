package com.codenotfound.kafka.CloudNode;

import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.model.Response;

public class ProcessRequest {
    public Response requestProcess (Request request){
        Response response = new Response();
        response.setResult(request.getRequestValue() + " CloudKey specialkey{c001}");
        response.setProcessedBy("CloudNode");
        response.setSendingTo(request.getResponseGivenBackTo());
        response.setRequestNumber(request.getRequestNumber());
        return response;
    }
}
