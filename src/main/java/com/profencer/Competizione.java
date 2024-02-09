package com.profencer;

import java.util.Date;
import java.util.List;

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

    private List<Atleta> Iscrizioni;

    private List<Atleta> Accettazioni;

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

    public List<Atleta> getIscrizioni() {
        return Iscrizioni;
    }

    public void setIscrizioni(List<Atleta> iscrizioni) {
        Iscrizioni = iscrizioni;
    }

    public List<Atleta> getAccettazioni() {
        return Accettazioni;
    }

    public void setAccettazioni(List<Atleta> accettazioni) {
        Accettazioni = accettazioni;
    }

    public Competizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma,
            float quotaParticipazione, com.profencer.FormulaDiGara formulaDiGara, List<Girone> gironi,
            List<Atleta> iscrizioni, List<Atleta> accettazioni) {
        this.codCompetizione = codCompetizione;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.arma = arma;
        this.quotaParticipazione = quotaParticipazione;
        FormulaDiGara = formulaDiGara;
        Gironi = gironi;
        Iscrizioni = iscrizioni;
        Accettazioni = accettazioni;
    }
    
    
}
