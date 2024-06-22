import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private BigDecimal salary;
    private String role;

    public Funcionario(String name, String birthDataString, BigDecimal salary, String role) {
        super(name, birthDataString);
        this.salary = salary;
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "Funcionario: " +
                "Nome='" + getName() + '\'' +
                ", Data de Nascimento='" + getBirthDataAsString() + '\'' +
                ", Salário=" + salary +
                ", Função='" + role + '\'';
    }
}
