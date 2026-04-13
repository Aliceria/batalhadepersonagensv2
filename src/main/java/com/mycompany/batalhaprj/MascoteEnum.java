package com.mycompany.batalhaprj;

public enum MascoteEnum {

    LOBO("Lobo"),
    URSO("Urso"),
    LEAO("Leão"),

    FADA("Fada"),
    ESQUELETO("Esqueleto"),
    ZUMBI("Zumbi"),
    CORUJA("Coruja"),

    AGUIA("Águia"),
    RAPOSA("Raposa"),
    CACHORRO("Cachorro");

    private String descricao;

    MascoteEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}