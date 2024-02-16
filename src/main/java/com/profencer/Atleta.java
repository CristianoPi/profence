package com.profencer;

public class Atleta {
    private int codFIS;
	private String nome;
	private String cognome;
	private String CF;
	private boolean genere;
    private int Ranking;

    public Atleta(int codFIS, String nome, String cognome, String cF, boolean genere, int posRanking) {
        this.codFIS = codFIS;
        this.nome = nome;
        this.cognome = cognome;
        CF = cF;
        this.genere = genere;
        this.Ranking = posRanking;
    }

    public Atleta(int codFIS, String nome, String cognome, String cF, boolean genere) {
        this.codFIS = codFIS;
        this.nome = nome;
        this.cognome = cognome;
        CF = cF;
        this.genere = genere;
    }

    public int getCodFIS() {
        return codFIS;
    }

    public void setCodFIS(int codFIS) {
        this.codFIS = codFIS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String cF) {
        CF = cF;
    }

    public boolean isGenere() {
        return genere;
    }

    public void setGenere(boolean genere) {
        this.genere = genere;
    }

    public int getRanking() {
        return Ranking;
    }

    public void setRanking(int posRanking) {
        this.Ranking = posRanking;
    }

    
}
