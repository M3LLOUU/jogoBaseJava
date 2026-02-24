package org.example.aulaPOO;

public class Personagem {

    String nome;
    int vida;
    int ataque;
    int defesa;

    public Personagem(String nome, int vida, int ataque, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    void exibirStatus(){
        System.out.println("=== PERSONAGEM ===");
        System.out.println("Nome do personagem: " + nome);
        System.out.println("💟 Vida: " + vida);
        System.out.println("⚔️ Ataque: " + ataque);
        System.out.println("🛡️ Defesa: " + defesa);
    }
}
