/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Leave}
 */
public class LeaveTest {
    @Test
    public void testEmptyElement() {
        Leave elem = new Leave.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Leave/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Leave elem = new Leave.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CLeave%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Leave elem = new Leave.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Leave a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        Leave.Builder builder = new Leave.Builder();

        builder.addText("Hey no tags!");

        Leave elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Leave>" +
            "Hey no tags!" +
            "</Leave>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Leave.Builder builder = new Leave.Builder();
        Leave elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Leave>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Leave>",
            elem.toXml()
        );
    }
}