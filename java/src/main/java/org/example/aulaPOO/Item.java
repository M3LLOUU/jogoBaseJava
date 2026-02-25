package org.example.aulaPOO;
import java.util.ArrayList;

public class Item {

    private String nome;
    private String tipo;
    private int valor;

    private ArrayList<Item> inventario = new ArrayList<Item>();

    private void adicionarItem(Item item) {
        inventario.add(item);
        System.out.println("🎒 " + item.getNome() + " adicionado com sucesso!");
    }

    private void listarItems() {
        if  (inventario.isEmpty()) {
            System.out.println("🎒 Inventário vázio!");
            return;
        }

        System.out.println("🎒 Inventário");
        for (int i = 0; i<inventario.size(); i++) {
            System.out.println((i+1) + ". " + inventario.get(i).getDescricao());
        }
    }

    public boolean usarItem(int indice){
        if (indice < 0 || indice >= inventario.size()) {
            System.out.println(" ❌ Item inválido");
        }

        Item item = inventario.get(indice);
        item
        inventario.remove(indice);
        return true;
    }

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void usar(Heroi heroi) {
        if(tipo.equals("cura")) {
            heroi.usarPocao();
            System.out.println(" 🧪" + nome + " foi usado!");
        }
    }

    public String getDescricao() {
        return nome + " [" + tipo + " +" + valor + "]";
    }
    public String getNome() {return nome; }
    public String getTipo() { return tipo; }
    public int getValor() { return valor; }
}
