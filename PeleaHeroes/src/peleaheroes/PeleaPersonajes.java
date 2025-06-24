package peleaheroes;

import java.util.Random;

public class PeleaPersonajes {
    public static void pelea(Personaje prmPj1, Personaje prmPj2) throws InterruptedException{
        int turno = 1, turnoPersonaje1, turnoPersonaje2, danoInfligido, evasion;
        boolean estadoTurnoPj1 = false;
        
        // Definir los turnos
        System.out.println("Quien da el primer golpe?");
        turnoPersonaje1 = numeroRandom(11);
        turnoPersonaje2 = numeroRandom(11);
        
        if(turnoPersonaje1 > turnoPersonaje2){
            System.out.println(prmPj1.getNombre() + " ataca primero!");
            estadoTurnoPj1 = true;
        } else {
            System.out.println(prmPj2.getNombre() + " ataca primero!");
        }
        
        System.out.println("Comienza la pelea!");
        do{
            System.out.println("TURNO: " + turno);
            
            if(estadoTurnoPj1 == true){
                System.out.println("TURNO DE: " + prmPj1.getNombre());
                
                if(prmPj1.getRegeneracion() == false){
                    System.out.println(prmPj1.getNombre() + " ataca a " + prmPj2.getNombre() + "!");
                    // Ver si evade
                    evasion = numeroRandom(101);
                    if(evasion <= prmPj1.getEvasionDeAtaques() && turno != 1){
                        System.out.println(prmPj2.getNombre() + " ha evadido el ataque de " + prmPj1.getNombre() + "!" + "! con " + evasion + " de posibilidades...");
                    } else {
                        danoInfligido = prmPj1.Atacar(prmPj1.getAtaqueMinimo(), prmPj1.getAtaqueMaximo());
                        System.out.println(prmPj1.getNombre() + " le inflinge " + danoInfligido + " a " + prmPj2.getNombre() + "!");
                        prmPj2.setPuntosDeVida(prmPj2.getPuntosDeVida() - danoInfligido);
                        System.out.println("a " + prmPj2.getNombre() + " le quedan " + prmPj2.getPuntosDeVida() + " puntos de vida...");
                        if(danoInfligido == prmPj1.getAtaqueMaximo()){
                            System.out.println(prmPj1.getNombre() + " le ha dado un golpe critico a " + prmPj2.getNombre() + "!");
                            System.out.println(prmPj2.getNombre() + " empieza a regenerarse...");
                            prmPj2.setRegeneracion(true);
                        }
                    }
                } else {
                    System.out.println(prmPj1.getNombre() + " apenas termino de regenerarse y perdio este turno...");
                    prmPj1.setRegeneracion(false);
                }
                estadoTurnoPj1 = false;
            } else {
                System.out.println("TURNO DE: " + prmPj2.getNombre());

                if (prmPj2.getRegeneracion() == false) {
                    System.out.println(prmPj2.getNombre() + " ataca a " + prmPj1.getNombre() + "!");
                    // Ver si evade
                    evasion = numeroRandom(101);
                    if (evasion <= prmPj2.getEvasionDeAtaques() && turno != 1) {
                        System.out.println(prmPj1.getNombre() + " ha evadido el ataque de " + prmPj2.getNombre() + "! con " + evasion + " de posibilidades...");
                    } else {
                        danoInfligido = prmPj1.Atacar(prmPj2.getAtaqueMinimo(), prmPj2.getAtaqueMaximo());
                        System.out.println(prmPj2.getNombre() + " le inflinge " + danoInfligido + " a " + prmPj1.getNombre() + "!");
                        prmPj1.setPuntosDeVida(prmPj1.getPuntosDeVida() - danoInfligido);
                        System.out.println("a " + prmPj1.getNombre() + " le quedan " + prmPj1.getPuntosDeVida() + " puntos de vida...");
                        if (danoInfligido == prmPj2.getAtaqueMaximo()) {
                            System.out.println(prmPj2.getNombre() + " le ha dado un golpe critico a " + prmPj1.getNombre() + "!");
                            System.out.println(prmPj1.getNombre() + " empieza a regenerarse...");
                            prmPj1.setRegeneracion(true);
                        }
                    }
                } else {
                    System.out.println(prmPj2.getNombre() + " apenas termino de regenerarse y perdio este turno...");
                    prmPj2.setRegeneracion(false);
                }
                estadoTurnoPj1 = true;
            }
            turno = turno + 1;
            
            //Esperar un segundo
            Thread.sleep(1000);
        }while(prmPj1.getPuntosDeVida() > 0 && prmPj2.getPuntosDeVida() > 0);
        
        
        System.out.println("La pelea ha terminado");
        
        if(prmPj1.getPuntosDeVida() > prmPj2.getPuntosDeVida()){
            System.out.println(prmPj1.getNombre() + " HA GANADO LA PELEA!");
        } else {
            System.out.println(prmPj2.getNombre() + " HA GANADO LA PELEA!");
        }
    }
    
   // Funcion para obtener un numero aleatorio
    public static int numeroRandom(int prmMax){
        Random random = new Random();
        return random.nextInt(prmMax);
    }
}
