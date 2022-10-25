public class Nodo {
      String dato;
      Nodo HijoIzq;
      Nodo HijoDer;

        public Nodo(String d) {
            this.dato =d;
            this.HijoIzq = null;
            this.HijoDer = null;
        }

        public String toString(){
            return "el dato es: " + this.dato;
        }
}
