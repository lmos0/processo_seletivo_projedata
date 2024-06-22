import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Funcionario> funcionarios = new ArrayList<>();

        // ############# Convertendo os salários para BigDecimal
        BigDecimal salary1 = BigDecimal.valueOf(2009.44);
        BigDecimal salary2 = BigDecimal.valueOf(2284.38);
        BigDecimal salary3 = BigDecimal.valueOf(9836.14);
        BigDecimal salary4 = BigDecimal.valueOf(19119.88);
        BigDecimal salary5 = BigDecimal.valueOf(2234.68);
        BigDecimal salary6 = BigDecimal.valueOf(1582.72);
        BigDecimal salary7 = BigDecimal.valueOf(4071.84);
        BigDecimal salary8 = BigDecimal.valueOf(3017.45);
        BigDecimal salary9 = BigDecimal.valueOf(1606.85);
        BigDecimal salary10= BigDecimal.valueOf(2799.93);

        // ############## Instanciando os objetos

        Funcionario func1 = new Funcionario("Maria", "18/10/2000", salary1, "Operador");
        Funcionario func2 = new Funcionario("João", "12/05/1990", salary2, "Operador");
        Funcionario func3 = new Funcionario("Caio", "02/05/1961", salary3, "Coordenador");
        Funcionario func4 = new Funcionario("Miguel", "14/10/1988", salary4, "Diretor");
        Funcionario func5 = new Funcionario("Alice", "05/01/1995", salary5, "Recepcionista" );
        Funcionario func6 = new Funcionario("Heitor", "19/11/1999", salary6,"Operador");
        Funcionario func7 = new Funcionario("Arthur", "31/03/1993", salary7, "Contador");
        Funcionario func8 = new Funcionario("Laura", "08/07/1994", salary8, "Gerente");
        Funcionario func9 = new Funcionario("Heloísa", "24/05/2003", salary9, "Eletricista");
        Funcionario func10 = new Funcionario( "Helena", "02/09/1996", salary10, "Gerente");

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima. ############

        insertFuncionario(funcionarios, func1);
        insertFuncionario(funcionarios, func2);
        insertFuncionario(funcionarios, func3);
        insertFuncionario(funcionarios, func4);
        insertFuncionario(funcionarios, func5);
        insertFuncionario(funcionarios, func6);
        insertFuncionario(funcionarios, func7);
        insertFuncionario(funcionarios, func8);
        insertFuncionario(funcionarios, func9);
        insertFuncionario(funcionarios, func10);

        // 3.2 – Remover o funcionário “João” da lista.
        removeFuncionario(funcionarios, func2);

        // 3.3 – Imprimir todos os funcionários com todas suas informações
        showFuncionarios(funcionarios);

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        updateSalary(funcionarios);

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosByRole = groupFuncionariosByRole(funcionarios);

        // 3.6 – Imprimir os funcionários, agrupados por função.
        showFuncionariobyRole(funcionariosByRole);

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        showFuncionariosBornInOctoberAndDecember(funcionarios);

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        showFuncionariosByAge(funcionarios);

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        showFuncionariosAlphabetically(funcionarios);

        //3.11 – Imprimir o total dos salários dos funcionários.
        showTotalSalaries(funcionarios);

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        showMinimumWage(funcionarios);


    }
        public static void insertFuncionario (List < Funcionario > funcionarios, Funcionario funcionario){
            funcionarios.add(funcionario);

        }

        public static void showFuncionarios(List<Funcionario> funcionarios) {
        Locale localeBrazil = Locale.of("pt", "BR");

        for (Funcionario func: funcionarios) {
            System.out.printf(localeBrazil, "Funcionário: Nome='%s', Data de Nascimento='%s', Salário R$=%,.2f, Função='%s'%n",
                    func.getName(), func.getBirthDataAsString(), func.getSalary(), func.getRole());
        }
        }


        public static void removeFuncionario(List<Funcionario> funcionarios, Funcionario funcionario){
        funcionarios.remove(funcionario);
        }

        public static void updateSalary(List<Funcionario> funcionarios){
        for (Funcionario func: funcionarios){
            BigDecimal currentSalary = func.getSalary();
            BigDecimal newSalary = currentSalary.multiply(BigDecimal.valueOf(1.10));
            func.setSalary(newSalary);
        }
        System.out.println("############ Reajuste salarial de 10% concedido. ###############");
        }

        public static Map<String, List<Funcionario>> groupFuncionariosByRole(List<Funcionario> funcionarios){
        Map<String, List<Funcionario>> map = new HashMap<>();
        for (Funcionario func: funcionarios){
            map.computeIfAbsent(func.getRole(), k -> new ArrayList<>()).add(func);
        }
        return  map;
        }

        public static void showFuncionariobyRole(Map<String,List<Funcionario>> funcioriosByRole){
        Locale localeBrazil = Locale.of("pt", "BR");
        System.out.println("Funcionários agrupados por cargos: ");
        for (Map.Entry<String, List<Funcionario>> entry:funcioriosByRole.entrySet()) {
            System.out.printf(localeBrazil,"Cargo: %s%n" , entry.getKey());
            for (Funcionario func: entry.getValue()){
                System.out.printf(localeBrazil, "Funcionário: Nome='%s', Data de Nascimento='%s', Salário R$=%,.2f, Função='%s'%n",
                        func.getName(), func.getBirthDataAsString(), func.getSalary(), func.getRole());
        }
        }
        }

        public static void showFuncionariosBornInOctoberAndDecember(List<Funcionario> funcionarios){
        for (Funcionario func: funcionarios){
            int birthMonth = func.getBirthData().getMonthValue();
            if(birthMonth == 10 || birthMonth == 12){
                System.out.println("Funcionários que fazem aniversário em outubro ou em dezembro: " + func.getName() + " " +  func.getBirthDataAsString());

            }
        }
        }

        public static void showFuncionariosByAge(List<Funcionario> funcionarios){

        Funcionario oldest = funcionarios.getFirst();
        for(Funcionario func : funcionarios){
            if(func.getBirthData().isBefore(oldest.getBirthData())){
                oldest = func;
            }


        }
            int age = Period.between(oldest.getBirthData(), LocalDate.now()).getYears();
            System.out.println("O Funcionário mais velho é " +oldest.getName() + ". Idade: " + age);
        }

        public static void showFuncionariosAlphabetically(List<Funcionario> funcionarios){
            Locale localeBrazil = Locale.of("pt", "BR");
            funcionarios.sort(Comparator.comparing(Funcionario::getName));


            System.out.println("Funcionários registrados em ordem alfabética:");
            for(Funcionario func: funcionarios){
                System.out.printf(localeBrazil, "Funcionário: Nome='%s', Data de Nascimento='%s', Salário R$=%,.2f, Função='%s'%n",
                        func.getName(), func.getBirthDataAsString(), func.getSalary(), func.getRole());
            }
            }

        public static void showTotalSalaries(List<Funcionario> funcionarios){
        BigDecimal totalSalaries = BigDecimal.ZERO;
        for(Funcionario func : funcionarios){
            totalSalaries = totalSalaries.add(func.getSalary());
        }
        System.out.printf("Total dos salários dos funcionários: %,.2f%n",  totalSalaries);
        }

    public static void showMinimumWage(List<Funcionario> funcionarios){
        System.out.println("Salários Mínimos: ");
        BigDecimal minimumWage = BigDecimal.valueOf(1212);
        for(Funcionario func : funcionarios){
            BigDecimal ratio = func.getSalary().divide(minimumWage,2, BigDecimal.ROUND_HALF_UP);
            System.out.printf("%s recebe %.2f salários mínimos.%n", func.getName(), ratio);
        }
    }



}



