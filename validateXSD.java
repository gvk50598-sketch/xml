import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidateXSD {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("students.xml");
            File xsdFile = new File("students.xsd");

            SchemaFactory factory = 
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(xmlFile));

            System.out.println("XSD Validation Successful");

        } catch (Exception e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
