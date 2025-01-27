import com.mycompany.guia.Persona;
import java.time.LocalDate;
import java.time.Period;

public class Medico extends Persona {
    private int edad;
    private char sexo;
    private String especialidad;
    private LocalDate fechaTitulo;
    private int horasTrabajadas;

    public Medico(String identificacion, String nombre, String apellido, String direccion, String telefono,
                  int edad, char sexo, String especialidad, LocalDate fechaTitulo, int horasTrabajadas) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.edad = edad;
        this.sexo = sexo;
        this.especialidad = especialidad;
        this.fechaTitulo = fechaTitulo;
        this.horasTrabajadas = horasTrabajadas;
    }

    // Getters
    public String getEspecialidad() {
        return especialidad;
    }

    public char getSexo() {
        return sexo;
    }

    public int calcularExperiencia() {
        return Period.between(fechaTitulo, LocalDate.now()).getYears();
    }

    public double calcularSalario(double valorHora) {
        return horasTrabajadas * valorHora;
    }
}