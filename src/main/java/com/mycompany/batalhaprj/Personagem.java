package com.mycompany.batalhaprj;

public class Personagem {

    private String nome;
    private int vida;
    private int forca;
    private int defesa;
    private int nivel;
    private ClasseEnum classe;
    private MascoteEnum mascote;
    private boolean defendendo;

    public Personagem() {
    }

    public Personagem(String nome, int vida, int forca, int defesa, int nivel,
            ClasseEnum classe, MascoteEnum mascote) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.nivel = nivel;
        this.classe = classe;
        this.setMascote(mascote);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ClasseEnum getClasse() {
        return classe;
    }

    public void setClasse(ClasseEnum classe) {
        this.classe = classe;
    }

    public MascoteEnum getMascote() {
        return mascote;
    }

    public void setMascote(MascoteEnum mascote) { //switchcase nao colaborou perdao
        if (this.classe == ClasseEnum.GUERREIRO) {
            if (mascote == MascoteEnum.LOBO
                    || mascote == MascoteEnum.URSO
                    || mascote == MascoteEnum.LEAO) {
                this.mascote = mascote;
            }
        } else if (this.classe == ClasseEnum.MAGO) {
            if (mascote == MascoteEnum.FADA
                    || mascote == MascoteEnum.ESQUELETO
                    || mascote == MascoteEnum.ZUMBI
                    || mascote == MascoteEnum.CORUJA) {
                this.mascote = mascote;
            }
        } else if (this.classe == ClasseEnum.ARQUEIRO) {
            if (mascote == MascoteEnum.AGUIA
                    || mascote == MascoteEnum.RAPOSA
                    || mascote == MascoteEnum.CACHORRO) {
                this.mascote = mascote;
            }
        }
    }

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }

    public boolean estaVivo() {
        if (vida > 0) {
            return true;
        }
        return false;
    }

    public String atacar(Personagem outroPersonagem) {
        int dano = this.forca - outroPersonagem.getDefesa();

        if (outroPersonagem.isDefendendo()) {
            dano = dano - 5;
        }

        if (dano < 1) {
            dano = 1;
        }

        outroPersonagem.setVida(outroPersonagem.getVida() - dano);
        outroPersonagem.setDefendendo(false);

        if (outroPersonagem.getVida() < 0) {
            outroPersonagem.setVida(0);
        }

        return this.nome + " atacou " + outroPersonagem.getNome()
                + " e causou " + dano + " de dano.";
    }

    public String defender() {
        this.defendendo = true;
        return this.nome + " está se defendendo.";
    }

    public String usarMascote() {
        if (mascote == MascoteEnum.FADA
                || mascote == MascoteEnum.CORUJA
                || mascote == MascoteEnum.AGUIA) {
            this.vida = this.vida + 10;
            return mascote.getDescricao() + " ajudou " + nome
                    + " com uma poção. Vida atual: " + vida;
        } else if (mascote == MascoteEnum.LEAO
                || mascote == MascoteEnum.ESQUELETO
                || mascote == MascoteEnum.RAPOSA) {
            this.forca = this.forca + 5;
            return mascote.getDescricao() + " ajudou " + nome
                    + " no ataque. Força atual: " + forca;
        } else {
            this.defesa = this.defesa + 5;
            return mascote.getDescricao() + " ajudou " + nome
                    + " na defesa. Defesa atual: " + defesa;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + " | Vida: " + vida
                + " | Força: " + forca
                + " | Defesa: " + defesa
                + " | Nível: " + nivel
                + " | Classe: " + classe
                + " | Mascote: " + mascote.getDescricao();
    }
}