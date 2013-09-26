package com.za.jaxb.widget;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class WidgetConfigTest {

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Unmarshaller unmarshaller;

    private final String WIDGET_CONFIG_EXAMPLE =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<bb:widget xmlns:bb=\"http://www.backbase.com/ns/widgets\">" +
                "<bb:resources>" +
                    "<bb:resource type=\"application/javascript\" src=\"js/wrap-layout.js\"/>" +
                "</bb:resources>" +
            "</bb:widget>";

    @Test
    public void marhall() throws IOException {

        WidgetConfig widgetConfig = new WidgetConfig();
        widgetConfig.addWidgetResource(new WidgetResourceRef("application/javascript", "js/wrap-layout.js"));

        Writer writer = new StringWriter();
        marshaller.marshal(widgetConfig, new StreamResult(writer));

        assertEquals(WIDGET_CONFIG_EXAMPLE, writer.toString());
    }

    @Test
    public void unmarshall() throws IOException {

        WidgetConfig widgetConfig = (WidgetConfig) unmarshaller.unmarshal(new StreamSource(new StringReader(WIDGET_CONFIG_EXAMPLE)));

        assertThat(widgetConfig.getWidgetResourceRefs().get(0).getSrc(), is("js/wrap-layout.js"));
        assertThat(widgetConfig.getWidgetResourceRefs().get(0).getType(), is("application/javascript"));
    }

}
