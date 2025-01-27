import javax.swing.JOptionPane;


class bolsa {

    public nodo inicio;

    public bolsa() {
        inicio = null;
    }
    public bolsa insertarcabeza(String a,int b,String c, int d) {
        nodo nuevo = new nodo(a,b,c,d);
        nuevo.enlace = inicio;
        inicio = nuevo;
        return this;
    }
    public void visualizar() {
        nodo actual;
        actual = inicio;
        while (actual != null) {
            System.out.print(" " + actual.dato + " ");
            actual = actual.enlace;
        }
    } 
    public void add(nodo newNodo){
        //puntero temporal para recorreme en la lista
        nodo tmp = inicio;

        //si la lista esta vacia
        if(tmp==null){
            //lo agregamos al root
            inicio = newNodo;
        }else{
            //de lo contrario nos recorremos hasta el ultimo
            while(tmp.enlace!=null)
                tmp = tmp.enlace;
            //en el ultimo hacemos el enlace 
            tmp.enlace = newNodo;
        }
        
    }

    public bolsa insertar(String a,int b,String c,int d, nodo j) {
        nodo nuevo = new nodo(a,b,c,d);
        nuevo.enlace = j.enlace;
        j.enlace = nuevo;
        return this;

    }
    public nodo buscar(int dat) {
        nodo j;
        try {
            for (j = inicio; j != null; j = j.enlace) {
                if (dat == j.dato) {
                    return j;
                } else {
                    JOptionPane.showMessageDialog(null, "el dato buscado no esta en la lista");
                }
            }
        }
        catch (Exception e) {
        }
        return null;
    }
}

