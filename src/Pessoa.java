import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String name;
    private LocalDate birthData;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa(String name, LocalDate birthData) {
        this.name = name;
        this.birthData = birthData;
    }

    //construtor que receberá string
    public Pessoa(String name, String birthDateString){
        this.name = name;
        this.birthData = parseDate(birthDateString) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthData() {
        return birthData;
    }

    public void setBirthData(LocalDate birthData) {
        this.birthData = birthData;
    }

    public void setBirthData(String birthDateString){
        this.birthData = parseDate(birthDateString);
    }

    private LocalDate parseDate(String dateStr){
        try {
        return LocalDate.parse(dateStr, formatter);
        }
        catch(DateTimeException e){
            throw new IllegalArgumentException("Formato Inválido");
        }
    }

    public String getBirthDataAsString(){
        return this.birthData.format(formatter);
    }
}
