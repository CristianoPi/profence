package Main.domain;

public class FormulaDiGara {
    private int codFormula;

	private int numeroStoccateGironi;

	private int percEliminati;

	private int numeroStoccateDirette;

	private int maxDimGirone;

    public int getCodFormula() {
        return codFormula;
    }

    public void setCodFormula(int codFormula) {
        this.codFormula = codFormula;
    }

    public int getNumeroStoccateGironi() {
        return numeroStoccateGironi;
    }

    public void setNumeroStoccateGironi(int numeroStoccateGironi) {
        this.numeroStoccateGironi = numeroStoccateGironi;
    }

    public int getPercEliminati() {
        return percEliminati;
    }

    public void setPercEliminati(int percEliminati) {
        this.percEliminati = percEliminati;
    }

    public int getNumeroStoccateDirette() {
        return numeroStoccateDirette;
    }

    public void setNumeroStoccateDirette(int numeroStoccateDirette) {
        this.numeroStoccateDirette = numeroStoccateDirette;
    }

    public int getMaxDimGirone() {
        return maxDimGirone;
    }

    public void setMaxDimGirone(int maxDimGirone) {
        this.maxDimGirone = maxDimGirone;
    }

    public FormulaDiGara(int numeroStoccateGironi, int percEliminati, int numeroStoccateDirette, int maxDimGirone) {
        this.numeroStoccateGironi = numeroStoccateGironi;
        this.percEliminati = percEliminati;
        this.numeroStoccateDirette = numeroStoccateDirette;
        this.maxDimGirone = maxDimGirone;
    }
    

    
}
