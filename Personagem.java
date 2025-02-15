public class Personagem {
    private String nome;
    private int bonus;

    public Personagem(String nome, int bonus) {
        this.nome = nome;
        this.bonus = bonus;
    }

    public int calcularIniciativa(int dado) {
        return dado + this.bonus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Personagem: " + nome + ", Bônus: " + bonus;
    }
}