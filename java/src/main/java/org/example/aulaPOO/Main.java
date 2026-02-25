package org.example.aulaPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       exibirTitulo();

       System.out.println("🦸 Digite o nome do super-herói: ");
       String nomeHeroi = scanner.next();

       Heroi heroi = new Heroi(nomeHeroi, 100, 20, 5);

        // Dando itens iniciais
        heroi.adicionarItem(new Item("Poção Pequena",  "cura", 20));
        heroi.adicionarItem(new Item("Poção Grande",   "cura", 50));
        heroi.adicionarItem(new Item("Erva Medicinal", "cura", 15));

        System.out.println("\n✅ Herói criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
                new Monstro("Goblin", "👹", 40, 12, 2, 20 ),
                new Monstro("Orc Guerreiro", "👿", 70, 12, 2, 20 ),
                new Monstro("Dragão", "👽", 40, 12, 2, 20 ),
                // Novos monstros ⬇️
                new Monstro("Vampira", "🧛🏻‍♂️", 40, 12, 2, 20 ),
                new Monstro("Zumbi", "🧟", 60, 14, 2, 25)
        };

        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n\n 🗺️ Você avança pela dungeon...");
            System.out.println("🚪 Um " + monstro.getNome() + " bloqueia o caminho!");
            System.out.println("\n [1] Lutar");
            System.out.println(" [2] Fugir (pula essa batalha)");
            System.out.println(" Escolha: ");

            int opcao;

            try {
                opcao = scanner.nextInt();
            } catch (Exception e ) {
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println(" 🏃🏻 Você fugiu para o próximo corredor...");
                continue;
            }

            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.iniciar();

            if (venceu){
                vitorias++;
                System.out.println("\n [Pressione ENTER para continuar]");
                scanner.nextLine();
                scanner.nextLine();
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return;
            }

        }

        exibirVitoria(heroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println(" ====================================== ");
        System.out.println("-       ⚔️ Dungeon Quest ⚔️            -");
        System.out.println("- Programação Orientada a Objeto      -");
        System.out.println(" ====================================== ");
        System.out.println();
    }

    private static void exibirGameOver(String nome, int vitorias, int xp) {
        System.out.println(" ====================================== ");
        System.out.println("-       ️   Game Over ️            -");
        System.out.println("-                                     -");
        System.out.println(" ====================================== ");
        System.out.println(" Fim da jornada épica " + nome);
        System.out.println(" Vitorias: " + vitorias);
        System.out.println(" XP: " + xp);
        System.out.println();
    }

    private static void exibirVitoria(Heroi heroi, int vitorias) {
        System.out.println("-----------------------------------");
        System.out.println("     🏆 DUNGEON COMPLETA! 🏆      ");
        System.out.println("-----------------------------------");
        System.out.println(" Parabéns, " + heroi.getNome());
        System.out.println(" Vitorias: " + vitorias);
        System.out.println(" XP: " + heroi.getXp());

    }
}
