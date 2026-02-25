package org.example.aulaPOO;


public class Heroi {
    private String nome;
    private int vidaMax;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int pocoes;
    private int bussola;
    private int traje;
    private int xp;

    public Heroi(String nome, int vida, int ataque, int defesa int item){
        this.nome = nome;
        this.vidaMax = vida;
        this.vidaAtual = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocoes = 3;
        this.xp = 0;
        this.item();
    }

    public String getNome() { return nome; }
    public int getVida()    { return vidaAtual; }
    public int getAtaque()  { return ataque; }
    public int getDefesa()  { return defesa; }
    public int getPocoes()  { return pocoes; }
    public int getBussola() { return bussola; }
    public int getTraje() { return traje; }
    public int getXp()      { return xp; }

    public int atacar(){
        int variacao = (int)(Math.random() * 10) - 5;
        return ataque + variacao;
    }

    public void receberDano(int dano){
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vidaAtual -= danoReal;
        if(vidaAtual < 0) vidaAtual = 0;

        System.out.println(" " + nome + " recebeu " + danoReal + " de dano " + "[" + vidaAtual + "/" + vidaMax + "] ");

    }

    public boolean usarPocao() {
        if (pocoes <= 0){
            System.out.println("Sem poção!");
            return false;
        }

        if (vidaAtual == vidaMax){
            System.out.println("Vida cheia!");
            return false;
        }
        int cura = 30;
        vidaAtual += cura;

        if (vidaAtual > vidaMax) vidaAtual = vidaMax;

        pocoes--;

        System.out.println(nome + " usou poção! +30 " + "[" + vidaAtual + "/" + vidaMax + "] [Poções: " + pocoes + "]");
        return true;
    }

    public boolean usarBussola() {
        if (bussola <= 0){
            System.out.println("Sem bussola!");
            return false;
        }

        if (bussola > 1){
            System.out.println("Você tem uma bússola!");
            return true;
        }
    }

    public boolean usarTraje() {
        if (traje <= 0){
            System.out.println("Sem traje!");
            return false;
        }

        if (traje > 1){
            System.out.println("Você tem uma traje!");
            return false;

            traje -= 1;
            System.out.println(nome + " Trocou de traje!");
            return true;
        }
    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println("Ganhou:" + quantidade + "de XP! [Total: " + xp + "]");
    }

    public boolean estaVivo(){
        return vidaAtual > 0;
    }

    public void exibirStatus(){
        System.out.println("\n 🦸‍♂️ " + nome);
        System.out.println("❤️ Vida: " + vidaAtual + "/" + vidaMax);
        System.out.println("⚔️ Ataque: " + ataque);
        System.out.println("🛡️ Defesa: " + defesa);
        System.out.println("🧪 Poções: " + pocoes);
        System.out.println("⭐ XP: " + xp);
    }

}

