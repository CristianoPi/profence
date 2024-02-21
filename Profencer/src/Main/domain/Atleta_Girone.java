package Main.domain;

public class Atleta_Girone {
    private int codFIS;
	private int stoccateDate;
	private int stoccateRicevute;
	private float punteggio;
	private int vittorie;
    private int sconfitte;
	private int posizione;// per posizione si intende quella nel girone, cioè quella data dal ranking

    public int getCodFIS() {
        return codFIS;
    }

    public void setCodFIS(int codFIS) {
        this.codFIS = codFIS;
    }

    public int getStoccateDate() {
        return stoccateDate;
    }

    public void setStoccateDate(int stoccateDate) {
        this.stoccateDate = stoccateDate;
    }

    public int getStoccateRicevute() {
        return stoccateRicevute;
    }

    public void setStoccateRicevute(int stoccateRicevute) {
        this.stoccateRicevute = stoccateRicevute;
    }

    public float getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(float punteggio) {
        this.punteggio = punteggio;
    }

    public int getVittorie() {
        return vittorie;
    }

    public void setVittorie(int vittorie) {
        this.vittorie = vittorie;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public Atleta_Girone(int codFIS, int stoccateDate, int stoccateRicevute, int punteggio, int vittorie,
            int posizione) {
        this.codFIS = codFIS;
        this.stoccateDate = stoccateDate;
        this.stoccateRicevute = stoccateRicevute;
        this.punteggio = punteggio;
        this.vittorie = vittorie;
        this.posizione = posizione;
    }

    public Atleta_Girone(int codFIS) {
        this.codFIS = codFIS;
    }

    public int getSconfitte() {
        return sconfitte;
    }

    public void setSconfitte(int sconfitte) {
        this.sconfitte = sconfitte;
    }
    @Override
    public String toString() {
        return "Atleta girone [codAatleta=" + this.codFIS + ", date=" + this.stoccateDate + ", ricevute=" + this.stoccateRicevute
                + ", punteggio=" + this.punteggio + ", vittorie"+this.vittorie+", posizione"+this.posizione+ "]";
    } 
}
