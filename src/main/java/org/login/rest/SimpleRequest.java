package org.login.rest;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by user on 12/29/2016.
 */

//@JsonIgnoreProperties(ignoreUnknown = true)

@XmlRootElement
public class SimpleRequest {
    //@XmlElement(name = "ID")
    private Long id;
    private String name;
    private String other;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "SimpleRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
