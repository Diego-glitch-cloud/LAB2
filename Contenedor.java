
public class Contenedor {
    // Atributos
    private int id;
    private int num;
    private String producto;
    private int seccion;
    // Secciones:
    // 1 = Productos electrónicos
    // 2 = Ropa
    // 3 = Alimentos
    // 4 = Maquinaria

    // Constructor
    Contenedor(int id, int num, String producto, int seccion) {
        this.id = id;
        this.num = num;
        this.producto = producto;
        this.seccion = seccion;
    }

    // Métodos
    public String toString() {
        return "Contenedor [id=" + id + ", num=" + num + ", producto=" + producto + ", seccion=" + seccion + "]";
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

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

}