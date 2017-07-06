package org.login.rest;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by user on 1/4/2017.
 */

@RestController
@RequestMapping("/customer")
public class RestResource {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public SimpleResponse index() {
        return new SimpleResponse(counter.incrementAndGet(),"Jorge");
    }


    @RequestMapping(
            value = {"/home"},
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public SimpleResponse home(@RequestBody SimpleRequest request, HttpServletRequest httpRequest) {
        System.err.println("hello: " + request);
        return new SimpleResponse(request.getId(), request.getName());
    }

    @RequestMapping(
            value = {"/queryParams"},
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public SimpleResponse queryParams( @RequestHeader("id") Long id,
                                    @RequestHeader("name") String name) {
        System.err.println("hello: " + (2 * id));
        return new SimpleResponse(2 * id, name);
    }

    @RequestMapping(
            value = {"/form1"},
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public SimpleResponse formData(@RequestBody MultiValueMap params) {
        System.err.println("hello: " + params);
        return new SimpleResponse(2L, "algo");
    }

    @RequestMapping(
            value = {"/form2"},
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public SimpleResponse formData(@RequestParam Long id, @RequestParam String name) {
        System.err.println("hello: " + name);
        return new SimpleResponse(2L, "algo");
    }

    @RequestMapping(
            value = {"/form3"},
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public SimpleResponse formData(SimpleRequest request) {
        System.err.println("hello: " + request.getName());
        return new SimpleResponse(2L, "algo");
    }

}
