import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<String> tarefas;
    private String nomeMembro;

    public GerenciadorTarefas(String nomeMembro) {
        this.tarefas = new ArrayList<>();
        this.nomeMembro = nomeMembro;
    }

    public void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
    }

    public void listarTarefas() {
        System.out.println("Tarefas de " + nomeMembro + ":");
        for (String tarefa : tarefas) {
            System.out.println("- " + tarefa);
        }
    }

    public void enviarTarefa(String destinatario, String tarefa) {
        System.out.println(nomeMembro + " enviou a seguinte tarefa para " + destinatario + ":");
        System.out.println("- " + tarefa);
    }

    public static void main(String[] args) {
        GerenciadorTarefas guilherme = new GerenciadorTarefas("Guilherme");
        GerenciadorTarefas alex = new GerenciadorTarefas("Alex");
        GerenciadorTarefas elias = new GerenciadorTarefas("Elias");

        guilherme.adicionarTarefa("Concluir projeto Java e estudar");
        alex.adicionarTarefa("Estudar para prova de Java");
        elias.adicionarTarefa("Estudar");

        guilherme.listarTarefas();
        alex.listarTarefas();
        elias.listarTarefas();

        guilherme.enviarTarefa("Alex", "Revisar código");
        alex.listarTarefas();
    }
}

