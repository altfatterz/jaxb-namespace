package com.za.jaxb.widget;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "widget", namespace = "http://www.backbase.com/ns/widgets")
@XmlAccessorType(XmlAccessType.FIELD)
public class WidgetConfig {

    @XmlElementWrapper(name = "resources", namespace = "http://www.backbase.com/ns/widgets")
    @XmlElement(name = "resource", namespace = "http://www.backbase.com/ns/widgets")
    private List<WidgetResourceRef> widgetResourceRefs;

    public WidgetConfig() {
        widgetResourceRefs = new ArrayList<>();
    }

    public void addWidgetResource(WidgetResourceRef widgetResourceRef) {
        widgetResourceRefs.add(widgetResourceRef);
    }

    public List<WidgetResourceRef> getWidgetResourceRefs() {
        return widgetResourceRefs;
    }

}
