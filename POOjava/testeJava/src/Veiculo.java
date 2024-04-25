public class Veiculo {    
    private String placa;    
    private String marca;    
    private String modelo; 
    private int ano;   

    public Veiculo(String placa, String marca, String modelo, int ano) {       
       this.placa = placa;        
       this.marca = marca;        
       this.modelo = modelo; 
       this.ano = ano;   
    }        
    public String getPlaca() {        
    return placa;    
    }    
    public void setPlaca(String placa) { 
    this.placa = placa;    
    }    
    public String getMarca() {       
    return marca;   
    }   
    public void setMarca(String marca) {
    this.marca = marca;   
    }   
    public String getModelo() {        
    return modelo;    
    }    
    public void setModelo(String modelo) {        
    this.modelo = modelo;    
    }    
    public int GetAno(){
    return ano;
    }
    public void setAno(int ano){
    this.ano = ano;
    }
    public void ligar() {        
    System.out.println("Ligou! ");   
    }   
    @Override    
    public String toString() {        
    return "Veiculo \nPlaca: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo + "\nAno: " + ano;    
    }               
 }
