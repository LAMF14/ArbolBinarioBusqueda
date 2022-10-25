public class ArbolBinario {
    Nodo raiz;
    public ArbolBinario() {
        raiz = null;
    }
    public void Insertar(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            Nodo padre;
            while (true) {
                padre = aux;
                if (dato.compareTo(aux.dato) < 0) {
                    aux = aux.HijoIzq;
                    if (aux == null) {
                        padre.HijoIzq = nuevo;
                        return;
                    }
                } else {
                    aux = aux.HijoDer;
                    if (aux == null) {
                        padre.HijoDer = nuevo;
                        return;
                    }
                }
            }
        }
    }
    public boolean Eliminar(String dato){
        Nodo aux2;
        Nodo aux = RecorridoDeEliminacion(dato);
        if(RecorridoDeEliminacion(dato)!=null){
            if(aux.HijoIzq==null && aux.HijoDer==null){
                aux = null;
            }else{
                if(aux.HijoIzq != null && aux.HijoDer != null){
                    if(aux == raiz){
                        aux2 = aux.HijoIzq;
                        aux = aux.HijoDer;
                        while(aux.HijoIzq != null){
                            aux = aux.HijoIzq;
                        }
                        aux.HijoIzq = aux2;
                    }else{
                        if(aux == raiz){
                            if(aux.HijoIzq != null){
                                aux = aux.HijoIzq;
                            }else{
                                aux = aux.HijoDer;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
    private Nodo RecorridoDeBusqueda(String nombre){
        long inicio = System.nanoTime();
        Nodo a = raiz;
        int numeroDeComparaciones=0;
        while(a != null){
            if(a.dato.equals(nombre)){
                long fin = System.nanoTime();
                System.out.println("\nTiempo de Ejecucion: " + (fin-inicio)/1e6 + " ms.");
                System.out.println("Numero de Comparaciones: " + numeroDeComparaciones);
                return a;
            }
            if(nombre.compareToIgnoreCase(a.dato) < 0){
                a = a.HijoIzq;
            }else{
                a = a.HijoDer;
            }
            numeroDeComparaciones++;
        }
        long fin = System.nanoTime();
        System.out.println("\nTiempo de Ejecucion: " + (fin-inicio)/1e6 + " ms.");
        System.out.println("Numero de Comparaciones: " + numeroDeComparaciones);
        return null;
    }

    private Nodo RecorridoDeEliminacion(String nombre){
        Nodo a = raiz;
        while(a != null){
            if(a.dato.equals(nombre)){
                return a;
            }
            if(nombre.compareToIgnoreCase(a.dato) < 0){
                a = a.HijoIzq;
            }else{
                a = a.HijoDer;
            }
        }
        return null;
    }

    public void BuscarNodo(String nombre){
        Nodo aux = RecorridoDeBusqueda(nombre);
        if(aux == null){
            System.out.println("No se encontro la ciudad " + nombre + " en el Arbol");
        }else{
            System.out.println("Si se encontro la ciudad " + aux.dato + " en el Arbol");
        }
    }

    public boolean estaVacio(){
        return raiz == null;
    }



    //ORDEN DE LOS ARBOLES----------------------------------------------------------------------------------------------------------------------
    public void PreOrden(Nodo r){
        if (r != null) {
            System.out.println(r.dato);
            PreOrden(r.HijoIzq);
            PreOrden(r.HijoDer);
        }
    }
    public void InOrden(Nodo r){
        if (r != null) {
            InOrden(r.HijoIzq);
            System.out.println(r.dato);
            InOrden(r.HijoDer);
        }
    }
    public void PostOrden(Nodo r){
        if (r != null) {
            PostOrden(r.HijoIzq);
            PostOrden(r.HijoDer);
            System.out.println(r.dato);
        }
    }

}
