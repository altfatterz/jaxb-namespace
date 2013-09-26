package com.za.jaxb.widget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class WidgetResourceRef {

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String src;

    public WidgetResourceRef() {
    }

    public WidgetResourceRef(String type, String src) {
        this.type = type;
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public String getSrc() {
        return src;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
