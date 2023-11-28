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

    public class TarefasCompletas {
        private List<String> tarefasConcluidas;

        public TarefasCompletas() {
            this.tarefasConcluidas = new ArrayList<>();
        }

        public void concluirTarefa(String tarefa) {
            if (tarefas.contains(tarefa)) {
                tarefas.remove(tarefa);
                tarefasConcluidas.add(tarefa);
                System.out.println(nomeMembro + " concluiu a seguinte tarefa:");
                System.out.println("- " + tarefa);
            } else {
                System.out.println(nomeMembro + " tentou concluir uma tarefa inexistente: " + tarefa);
            }
        }

        public List<String> getTarefasConcluidas() {
            return tarefasConcluidas;
        }

        public List<String> tarefasConcluidasPorMembro(List<String> tarefasDoMembro) {
            List<String> tarefasConcluidas = new ArrayList<>();
            for (String tarefa : tarefasDoMembro) {
                // Simulando que uma tarefa é considerada concluída se contiver a palavra "Concluída"
                if (tarefa.contains("Concluída")) {
                    tarefasConcluidas.add(tarefa);
                }
            }
            return tarefasConcluidas;
        }

        public List<String> tarefasPendentes(List<String> todasTarefas, List<String> tarefasConcluidas) {
            List<String> tarefasPendentes = new ArrayList<>(todasTarefas);
            tarefasPendentes.removeAll(tarefasConcluidas);
            return tarefasPendentes;
        }
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
        guilherme.enviarTarefa("Elias", "Revisar código");
        alex.listarTarefas();

        GerenciadorTarefas.TarefasCompletas tarefasCompletasGuilherme = guilherme.new TarefasCompletas();

        guilherme.adicionarTarefa("Terminar o seminário");
        guilherme.listarTarefas();

        tarefasCompletasGuilherme.concluirTarefa("Concluir projeto Java e estudar");

        guilherme.listarTarefas();

        List<String> tarefasConcluidasPorGuilherme = tarefasCompletasGuilherme.getTarefasConcluidas();
        System.out.println("Tarefas concluídas por Guilherme: " + tarefasConcluidasPorGuilherme);

        List<String> tarefasPendentesGuilherme = tarefasCompletasGuilherme.tarefasPendentes(guilherme.tarefas, tarefasConcluidasPorGuilherme);
        System.out.println("Tarefas pendentes para Guilherme: " + tarefasPendentesGuilherme);
    }
}


