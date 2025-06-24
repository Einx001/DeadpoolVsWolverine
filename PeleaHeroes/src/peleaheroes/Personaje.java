package peleaheroes;

import java.util.Random;
import java.util.Scanner;

public class Personaje {
    // Atributos de los personjes
    private int id, puntosDeVida, ataqueMinimo, ataqueMaximo, evasionDeAtaques;
    private boolean regeneracion;
    private String nombre;
    
    // Constructor
    public Personaje(int id, String nombre, int puntosDeVida, int ataqueMinimo, int ataqueMaximo, boolean regeneracion, int evasionDeAtaques) {
        this.id = id;
        this.puntosDeVida = puntosDeVida;
        this.ataqueMinimo = ataqueMinimo;
        this.ataqueMaximo = ataqueMaximo;
        this.regeneracion = regeneracion;
        this.evasionDeAtaques = evasionDeAtaques;
        this.nombre = nombre;
    }
    
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int getAtaqueMinimo() {
        return ataqueMinimo;
    }

    public void setAtaqueMinimo(int ataqueMinimo) {
        this.ataqueMinimo = ataqueMinimo;
    }

    public int getAtaqueMaximo() {
        return ataqueMaximo;
    }

    public void setAtaqueMaximo(int ataqueMaximo) {
        this.ataqueMaximo = ataqueMaximo;
    }

    public boolean getRegeneracion() {
        return regeneracion;
    }

    public void setRegeneracion(boolean regeneracion) {
        this.regeneracion = regeneracion;
    }

    public int getEvasionDeAtaques() {
        return evasionDeAtaques;
    }

    public void setEvasionDeAtaques(int evasionDeAtaques) {
        this.evasionDeAtaques = evasionDeAtaques;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Funcion para definir la vida de un personaje
    public static int definirVida(String prmNombrePersonaje){
        Scanner scanner = new Scanner(System.in);
        
        int puntosDeVida;
        
        System.out.println("Ingresa los puntos de vida para " + prmNombrePersonaje);
        puntosDeVida = scanner.nextInt();
        System.out.println("Puntos de vida de " + prmNombrePersonaje + " definidos con exito!");
        
        return puntosDeVida;
    }
    
    public static int Atacar(int danoMinimo, int danoMaximo){
        Random random = new Random();
        return random.nextInt(danoMaximo - danoMinimo + 1) + danoMinimo;
    }
}
