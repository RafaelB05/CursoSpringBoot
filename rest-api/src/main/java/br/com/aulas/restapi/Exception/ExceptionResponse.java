package br.com.aulas.restapi.Exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private Date timeStamp;
    private String response;
    private String details;
    
    public ExceptionResponse(Date timeStamp, String response, String details) {
        this.timeStamp = timeStamp;
        this.response = response;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getResponse() {
        return response;
    }

    public String getDetails() {
        return details;
    }

    

}
