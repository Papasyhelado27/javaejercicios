class nodo {

    String dato;
    int lvl;
    String atributo;
    int cant;
    nodo enlace;

    public nodo() {
       
    }

    public nodo(String dato, int lvl, String atributo, int cant) {
        this.dato = dato;
        this.lvl = lvl;
        this.atributo = atributo;
        this.cant = cant;
        this.enlace = null;
    }
}