package com.profencer;

public class Atleta {
    private int CodFIS;
	private String Nome;
	private String Cognome;
	private String CF;
	private boolean Genere;
    public int getCodFIS() {
        return CodFIS;
    }
    public String getNome() {
        return Nome;
    }
    public String getCognome() {
        return Cognome;
    }
    public String getCF() {
        return CF;
    }
    public boolean isGenere() {
        return Genere;
    }
    public void setCodFIS(int codFIS) {
        CodFIS = codFIS;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public void setCognome(String cognome) {
        Cognome = cognome;
    }
    public void setCF(String cF) {
        CF = cF;
    }
    public void setGenere(boolean genere) {
        Genere = genere;
    }
    public Atleta(int codFIS, String nome, String cognome, String cF, boolean genere) {
        CodFIS = codFIS;
        Nome = nome;
        Cognome = cognome;
        CF = cF;
        Genere = genere;
    }
    

    
}
