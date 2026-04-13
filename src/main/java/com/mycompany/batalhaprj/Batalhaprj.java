/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.batalhaprj;

import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class Batalhaprj {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BATALHA ENTRE PERSONAGENS ===");

        System.out.println("Digite o nome do seu personagem:");
        String nomeJogador = scanner.nextLine();

        System.out.println("Escolha a classe do seu personagem:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");
        int opcaoClasse = scanner.nextInt();
        scanner.nextLine();

        ClasseEnum classeJogador = null;

        switch (opcaoClasse) {
            case 1:
                classeJogador = ClasseEnum.GUERREIRO;
                break;
            case 2:
                classeJogador = ClasseEnum.MAGO;
                break;
            case 3:
                classeJogador = ClasseEnum.ARQUEIRO;
                break;
            default:
                classeJogador = ClasseEnum.GUERREIRO;
                break;
        }

        MascoteEnum mascoteJogador = null;

        System.out.println("Escolha o mascote do seu personagem:");

        if (classeJogador == ClasseEnum.GUERREIRO) {
            System.out.println("1 - Lobo");
            System.out.println("2 - Urso");
            System.out.println("3 - Leão");

            int opcaoMascote = scanner.nextInt();
            scanner.nextLine();

            if (opcaoMascote == 1) {
                mascoteJogador = MascoteEnum.LOBO;
            } else if (opcaoMascote == 2) {
                mascoteJogador = MascoteEnum.URSO;
            } else {
                mascoteJogador = MascoteEnum.LEAO;
            }
        } else if (classeJogador == ClasseEnum.MAGO) {
            System.out.println("1 - Fada");
            System.out.println("2 - Esqueleto");
            System.out.println("3 - Zumbi");
            System.out.println("4 - Coruja");

            int opcaoMascote = scanner.nextInt();
            scanner.nextLine();

            if (opcaoMascote == 1) {
                mascoteJogador = MascoteEnum.FADA;
            } else if (opcaoMascote == 2) {
                mascoteJogador = MascoteEnum.ESQUELETO;
            } else if (opcaoMascote == 3) {
                mascoteJogador = MascoteEnum.ZUMBI;
            } else {
                mascoteJogador = MascoteEnum.CORUJA;
            }
        } else {
            System.out.println("1 - Águia");
            System.out.println("2 - Raposa");
            System.out.println("3 - Cachorro");

            int opcaoMascote = scanner.nextInt();
            scanner.nextLine();

            if (opcaoMascote == 1) {
                mascoteJogador = MascoteEnum.AGUIA;
            } else if (opcaoMascote == 2) {
                mascoteJogador = MascoteEnum.RAPOSA;
            } else {
                mascoteJogador = MascoteEnum.CACHORRO;
            }
        }

        Personagem jogador = new Personagem();
        jogador.setNome(nomeJogador);
        jogador.setClasse(classeJogador);
        jogador.setMascote(mascoteJogador);
        jogador.setNivel(1);

        if (classeJogador == ClasseEnum.GUERREIRO) {
            jogador.setVida(120);
            jogador.setForca(20);
            jogador.setDefesa(10);
        } else if (classeJogador == ClasseEnum.MAGO) {
            jogador.setVida(90);
            jogador.setForca(25);
            jogador.setDefesa(5);
        } else {
            jogador.setVida(100);
            jogador.setForca(18);
            jogador.setDefesa(8);
        }

        Personagem inimigo = new Personagem();
        inimigo.setNome("Inimigo");
        inimigo.setNivel(1);

        int numeroClasse = (int) (Math.random() * 3) + 1;

        switch (numeroClasse) {
            case 1:
                inimigo.setClasse(ClasseEnum.GUERREIRO);
                inimigo.setVida(120);
                inimigo.setForca(20);
                inimigo.setDefesa(10);

                int mascoteGuerreiro = (int) (Math.random() * 3) + 1;
                if (mascoteGuerreiro == 1) {
                    inimigo.setMascote(MascoteEnum.LOBO);
                } else if (mascoteGuerreiro == 2) {
                    inimigo.setMascote(MascoteEnum.URSO);
                } else {
                    inimigo.setMascote(MascoteEnum.LEAO);
                }
                break;

            case 2:
                inimigo.setClasse(ClasseEnum.MAGO);
                inimigo.setVida(90);
                inimigo.setForca(25);
                inimigo.setDefesa(5);

                int mascoteMago = (int) (Math.random() * 4) + 1;
                if (mascoteMago == 1) {
                    inimigo.setMascote(MascoteEnum.FADA);
                } else if (mascoteMago == 2) {
                    inimigo.setMascote(MascoteEnum.ESQUELETO);
                } else if (mascoteMago == 3) {
                    inimigo.setMascote(MascoteEnum.ZUMBI);
                } else {
                    inimigo.setMascote(MascoteEnum.CORUJA);
                }
                break;

            default:
                inimigo.setClasse(ClasseEnum.ARQUEIRO);
                inimigo.setVida(100);
                inimigo.setForca(18);
                inimigo.setDefesa(8);

                int mascoteArqueiro = (int) (Math.random() * 3) + 1;
                if (mascoteArqueiro == 1) {
                    inimigo.setMascote(MascoteEnum.AGUIA);
                } else if (mascoteArqueiro == 2) {
                    inimigo.setMascote(MascoteEnum.RAPOSA);
                } else {
                    inimigo.setMascote(MascoteEnum.CACHORRO);
                }
                break;
        }

        System.out.println();
        System.out.println("=== PERSONAGEM DO JOGADOR ===");
        System.out.println(jogador.toString());

        System.out.println();
        System.out.println("=== PERSONAGEM INIMIGO ===");
        System.out.println(inimigo.toString());

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.println();
            System.out.println("Sua vez:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Usar ajuda do mascote");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println(jogador.atacar(inimigo));
            } else if (opcao == 2) {
                System.out.println(jogador.defender());
            } else if (opcao == 3) {
                System.out.println(jogador.usarMascote());
            } else {
                System.out.println("Opção inválida.");
            }

            if (!inimigo.estaVivo()) {
                break;
            }

            System.out.println();
            System.out.println("Turno do inimigo:");

            int jogadaInimigo = (int) (Math.random() * 10) + 1;

            if (jogadaInimigo <= 7) {
                System.out.println(inimigo.atacar(jogador));
            } else if (jogadaInimigo <= 9) {
                System.out.println(inimigo.defender());
            } else {
                System.out.println(inimigo.usarMascote());
            }

            System.out.println();
            System.out.println("Vida atual de " + jogador.getNome() + ": " + jogador.getVida());
            System.out.println("Vida atual de " + inimigo.getNome() + ": " + inimigo.getVida());
        }

        System.out.println();
        System.out.println("=== RESULTADO FINAL ===");

        if (jogador.estaVivo()) {
            System.out.println(jogador.getNome() + " venceu a batalha!");
        } else {
            System.out.println(inimigo.getNome() + " venceu a batalha!");
        }

    }
}