/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elokuvaarkisto;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class Arkisto {
    private ArrayList<Elokuva> map;
    public Arkisto(){
        this.map = new ArrayList<>();
    }
    public void lataa(){
        String osoite = "Elokuvat.xml";
        Lataaja lataus = new Lataaja(osoite);
        lataus.Lataus(this.map);
        
        System.out.println("listan koko: " + this.map.size()); 
     /*   this.map.put(0, new Elokuva("uuno epsanjassa","99", "eteinen", "null", "Uuno matkustaa espanjaan."));
        this.map.put(1, new Elokuva("uuno turhapuron aviokriisi","90","eteinen","null","uunolla huomataan hyvä hajuaisti ja hän pääsee poliisikoira kouluun."));
        this.map.put(2, new Elokuva("uuno turhapuro suomen tasavallan herra presidentti","83", "eteinen", "null", "uuno on presidenttinä."));
        this.map.put(3, new Elokuva("uuno turhapuro kaksoisagentti","89","eteinen","null","uuno toimii lastenvahtina ja kapellimestarina."));
        this.map.put(4, new Elokuva("uuno turhapuro","84","eteinen","null","Ensimmäinen uuno elokuva."));
        this.map.put(5, new Elokuva("Professori uuno D.G. turhapuro","82","eteinen","null","uuno etsii työpaikkaa ja onnistuu välttämään töitä!"));
        this.map.put(6, new Elokuva("häpy endkö? eli kuinka uuno turhapuro sai niin kauniin ja rikkaan vaimon","80","eteinen","null","mustavalkoinen uuno elokuva jossa näkyy kuinka uuno pääsi naimisiin."));
        this.map.put(7, new Elokuva("lottovoittaja ukk turhapuro","83","eteinen","null","uuno voittaa lotossa."));
        this.map.put(8, new Elokuva("uunon huikeat poikamiesvuodet maaseudulla","90","eteinen","null","uunon elämää ennen helsinkiin muuttamista. (onko ö:n päällä ä:n pilkut)")); */
    }
    public List<String> getOtsikot(){
        List<String> lista = new ArrayList<>();
        for(int kierros=0;kierros<this.map.size();kierros++){
            Elokuva elokuva = this.map.get(kierros);
            lista.add(elokuva.getTitle());
        }
        return lista;
    }
    public String[] getOtsikot2(){
        List<String> lista = this.getOtsikot();
        String[] otsikot = new String[lista.size()];
        for(int g=0;g<lista.size();g++){
            otsikot[g] = lista.get(g);
        }
        return otsikot;
    }
    public Elokuva getElokuva(String nimi){
        int index = 0;
      //  boolean onko = false;
        while(index < this.map.size()){
            if(this.map.get(index).getTitle().toLowerCase().contains(nimi.toLowerCase())){
                return this.map.get(index);
            }
            index++;
        }
        return null;
    }
    public ArrayList<String> eriLajit(){
        ArrayList<String>  lista = new ArrayList<>();
        for(int kierros=0;kierros<this.map.size();kierros++){
            if(!lista.contains(map.get(kierros).getLaji())){
                lista.add(map.get(kierros).getLaji());
            }
        }
        return lista;
    }
    public ArrayList<String> elokuvatLajinMukaan(String laji){
        ArrayList<String> lista = new ArrayList<>();
        for(int kierros=0;kierros<this.map.size();kierros++){
            if(this.map.get(kierros).getLaji().contains(laji)){
                lista.add(this.map.get(kierros).getTitle());
            }
        }
        return lista;
    }
    public ArrayList<String> elokuvatSanalla(String sana){
        ArrayList<String> lista = new ArrayList<>();
        for(int k=0;k<this.map.size();k++){
            if(this.map.get(k).getTitle().toLowerCase().contains(sana.toLowerCase())){
                lista.add(this.map.get(k).getTitle());
            }
        }
        return lista;
    }
}
