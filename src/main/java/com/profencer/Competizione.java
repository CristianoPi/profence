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

    public boolean Iscrizione(int codFIS){
        try {
            Integer chiave_competizione= this.codCompetizione;

            Integer elemento_atleta = codFIS;

            // Ottieni il Set dalla mappa
            Set<Integer> set = iscritti.get(chiave_competizione);
            // Se il Set non esiste, crealo(prima iscrizione)
            if (set == null) {
                set = new HashSet<>();
                iscritti.put(chiave_competizione, set);
            }
            set.add(elemento_atleta);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
