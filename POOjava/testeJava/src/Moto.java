public class Moto extends Veiculo{    
    private boolean temPartidaEletrica;    
    private int cilindradas;   
    public Moto(String placa, String marca, String modelo, int ano, boolean temPartidaEletrica, int cilindradas) { 
               super(placa, marca, modelo, ano);        
               this.temPartidaEletrica = temPartidaEletrica;        
               this.cilindradas = cilindradas;  
    }   
    public void pardida() { 
    System.out.println("A moto ligou");    
    }    
    public String toString() {       
        return "\nMoto: \n"               
         + "Placa: "+ this.getPlaca() +"\n"               
         + "Marca: "+ this.getMarca() +"\n"                
         + "Modelo: "+ this.getModelo() +"\n" 
         + "Ano: "+this.GetAno()+"\n"               
         + "Portas: " + this.cilindradas + "\n"                
         + "TetoSolar: " + (this.temPartidaEletrica == true ? " Possui" : "Nao Possui");   
        }
    }
