package org.example.aulaPOO;
import java.util.ArrayList;

public class Heroi {
    private String nome;
    private int vidaMax;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int pocoes;
    private int xp;
    private int Item;

    public Heroi(String nome, int vida, int ataque, int defesa){
        this.nome = nome;
        this.vidaMax = vida;
        this.vidaAtual = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocoes = 3;
        this.xp = 0;
    }

    public String getNome() { return nome; }
    public int getVida()    { return vidaAtual; }
    public int getAtaque()  { return ataque; }
    public int getDefesa()  { return defesa; }
    public int getPocoes()  { return pocoes; }
    public int getXp()      { return xp; }


    // Inventario
    private ArrayList<Item> inventario = new ArrayList<Item>();

    public void adicionarItem(Item item) {
        inventario.add(item);
        System.out.println("🎒 " + item.getNome() + " adicionado com sucesso!");
    }

    public void listarItens() {
        if  (inventario.isEmpty()) {
            System.out.println("🎒 Inventário vázio!");
            return;
        }

        System.out.println("🎒 Inventário");
        for (int i = 0; i<inventario.size(); i++) {
            System.out.println((i+1) + ". " + inventario.get(i).getDescricao());
        }
    }

    int indice;

    public boolean usarItem(int idx){
        if (this.indice < 0 || this.indice >= inventario.size()) {
            System.out.println(" ❌ Item inválido");
            return false;
        }

        Item item = inventario.get(this.indice);
        item.usar(Heroi.this);
        inventario.remove(this.indice);
        return true;
    }

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

