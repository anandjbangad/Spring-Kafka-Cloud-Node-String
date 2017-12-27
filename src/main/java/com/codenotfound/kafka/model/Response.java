package com.codenotfound.kafka.model;

public class Response {
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getSendingTo() {
        return sendingTo;
    }

    public void setSendingTo(String sendingTo) {
        this.sendingTo = sendingTo;
    }

    public String result;
    public String processedBy;
    public String sendingTo;

    public Response(){
        super();
    }

    public Response(String result, String processedBy, String sendingTo) {
        super();
        this.result = result;
        this.processedBy = processedBy;
        this.sendingTo = sendingTo;

    }
}
