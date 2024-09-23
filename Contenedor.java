//
// Programación orientada a objetos
// Sección 20
// Laboratorio 2
// 
// Diego Calderón = 241263
//

public class Contenedor {
    // Atributos
    private int id;
    private int num;
    private String producto;
    private float peso = 0;
    private int seccion;
    // Secciones:
    // 1 = Productos electrónicos
    // 2 = Ropa
    // 3 = Alimentos
    // 4 = Maquinaria

    // Constructor
    Contenedor(int id, String producto, int seccion) {
        this.id = id;
        this.producto = producto;
        switch (seccion) { // Definiendo peso dependiendo de la sección (peso promedio por contenedor de
                           // esa sección)
            case 1:
                this.peso = (200000) / 50;
                break;
            case 2:
                this.peso = (150000) / 50;
                break;
            case 3:
                this.peso = (250000) / 50;
                break;
            case 4:
                this.peso = (300000) / 50;
                break;
            default:
                this.peso = 0;
                break;
        }
        this.seccion = seccion;
    }

    // Métodos
    public String toString() {
        return "Contenedor [id=" + id + ", num=" + num + ", producto=" + producto + ", peso=" + peso
                + ", seccion=" + seccion + "]";
    }

    // Setters & getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

}