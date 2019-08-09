package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.Requestable;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MyController <T extends Requestable> {

    @Autowired
    protected T businessware;

}
