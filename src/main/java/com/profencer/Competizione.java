package com.profencer;

import java.util.Date;

public class Competizione {
    private int Codice;
	private String Nome;
	private String Descrizione;
	private Date Data;
	private boolean Individuale;
	private String Categoria;
	private String Arma;
	private float QuotaParticipazione;
	private FormulaDiGara fdg;
    public int getCodice() {
        return Codice;
    }
    public String getNome() {
        return Nome;
    }
    public String getDescrizione() {
        return Descrizione;
    }
    public Date getData() {
        return Data;
    }
    public boolean isIndividuale() {
        return Individuale;
    }
    public String getCategoria() {
        return Categoria;
    }
    public String getArma() {
        return Arma;
    }
    public float getQuotaParticipazione() {
        return QuotaParticipazione;
    }
    public FormulaDiGara getFdg() {
        return fdg;
    }
    public void setCodice(int codice) {
        Codice = codice;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }
    public void setData(Date data) {
        Data = data;
    }
    public void setIndividuale(boolean individuale) {
        Individuale = individuale;
    }
    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
    public void setArma(String arma) {
        Arma = arma;
    }
    public void setQuotaParticipazione(float quotaParticipazione) {
        QuotaParticipazione = quotaParticipazione;
    }
    public void setFdg(FormulaDiGara fdg) {
        this.fdg = fdg;
    }
    public Competizione(int codice, String nome, String descrizione, Date data, boolean individuale, String categoria,
            String arma, float quotaParticipazione, FormulaDiGara fdg) {
        Codice = codice;
        Nome = nome;
        Descrizione = descrizione;
        Data = data;
        Individuale = individuale;
        Categoria = categoria;
        Arma = arma;
        QuotaParticipazione = quotaParticipazione;
        this.fdg = fdg;
    }
    
    
}
