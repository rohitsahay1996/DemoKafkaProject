package com.example.demoKafka.service.implementation;

import com.example.demoKafka.document.Employee;
import com.example.demoKafka.service.EmployeeFileHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmployeeXmlServiceImpl implements EmployeeFileHandler
{
    @Override
    public String readData(int readCounter)
    {
        try {

            File xmlFile = new File("/Users/rishabhbohra/Downloads/demoKafka/src/main/java/com/example/demoKafka/employee.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("employee");

            Employee readValue = new Employee();
            Node nNode = nList.item(readCounter);

            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;

                readValue.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
                readValue.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());

                String sDate = eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                Date date = new SimpleDateFormat("MM/dd/yyy").parse(sDate);
                readValue.setDateOfBirth(date);

                String sExperience = eElement.getElementsByTagName("experience").item(0).getTextContent();
                Double experience = Double.parseDouble(sExperience);

                readValue.setExperience(experience);
                //System.out.println(readValue);

                //String jsonEmployee="null";

                ObjectMapper objectMapper = new ObjectMapper();

                String jsonEmployee=objectMapper.writeValueAsString(readValue);
                return jsonEmployee;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
