/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elokuvaarkisto;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jesse
 */
public class Lataaja {
    private String oso;
    public Lataaja(String o){
        this.oso = o;
    }
    public void Lataus(ArrayList<Elokuva> map){
        try{
       File inputFile=new File("Elokuvat.xml");
       
        //Scanner sc = new Scanner(file);
       // System.out.println("ok");
        ArrayList<Elokuva> elokuvat = new ArrayList<>();
       // System.out.println("ok");
        //System.out.println(sc.hasNextLine());
     //  File inputFile = new File("input.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
       //  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("item");
        // System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
          //  System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               
             String nimi = eElement
                  .getElementsByTagName("title")
                  .item(0)
                  .getTextContent();
             String kesto = eElement
                  .getElementsByTagName("kesto")
                  .item(0)
                  .getTextContent();
             String paikka = eElement
                  .getElementsByTagName("paikka")
                  .item(0)
                  .getTextContent();
             String kuva = eElement
                  .getElementsByTagName("kuva")
                  .item(0)
                  .getTextContent();
             String kuvaus = eElement
                  .getElementsByTagName("kuvaus")
                  .item(0)
                  .getTextContent();
             String laji = eElement
                  .getElementsByTagName("laji")
                  .item(0)
                  .getTextContent();
             map.add(new Elokuva(nimi, kesto, paikka, kuva, kuvaus, laji));
            }
         }
        } catch(Exception e){
        }
        }
            //elokuvat.add(new Elokuva(osa.get(0), osa.get(2), osa.get(1), osa.get(3), osa.get(4), osa.get(5)));
        
        

          /*  String nimi = eElement.getElementsByTagName("title").item(0).getTextContent();
            String paikka = eElement.getElementsByTagName("paikka").item(0).getTextContent(); 
            String kesto = eElement.getElementsByTagName("kesto").item(0).getTextContent();
            String kuva = eElement.getElementsByTagName("kuva").item(0).getTextContent();
            String kuvaus = eElement.getElementsByTagName("kuvaus").item(0).getTextContent();
            
            map.put(temp, new Elokuva(nimi, kesto, paikka, kuva, kuvaus)); */

    

    private ArrayList<String> listaus(String rivi) {
        ArrayList<String> lista = new ArrayList<>();
        String sana = "";
        for(int kierros=0;kierros<rivi.length();kierros++){
            char kirjain = rivi.charAt(kierros);
            String merkkiApu = ";";
            char merkki = merkkiApu.charAt(0);
            
            if(kirjain == merkki){
                
                lista.add(sana);
                sana="";
            } else{
                sana += kirjain;
            }
        }
        System.out.println("Listaa metodissa: " + lista);
        return lista;
    }
}
