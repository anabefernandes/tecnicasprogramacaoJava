
public class Principal {

    public static void main(String[] args) {        
        Veiculo carro = new Veiculo("HAUS526", "Volkswagem", "Gol", 2010);        
        System.out.println(carro + "\n");        

        Carro carro2 = new Carro("HAUS526", "Volkswagem", "Gol", 2010, 4, true, true);
        carro2.ligar(); 

        Moto moto = new Moto("HAUS526", "Volkswagem", "Gol", 2010, true, 2);       
        moto.ligar();   

        Caminhao caminhao = new Caminhao("HAUS526", "Volkswagem", "Gol", 2010, 180, true, 2);       
        caminhao.ligar(); 
        caminhao.partida();   
        caminhao.buzinar();

        System.out.println(carro2);   
        System.out.println(moto); 
        System.out.println(caminhao);    
    } 

}


