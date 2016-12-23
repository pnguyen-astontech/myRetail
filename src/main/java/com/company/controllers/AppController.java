package com.company.controllers;

import com.company.domains.Product;
import com.company.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Controller
public class AppController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


}
