package org.login.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by user on 12/28/2016.
 */

@XmlRootElement
public class SimpleResponse {
    private Long id;
    private String name;

    public SimpleResponse() {
    }
    public SimpleResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
