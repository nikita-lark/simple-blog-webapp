package ee.lark.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.UUID;

/**
 * An adapter for marshalling / unmarshalling UUIDs.
 */
public class UUIDAdapter extends XmlAdapter<String, UUID> {

    @Override
    public UUID unmarshal(String v) throws Exception {
        return UUID.fromString(v);
    }

    @Override
    public String marshal(UUID v) throws Exception {
        return v.toString();
    }
}