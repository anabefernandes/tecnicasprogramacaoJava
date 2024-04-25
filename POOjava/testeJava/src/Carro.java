public class Carro extends Veiculo {
    private int qtdPortas;
    private boolean tetoSolar;
    private boolean ArCondicionado;

    public Carro(String placa, String marca, String modelo, int ano, int qtdPortas, boolean tetoSolar,
            boolean ArCondicionado) {
        super(placa, marca, modelo, ano);
        this.qtdPortas = qtdPortas;
        this.tetoSolar = tetoSolar;
        this.ArCondicionado = ArCondicionado;
    }

    public void drift() {
        System.out.println("Cantou pneu ");
    }

    public String toString() {
        return "\nCarro: \n"
                + "Placa: " + this.getPlaca() + "\n"
                + "Marca: " + this.getMarca() + "\n"
                + "Modelo: " + this.getModelo() + "\n"
                + "Ano: " + this.GetAno() + "\n"
                + "Portas: " + this.qtdPortas + "\n"
                + "TetoSolar: " + (this.tetoSolar == true ? " Possui" : "Nao Possui")
                + "ArCondicionado: " + (this.ArCondicionado == true ? " Possui" : "Nao Possui");
    }
}
