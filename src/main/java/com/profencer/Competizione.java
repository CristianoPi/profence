package com.profencer;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Competizione {
	private int codCompetizione;
	private String nome;
	private String descrizione;
	private Date data;
	private String categoria;
	private String arma;
	private float quotaParticipazione;
	private FormulaDiGara FormulaDiGara;
	private List<Girone> Gironi;
    //private Map<Integer, Set<Integer>> iscritti = new HashMap<>();
    private List<Atleta> iscritti;
    //private Map<Integer, Set<Integer>> accettazioni = new HashMap<>();
    private List<Atleta> accettazioni;
  
    //gettere and setter

    public int getCodCompetizione() {
        return codCompetizione;
    }

    public List<Atleta> getIscritti() {
        return iscritti;
    }

    public void setIscritti(List<Atleta> iscritti) {
        this.iscritti = iscritti;
    }

    public List<Atleta> getAccettazioni() {
        return accettazioni;
    }

    public void setAccettazioni(List<Atleta> accettazioni) {
        this.accettazioni = accettazioni;
    }

    public void setCodCompetizione(int codCompetizione) {
        this.codCompetizione = codCompetizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public float getQuotaParticipazione() {
        return quotaParticipazione;
    }

    public void setQuotaParticipazione(float quotaParticipazione) {
        this.quotaParticipazione = quotaParticipazione;
    }

    public FormulaDiGara getFormulaDiGara() {
        return FormulaDiGara;
    }

    public void setFormulaDiGara(FormulaDiGara formulaDiGara) {
        FormulaDiGara = formulaDiGara;
    }

    public List<Girone> getGironi() {
        return Gironi;
    }

    public void setGironi(List<Girone> gironi) {
        Gironi = gironi;
    }

    //costruttori
    public Competizione(int codCompetizione) {
        this.codCompetizione = codCompetizione;
    }

    public Competizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma,
            float quotaParticipazione, com.profencer.FormulaDiGara formulaDiGara, List<Girone> gironi,
            Map<Integer, Set<Integer>> iscritti, Map<Integer, Set<Integer>> accettazioni) {
        this.codCompetizione = codCompetizione;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.arma = arma;
        this.quotaParticipazione = quotaParticipazione;
        FormulaDiGara = formulaDiGara;
        Gironi = gironi;
        this.iscritti = iscritti;
        this.accettazioni = accettazioni;
    }
    
    public Competizione() {
        
    }

    //operazioni
    public void Iscrizione(Atleta atleta){
        iscritti.add(atleta);
    }

    public void AccettazioneAtleta(int codFIS)
    {
        for (Atleta atleta : iscritti) {
            if (atleta.getCodFIS()==codFIS) {
                accettazioni.add(atleta);
            }
        }
        //gestire errori
    }

    public void CreazioneGironi(){
        
    }
}
