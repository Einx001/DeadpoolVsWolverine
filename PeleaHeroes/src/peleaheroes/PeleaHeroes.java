package peleaheroes;

public class PeleaHeroes {
    public static void main(String[] args) {
        int puntosDeVida;
        
        System.out.println("Configura las caracteristicas de los personajes");
        //Definir los atributos para deadpool
        System.out.println("Configura las caracteristicas de Deadpool:");
        puntosDeVida = Personaje.definirVida("Deadpool");
        Personaje deadpool = new Personaje(1, "Deadpool", puntosDeVida, 10, 100, false, 25);
        
        //Definir los atributos para Wolverine
        System.out.println("Configura las caracteristicas de Wolverine:");
        puntosDeVida = Personaje.definirVida("Wolverine");
        Personaje wolverine = new Personaje(1, "Wolverine", puntosDeVida, 10, 120, false, 20);
        
        // Inicializar una pelea
        //PeleaPersonajes peleaPersonajes = new PeleaPersonajes();
        System.out.println("Caracteristicas de los personajes configuradas, a pelear!");
        try {
            PeleaPersonajes.pelea(wolverine, deadpool);
        } catch (InterruptedException e) {
        }
    }
    
}
