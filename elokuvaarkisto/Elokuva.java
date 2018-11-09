/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elokuvaarkisto;

/**
 *
 * @author Jesse
 */
public class Elokuva {
    private String title;
    private String kesto;
    private String paikka;
    private String kuva;
    private String kuvaus;
    private String laji;
    public Elokuva(String nimi, String kesto, String paikka, String kuvanSijainti, String kuvaus, String lajii){
        this.kesto = kesto;
        this.kuva = kuvanSijainti;
        this.paikka = paikka;
        this.title = nimi;
        this.kuvaus = kuvaus;
        this.laji = lajii;
    }

    public String getLaji() {
        return laji;
    }

    public void setLaji(String laji) {
        this.laji = laji;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKesto() {
        return kesto;
    }

    public void setKesto(String kesto) {
        this.kesto = kesto;
    }

    public String getPaikka() {
        return paikka;
    }

    public void setPaikka(String paikka) {
        this.paikka = paikka;
    }

    public String getKuva() {
        return kuva;
    }

    public void setKuva(String kuva) {
        this.kuva = kuva;
    }
    
}
