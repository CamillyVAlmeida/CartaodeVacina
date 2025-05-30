package CartaoDeVacina;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GerenciadorDeVacina {

    public static boolean validarCPF(String cpf) {
       
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        return Pattern.matches(regex, cpf);
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opMenu;
        Scanner scanner = new Scanner(System.in);
        int identificador01;
        int identificador02;
        boolean vacinado = false;
        boolean valido;
        int vacinadoController = 1;
        int idVacina = 1; // ID da vacina começando em 1

        int[][] vacinasTomadasNoDia = new int[101][100]; 

        int[] idPacientes = new int[101]; //<-- id do paciente
        String[] nomesPacientes = new String[101];
        String[] DataDeNascimento = new String[101]; 
        String[] cpfPacientes = new String[101];
        LocalDate[][] datasDeVacinacao = new LocalDate[101][100];

        ArrayList<String> nomeVacina = new ArrayList<>();
        nomeVacina.add("TETANO(DOSE 1)    | Fab:BUTANTAN      |LOTE: 4879  | PRÓXIMA DOSE: 30 dias após a aplicação.     |");
        nomeVacina.add("COVID-19(DOSE 1)  | Fab:Pfizer        |LOTE: 5597  | PRÓXIMA DOSE: 06 meses após a aplicação.    |");
        nomeVacina.add("COVID-19(DOSE 2)  | Fab:Pfizer        |LOTE: 5598  | PRÓXIMA DOSE: 06 meses após a aplicação.    |");
        nomeVacina.add("COVID-19(DOSE 3)  | Fab:AstraZeneca   |LOTE: 5599  | PRÓXIMA DOSE: 06 meses após a aplicação.    |");
        nomeVacina.add("HEPATITE-B(DOSE 1)| Fab:BUTANTAN      |LOTE: 32b5  | PRÓXIMA DOSE: 30 dias após a aplicação.     |");
        nomeVacina.add("INFLUENZA         | Fab:BUTANTAN      |LOTE: YMUV  | PRÓXIMA DOSE: anual.                        |");
        nomeVacina.add("DENGVAXIA         | Fab:Sanofi Pasteur|LOTE: 20241 | PRÓXIMA DOSE: 90 dias após a aplicação.     |");
        nomeVacina.add("FEBRE AMARELA     | Fab:Fiocruz       |LOTE: 2234M | PRÓXIMA DOSE: A cada 10 anos.               |");

        int numPacientes = 0;

        do {
            System.out.println(" ----------------------------------------");
            System.out.println("| Escolha uma opção:                     |");
            System.out.println("| 1 - Cadastrar Novo Paciente            |");
            System.out.println("| 2 - Aplicar Vacina                     |");
            System.out.println("| 3 - Listar Todas as Vacinas Disponiveis|");
            System.out.println("| 4 - Atualizar Cadastro                 |");
            System.out.println("| 5 - Apresentar Cartao de Vacina        |");
            System.out.println("| 6 - Sair                               |");
            System.out.println(" ----------------------------------------");

            opMenu = scanner.nextInt();

            switch (opMenu) {
                case 1:
                    numPacientes++;
                    idPacientes[numPacientes] = numPacientes;
                    System.out.println("Digite o nome do paciente:");
                    scanner.nextLine();
                    nomesPacientes[numPacientes] = scanner.nextLine();
                    
                    System.out.println("Digite a data de nascimento (DD/MM/AAAA):");
                    DataDeNascimento[numPacientes] = scanner.nextLine(); 
                    
                    
                    do {
                        System.out.println("Digite o CPF (000.000.000-00): ");
                        cpfPacientes[numPacientes] = scanner.nextLine();
                        if (!validarCPF(cpfPacientes[numPacientes])) {
                            System.out.println("CPF inválido. Por favor, digite novamente.");
                        }
                    } while (!validarCPF(cpfPacientes[numPacientes]));
                    
                    System.out.println("Paciente cadastrado com sucesso. ID do paciente: " + numPacientes);
                    System.out.println("Data de nascimento do paciente: " + DataDeNascimento[numPacientes]);
                    System.out.println("CPF do paciente: " + cpfPacientes[numPacientes]);
                    break;

                case 2:
                    System.out.println("Aplicação de Vacina em andamento:");
                    System.out.println("Informe o ID do paciente a ser vacinado");
                    identificador01 = scanner.nextInt();
                    vacinado = true;
                    do {
                        System.out.println("Informe o ID da vacina a ser aplicada:");
                        System.out.println("Vacinas disponíveis:");
                        for (int i = 1; i <= nomeVacina.size(); i++) {
                            System.out.println(i + " - " + nomeVacina.get(i - 1)); 
                        }
                        System.out.println(nomeVacina.size() + 1 + " - Adicionar nova vacina"); // calculo do proximo id
                        identificador02 = scanner.nextInt();
                        if (identificador02 == nomeVacina.size() + 1) { 
                            System.out.println("Digite o nome da nova vacina:");
                            scanner.nextLine();
                            String novaVacina = scanner.nextLine();
                            nomeVacina.add(novaVacina);
                        } else if (identificador02 <= nomeVacina.size() && identificador02 >= 1) { 
                            vacinasTomadasNoDia[identificador01][vacinadoController] = identificador02; 
                            
                           
                            System.out.println("Digite a data de vacinação (DD/MM/AAAA):");
                            String dataVacinacao = scanner.next();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            datasDeVacinacao[identificador01][vacinadoController] = LocalDate.parse(dataVacinacao, formatter);
                            
                            while (true) {
                                System.out.println("Adicionar outra vacina ao usuário? (1 - sim / 2 - não)");
                                int escolha = scanner.nextInt();
                                if (escolha == 1) {
                                    vacinadoController++;
                                    break;
                                } else if (escolha == 2) {
                                    vacinado = false;
                                    break;
                                } else {
                                    System.out.println("Opção inválida. Por favor, escolha 1 (sim) ou 2 (não).");
                                }
                            }
                        } else {
                            System.out.println("Opção inválida. Por favor, escolha um número válido.");
                        }
                    } while (vacinado);
                    break;
                                
                case 3:
                    System.out.println("Vacinas disponíveis:");
                    for (int i = 1; i <= nomeVacina.size(); i++) {
                        System.out.println(i + " - " + nomeVacina.get(i - 1));
                    }
                    System.out.println(nomeVacina.size() + 1 + " - Adicionar nova vacina");
                    int escolha = scanner.nextInt();
                    if (escolha == nomeVacina.size() + 1) { 
                        System.out.println("Digite o nome da nova vacina:");
                        scanner.nextLine();
                        String novaVacina = scanner.nextLine();
                        nomeVacina.add(novaVacina);
                        System.out.println("Vacina \"" + novaVacina + "\" cadastrada com sucesso!");
                    }
                    break;
               
                case 4: 
                    System.out.println("Atualizar cadastro:");
                    System.out.println("Informe o id do paciente que deseja atualizar:");
                    identificador01 = scanner.nextInt();
                    
                    
                    if (identificador01 >= 1 && identificador01 <= numPacientes) {
                        System.out.println("Escolha o que deseja atualizar:");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Data de Nascimento");
                        System.out.println("3 - CPF");
                        int opcaoAtualizacao = scanner.nextInt();
                        
                        switch (opcaoAtualizacao) {
                            case 1:
                                System.out.println("Informe o novo nome do paciente:");
                                scanner.nextLine(); 
                                nomesPacientes[identificador01] = scanner.nextLine();
                                System.out.println("Nome do paciente atualizado com sucesso.");
                                break;
                            case 2:
                                System.out.println("Informe a nova data de nascimento do paciente (DD/MM/AAAA):");
                                scanner.nextLine(); 
                                DataDeNascimento[identificador01] = scanner.nextLine();
                                System.out.println("Data de nascimento do paciente atualizada com sucesso.");
                                break;
                            case 3:
                                System.out.println("Informe o novo CPF do paciente:");
                                scanner.nextLine();
                                cpfPacientes[identificador01] = scanner.nextLine();
                                System.out.println("CPF do paciente atualizado com sucesso.");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } else {
                        System.out.println("ID do paciente inválido.");
                    }
                    break;                

                case 5:
                    System.out.println("Apresentar cartao de vacina:");
                    for (int i = 1; i <= numPacientes; i++) {
                        System.out.println("Paciente ID: " + idPacientes[i]);
                        System.out.println("Nome: " + nomesPacientes[i]);
                        System.out.println("Data de nascimento: " + DataDeNascimento[i]);
                        System.out.println("CPF: " + cpfPacientes[i]);
                        System.out.println("Vacinas tomadas:");
                        for (int j = 1; j <= vacinadoController; j++) {
                            if (vacinasTomadasNoDia[i][j] != 0) {
                                System.out.println("- " + nomeVacina.get(vacinasTomadasNoDia[i][j] - 1) + " em " + datasDeVacinacao[i][j].format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            }
                        }
                        System.out.println();
                    }
                    break;

            

                case 6:
                    System.out.println("OBRIGADA POR CADASTRAR SUAS VACINAS! FIQUE ATENTO AS PRÓXIMAS DOSES E ESTEJA IMUNIZADO :)");
                    continuar = false;
                    break;
            }
        } while (continuar);

        scanner.close();
    }
}
