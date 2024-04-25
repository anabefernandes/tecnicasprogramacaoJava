public class Caminhao extends Veiculo {
    private int qtdPortas;
    private boolean arCondicionado;
    private int qtdEixos;

    public Caminhao(String placa, String marca, String modelo, int ano, int qtdPortas, boolean arCondicionado,
            int qtdEixos) {
        super(placa, marca, modelo, ano);
        this.qtdPortas = qtdPortas;
        this.arCondicionado = arCondicionado;
        this.qtdEixos = qtdEixos;
    }

    public void partida() {
        System.out.println("O caminhão ligou...");
    }

    public void buzinar() {
        System.out.println("BIBIBI");
    }

    public String toString() {
        return "\n Caminhão: \n"
                + "Placa: " + this.getPlaca() + "\n"
                + "Marca: " + this.getMarca() + "\n"
                + "Modelo: " + this.getModelo() + "\n"
                + "Ano: " + this.GetAno() + "\n"
                + "Portas: " + this.qtdPortas + "\n"
                + "ArCondicionado: " + (this.arCondicionado == true ? " Possui" : "Nao Possui") + "\n"
                + "Eixos: " + this.qtdEixos + "\n";
    }

}
