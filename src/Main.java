import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArbolBinario ciudades = new ArbolBinario();
        Scanner sc = new Scanner(new File("ciudades_del_mundo.csv"));
        sc.useDelimiter(",");
        List <String> ListaCiudades = new ArrayList<String>();
        while (sc.hasNext()) {
            ListaCiudades.add(sc.nextLine());
        }
        sc.close();

        for (int i = 0; i < 1000; i++) {
            ciudades.Insertar(ListaCiudades.get(new Random().nextInt(ListaCiudades.size())));
            ListaCiudades.remove(ListaCiudades.get(new Random().nextInt(ListaCiudades.size())));
        }

        ciudades.PreOrden(ciudades.raiz);
      /*  System.out.println("----------------------------------------------------");
        ciudades.InOrden(ciudades.raiz);
        System.out.println("----------------------------------------------------");
        ciudades.PostOrden(ciudades.raiz);
        System.out.println("----------------------------------------------------");*/
        ciudades.BuscarNodo("Yutan");
        ciudades.BuscarNodo("Seoul");
        ciudades.BuscarNodo("Yungay");
        ciudades.BuscarNodo("Trenton");
        ciudades.BuscarNodo("Sampit");
        ciudades.BuscarNodo("Trinidad");
        ciudades.BuscarNodo("Union");
        ciudades.BuscarNodo("Southfield");
        ciudades.BuscarNodo("Stuart");
        ciudades.BuscarNodo("Munster");




    }
}