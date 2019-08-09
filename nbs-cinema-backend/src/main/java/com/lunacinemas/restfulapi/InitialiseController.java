package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.Initialise;
import com.lunacinemas.businesslogic.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class InitialiseController extends MyController<Initialise> {

    @Autowired
    private Initialise initializer;

    @RequestMapping(value = "/initialise")
    @ResponseBody
    public ResponseObject<Object> initialise(){
        return initializer.initialiseData();
    }

}
