import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        List<Funcionario> funcionarios = new ArrayList<>();

        BigDecimal salary1 = BigDecimal.valueOf(2009.44);
        BigDecimal salary2 = BigDecimal.valueOf(2284.38);

        Funcionario func1 = new Funcionario("Maria", "18/10/2000", salary1, "Operador");
        Funcionario func2 = new Funcionario("João", "12/05/1990", salary2, "Operador");

        insertFuncionario(funcionarios, func1);
        insertFuncionario(funcionarios, func2);

        showFuncionarios(funcionarios);
    }
        public static void insertFuncionario (List < Funcionario > funcionarios, Funcionario funcionario){
            funcionarios.add(funcionario);
        }

        public static void showFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario func: funcionarios) {
        System.out.println(funcionarios);
        }
        }
    }
