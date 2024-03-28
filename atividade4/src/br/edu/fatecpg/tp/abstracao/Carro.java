package br.edu.fatecpg.tp.abstracao;

public class Carro {
	private String marca;
	private String modelo;
	private String placa;
	private String motor;
	private String chassi;
	private boolean status=false;
	public double velAtual=0;
	private double velMax=180;
	public double gasolina=50;
	
	public Carro(String marca, String modelo, String placa, String motor, String chassi){
		this.marca=marca;
		this.modelo=modelo;
		this.placa=placa;
		this.motor=motor;
		this.chassi=chassi;
	}	
	public String getMarca(){
		return marca;
	}
	public void setMarca(String marca){
		this.marca=marca;
	}
	public String getModelo(){
		return modelo;
	}
	public void setModelo(String modelo){
		this.modelo=modelo;
	}
	public String getPlaca(){
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa=placa;
	}
	public void girarChave() throws InterruptedException {
		if (this.status==false) {
		   this.status=true;
		   System.out.println("Ligado");
		   Thread.sleep(1000);
		   System.out.println("Acelerando");
		} else if (this.status==true) {
		   this.status=false;
		   System.out.println("Desligamdo");
		   Thread.sleep(1000);
		   System.out.println("Desligado");
		}
	}
	public void acelerar(double aceleracao) throws InterruptedException {
		if (this.velAtual < this.velMax) {
		   this.velAtual += aceleracao;
		   System.out.println("Acelerando...");
		   Thread.sleep(1000);
  
		   if (velAtual >= 180) {
			  this.velAtual = 180;
			  System.out.println("Atenção. Você está na velocidade maxima ou acima");
		   }
		}
	}
  
	public void desacelerar(double desaceleraracao) throws InterruptedException {
		if (this.velAtual != 0) {
		   this.velAtual -= desaceleraracao;
		   System.out.println("Desacelerando carro");
		   Thread.sleep(800);
  
		   if (velAtual == 0) {
			  this.velAtual = 0;
			  System.out.println("Carro parado, acelere.");
		   }
		}
	}
  
	public void buzinar() {
		System.out.println("BIBI BIBI");
	}
  
	public void abastecer(double valorGas) {
		double tanqueCheio = valorGas * tanque;
		System.out.println("O valor para encher o tanque é de: R$" + tanqueCheio);
	}

}







