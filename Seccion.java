import java.util.ArrayList;

public class Seccion {
    // Atributos
    private final int CAP_MAX;
    private final int MAX_FILAS = 10;
    private final int MAX_COL = 5;
    private float peso;
    private int tipo;
    // Secciones:
    // 1 = Productos electrónicos
    // 2 = Ropa
    // 3 = Alimentos
    // 4 = Maquinaria
    private ArrayList<ArrayList<Contenedor>> contenedores; // ArrayList de ArrayLists

    // Constructor
    public Seccion(int tipo) {
        this.tipo = tipo;
        // Inicializar Matriz
        contenedores = new ArrayList<>(MAX_FILAS);
        for (int i = 0; i < MAX_FILAS; i++) {
            contenedores.add(new ArrayList<>(MAX_COL));
        }
        switch (tipo) { // Definiendo Capacidad Máxima dependiendo del tipo
            case 1:
                this.CAP_MAX = 200000;
                break;
            case 2:
                this.CAP_MAX = 150000;
                break;
            case 3:
                this.CAP_MAX = 250000;
                break;
            case 4:
                this.CAP_MAX = 300000;
                break;
            default:
                this.CAP_MAX = 0;
                break;
        }
    }

    // Métodos

    // Agregar un contenedor a la sección
    public boolean agregarContenedor(Contenedor contenedor) {
        if (peso + contenedor.getPeso() <= CAP_MAX) {
            for (ArrayList<Contenedor> fila : contenedores) {
                if (fila.size() < MAX_COL) {
                    fila.add(contenedor);
                    peso += contenedor.getPeso();
                    return true; // Se agregó el contenedor
                }
            }
        }
        return false; // No se pudo agregar el contenedor

    }

    // Eliminar Contenedor
    public Contenedor eliminarContenedor() { // Si se desea eliminar el último contenedor
        for (ArrayList<Contenedor> fila : contenedores) {
            if (!fila.isEmpty()) {
                peso = peso - fila.get(fila.size() - 1).getPeso();
                return fila.remove(fila.size() - 1); // Elimina y retorna el último contenedor
            }
        }
        return null; // Retorna null si no hay contenedores para eliminar
    }

    public Contenedor eliminarContenedor(Contenedor contenedor) { // Si se desea eliminar un contenedor en específico
        for (ArrayList<Contenedor> fila : contenedores) {
            fila.remove(contenedor);
        }

        peso = peso - contenedor.getPeso();
        return contenedor; // Se retorna el mismo contenedor pese a ya conocerse por si el usuario desea
                           // migrarlo a otra sección
    }

    // Setters & Getters
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<ArrayList<Contenedor>> getContenedores() {
        return contenedores;
    }

    public void setContenedores(ArrayList<ArrayList<Contenedor>> contenedores) {
        this.contenedores = contenedores;
    }

}