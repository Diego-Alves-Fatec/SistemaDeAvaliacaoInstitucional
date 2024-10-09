package comercial.model.Util;

public class Paginador {

    private int paginaAtual;
    private int itensPorPagina;
    private int tamanhoTotal;

    public Paginador(int itensPorPagina, int tamanhoTotal) {
        this.paginaAtual = 1;
        this.itensPorPagina = itensPorPagina;
        this.tamanhoTotal = tamanhoTotal;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public int getItensPorPagina() {
        return itensPorPagina;
    }

    public void setItensPorPagina(int itensPorPagina) {
        this.itensPorPagina = itensPorPagina;
    }

    public int getTamanhoTotal() {
        return tamanhoTotal;
    }

    public void setTamanhoTotal(int tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
    }
}
