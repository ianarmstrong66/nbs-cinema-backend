package com.lunacinemas.businesslogic;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResponseObject<T> {

    private boolean successful;
    private String body;
    private List<T> contentList;

    public ResponseObject(boolean successful, String body){
        this.successful = successful;
        this.body = body;
    }

    public ResponseObject(){}

    @Override
    public String toString() {
        return String.format(
                "Description[successful='%s', body='%s']",
                successful, body);
    }

    public void setBoth(boolean successful, String body) {
        this.successful = successful;
        this.body = body;
    }

    public void addToBody(String textToAdd){
        body += textToAdd;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<T> getContentList() {
        return contentList;
    }

    public void setContentList(List<T> contentList) {
        this.contentList = contentList;
    }

    public ResponseObject<T> negative(String bodyText) {
        successful=false;
        body=bodyText;
        contentList=null;
        return this;
    }

    public ResponseObject<T> positive(String bodyText, List<T> contentList){
        successful = true;
        body = bodyText;
        this.contentList = contentList;
        return this;
    }

    public ResponseObject<T> setAll(boolean successful, String body, List<T> contentList) {
        this.successful = successful;
        this.body = body;
        this.contentList = contentList;
        return this;
    }
}
