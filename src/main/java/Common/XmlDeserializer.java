package Common;


import Models.Xml.Project;
import com.fasterxml.jackson.xml.XmlMapper;

import java.io.IOException;

public class XmlDeserializer {
    public Project PomXmlDeserialize(String xmlString) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Project object = xmlMapper.readValue(xmlString, Project.class);
        return object;

    }
}
