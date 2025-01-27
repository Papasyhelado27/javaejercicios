public class Persona {
    private String identificacion;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String telefono;
    private String genero;


    public Persona(String identificacion, String nombre, String apellido, int edad, String direccion, String telefono, String genero) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getGenero() {
        return genero;
    }
}


