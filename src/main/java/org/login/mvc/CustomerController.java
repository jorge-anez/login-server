package org.login.mvc;

import org.login.rest.SimpleRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 1/5/2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController{

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "hello world");
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ModelAndView register(@RequestBody SimpleRequest request) throws Exception {
        ModelAndView model = new ModelAndView("register");
        model.addObject("user", request);
        return model;
    }
}
