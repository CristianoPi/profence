package com.profencer;

import java.util.Date;
import java.util.HashMap;
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

    private Map<Integer, Set<Integer>> iscritti = new HashMap<>();

    private Map<Integer, Set<Integer>> accettazioni = new HashMap<>();

    
    public Map<Integer, Set<Integer>> getIscritti() {
        return iscritti;
    } 

    public Map<Integer, Set<Integer>> getAccettazioni() {
        return accettazioni;
    } 

    public void setIscritti(Map<Integer, Set<Integer>> iscritti) {
        this.iscritti = iscritti;
    }

    public void setAccettazioni(Map<Integer, Set<Integer>> accettazioni) {
        this.accettazioni = accettazioni;
    }

    public int getCodCompetizione() {
        return codCompetizione;
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



 


    public Competizione(int codCompetizione) {
        this.codCompetizione = codCompetizione;
    }

    public boolean IscrizioneAtleta(int codFIS){
    if (iscritti == null) {
        iscritti = new HashMap<>();
    }
    iscritti.put(this.codCompetizione, codFIS);
    }
}
