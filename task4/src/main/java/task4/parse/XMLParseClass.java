package task4.parse;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import task1.bag.Bag;
import task1.bag.BagKey;
import task1.cmd.CommandExecuter;
import task1.dao.CommandDao;
import task1.model.Command;
import task1.model.Customer;


@WebServlet("/loginServlet")
public class XMLParseClass extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 public static final String xmlFilePath = "C:\\Users\\Asus\\Desktop\\xmlfile.xml";
	 public static final String xmlFileName = "C:\\Users\\Asus\\Desktop\\xmlfile";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.getWriter().append("Served at: ").append(request.getContextPath());		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //doGet(request, response);
			
		// burada html den gelen bilgileri çekip xml e kaydetmek gerekiyor
		//********************************* input tan verileri çekme
		String cmdname = request.getParameter("cmdname");
		String cusID = request.getParameter("cusID");
		String tckn = request.getParameter("tckn");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		//********************************* xml dosyası oluşturma
		try {
			 
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
            // root element
            Element root = document.createElement("InputList");
            document.appendChild(root);
 
            // node element
            Element nodeCustomer = document.createElement("InputNode"); 
            root.appendChild(nodeCustomer);
            // adding node element variable
            // first element
            Element customercommandname = document.createElement("commandName");
            customercommandname.appendChild(document.createTextNode(cmdname));
            nodeCustomer.appendChild(customercommandname);
 
            // second element
            Element customername = document.createElement("Name");
            customername.appendChild(document.createTextNode(name));
            nodeCustomer.appendChild(customername);
 
            // third element
            Element customersurname = document.createElement("Surname");
            customersurname.appendChild(document.createTextNode(surname));
            nodeCustomer.appendChild(customersurname);
 
            // forth elements
            Element customertckn = document.createElement("Tckn");
            customertckn.appendChild(document.createTextNode(tckn));
            nodeCustomer.appendChild(customertckn);
            
            // fifth elements
            Element customerid = document.createElement("CusID");
            customerid.appendChild(document.createTextNode(cusID));
            nodeCustomer.appendChild(customerid);
 
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File"); 
             
            //********************************* executer çalıştırma
	   		 XMLParseClass xmlparse = new XMLParseClass();
//	       	 String xmlType = xmlFileName;
	       	 Bag resultBag = null;
	       	 String xmlType = xmlFileName ;
	       	 try {
	   			resultBag = xmlparse.XMLParse(xmlType);
	   		 }
	       	 catch (ParserConfigurationException | SAXException | IOException e) {
	   			e.printStackTrace();
	   		 } catch (Exception e) {
				e.printStackTrace();
			}    	       	 
   		
	       	 // *********************************  get response writer
	         PrintWriter writer = response.getWriter();
	          
	         // build HTML code
	         String htmlResponse = "<html>";
	         htmlResponse += "<h2> Kayit Basarili !!! </h2>";    
	         htmlResponse += " Kayit ID: " + resultBag.getValue(BagKey.ID) ;  
	         htmlResponse += " Kayit Name: " + resultBag.getValue(BagKey.NAME) ; 
	         htmlResponse += " Kayit Surname: " + resultBag.getValue(BagKey.SURNAME) ; 
	         htmlResponse += "</html>";	          
	         // return response
	         writer.println(htmlResponse);  
	         
	         //build xml  response
//	         String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//	         xmlResponse += "<OutputList><OutputNode> ";    
//	         xmlResponse += "<commandName> " + resultBag.getValue(BagKey.ID) + "</commandName>";  
//	         xmlResponse += "<Name>" + resultBag.getValue(BagKey.NAME) + "</Name>" ; 
//	         xmlResponse += "<Surname> " + resultBag.getValue(BagKey.SURNAME) + "</Surname>" ; 
//	         xmlResponse += "<Tckn> " + resultBag.getValue(BagKey.TCKN) + "</Tckn>" ; 
//	         xmlResponse += "</OutputNode></OutputList>";	
//	         	     
//	         // return response
//	         writer.println(xmlResponse);  	   
	         
	       // *********************************   xml dosyası yapılacak
	              	         
	       	 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
		
	}
	
	
	public Bag XMLParse(String xmlType) throws Exception {      
		
		Bag customerNewBag = null ;
		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(xmlType + ".xml"));

        NodeList nodeList = document.getDocumentElement().getChildNodes();        
       
        HashMap<Customer,String> xmlList = new HashMap<>();
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                 Element elem = (Element) node;
                 
                 String tckn = elem.getElementsByTagName("Tckn")
                         .item(0).getChildNodes().item(0).getNodeValue();
                 
                 String commandName = elem.getElementsByTagName("commandName")
                         .item(0).getChildNodes().item(0).getNodeValue();
                 
                 String name = elem.getElementsByTagName("Name")
                                     .item(0).getChildNodes().item(0).getNodeValue();

                 String surname = elem.getElementsByTagName("Surname").item(0)
                                     .getChildNodes().item(0).getNodeValue();                 

                 String cusid = elem.getElementsByTagName("CusID").item(0)
                         .getChildNodes().item(0).getNodeValue();                 
                 
                 Customer cNew = new Customer(tckn, name, surname) ;
                 xmlList.put(cNew, commandName );
                 
                 System.out.println("Customer : " + cNew );
                 System.out.println("commandName : " + commandName );
                 System.out.println("Tckn : " + tckn );
                 System.out.println("Name : " + name );
                 System.out.println("Surname : " + surname );
                 
            }
       }       
        
        Iterator<Entry<Customer,String>> itr = xmlList.entrySet().iterator();
		while (itr.hasNext()) {
			Entry entry =  itr.next();	
			Customer xmlcustomer  = (Customer) entry.getKey() ;
			System.out.println("------> Customer:" + xmlcustomer.getTckn() + " " + xmlcustomer.getName() + " " + xmlcustomer.getSurname());
			System.out.println("------> command name:" + entry.getValue() );	
			
			String commandName =  (String) entry.getValue() ;
			
			// executer Command ını çağırma
			CommandDao commandDao = new CommandDao();
			Command cmd = commandDao.getCommand(commandName);
		
			
			// command name e göre burası değişiyor ?????
			Bag bagAdd = new Bag();
			bagAdd.put(BagKey.TCKN, xmlcustomer.getTckn());
			bagAdd.put(BagKey.NAME,  xmlcustomer.getName());
			bagAdd.put(BagKey.SURNAME,  xmlcustomer.getSurname());

			CommandExecuter cmdExecuter = new CommandExecuter();
            customerNewBag = (Bag) cmdExecuter.execute(cmd, bagAdd);
//			Bag customerNewBag = (Bag) cmdExecuter.executeString(commandName, bagAdd);
			
			System.out.println("------> customerNewBag : " + customerNewBag );
			
		}
		return customerNewBag;        
       
        
    }
	

	
	

}
