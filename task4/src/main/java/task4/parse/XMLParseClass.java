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

import org.w3c.dom.Attr;
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
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());		
		
		response.setContentType("text/plain;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();

        out.print("Hello there from Servlet");
        
        
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //doGet(request, response);
				
		// burada html den gelen bilgileri çekip xml e kaydetmek gerekiyor
		//********************************* input tan verileri çekme
		String cmdname = request.getParameter("cmdname");
//		String cusID = request.getParameter("cusID");
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
	       	 String xmlType = xmlFileName;
	       	 try {
	   			xmlparse.XMLParse(xmlType);
	   		} catch (ParserConfigurationException | SAXException | IOException e) {
	   			e.printStackTrace();
	   		}    
   		
	       	 //*********************************  get response writer
	         PrintWriter writer = response.getWriter();
	          
	         // build HTML code
	         String htmlRespone = "<html>";
	         htmlRespone += "<h2> İŞLEM BAŞARILI !!! </h2>";    
	         htmlRespone += "</html>";
	          
	         // return response
	         writer.println(htmlRespone);  
	       	 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
		
	}
	
	
	public void XMLParse(String xmlType) throws ParserConfigurationException, SAXException, IOException {      
		
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

                 Customer cNew = new Customer(tckn, name, surname ) ;
                 xmlList.put(cNew, commandName );
                 
//                 System.out.println("Customer : " + cNew );
//                 System.out.println("commandName : " + commandName );
//                 System.out.println("Tckn : " + tckn );
//                 System.out.println("Name : " + name );
//                 System.out.println("Surname : " + surname );
                 
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
			if (!commandCheck(cmd)) {
				return;
			}

			Bag bagAdd = new Bag();
			bagAdd.put(BagKey.TCKN, xmlcustomer.getTckn());
			bagAdd.put(BagKey.NAME,  xmlcustomer.getName());
			bagAdd.put(BagKey.SURNAME,  xmlcustomer.getSurname());

			CommandExecuter cmdExecuter = new CommandExecuter();
			Bag customerNewBag = cmdExecuter.execute(cmd, bagAdd);
			
			System.out.println("------> customerNewBag : " + customerNewBag );
			
		}        
       
        
    }
	
	
	public static boolean commandCheck(Command command) {
		if (command == null) {
			System.out.println("*** NOT FOUND ***");
			return false;
		}
		System.out.println("-> Command Information; \n\t" + command.getCommand_name() + "\n\t"
				+ command.getCommand_description() + "\n\t" + command.getClass_name() + "\n\t" + command.getMethod_name());
		return true;
	}
	
	
	

}
