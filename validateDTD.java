import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ValidateDTD {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true); // Enable DTD validation

            SAXParser parser = factory.newSAXParser();

            parser.parse("students.xml", new DefaultHandler() {

                public void error(SAXParseException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                public void fatalError(SAXParseException e) {
                    System.out.println("Fatal Error: " + e.getMessage());
                }

                public void warning(SAXParseException e) {
                    System.out.println("Warning: " + e.getMessage());
                }
            });

            System.out.println("DTD Validation Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
