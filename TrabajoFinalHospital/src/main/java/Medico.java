public class Medico extends Persona{

    private String especialidad;
    private String fecha_grado;
    private int horas_trabajadas;

    public Medico(String identificacion, String nombre, String apellido, int edad, String direccion, String telefono, String genero, String especialidad, String fecha_grado, int horas_trabajadas) {
        super(identificacion, nombre, apellido, edad, direccion, telefono, genero);
        this.especialidad = especialidad;
        this.fecha_grado = fecha_grado;
        this.horas_trabajadas = horas_trabajadas;

    }   

    public String getEspecialidad(){
        return especialidad;
    }

    public String getFechagrado(){
        return fecha_grado;
    }

    public int getHorastrabajadas(){
        return horas_trabajadas;
    }

}