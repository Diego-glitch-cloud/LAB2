//
// Programación orientada a objetos
// Sección 20
// Laboratorio 2
// 
// Diego Calderón = 241263
//

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private Seccion electronicos, ropa, alimentos, maquinaria;
    private JTextArea displayArea;
    private int id = 0;

    public MainGUI() {
        setTitle("Gestión de Contenedores");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar secciones
        electronicos = new Seccion(1);
        ropa = new Seccion(2);
        alimentos = new Seccion(3);
        maquinaria = new Seccion(4);

        // Crear componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton agregarBtn = new JButton("Agregar Contenedor");
        JButton eliminarBtn = new JButton("Eliminar Contenedor");
        JButton moverBtn = new JButton("Mover Contenedor");
        JButton mostrarBtn = new JButton("Mostrar Información");
        JButton salirBtn = new JButton("Salir");

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Agregar componentes al panel
        panel.add(agregarBtn);
        panel.add(eliminarBtn);
        panel.add(moverBtn);
        panel.add(mostrarBtn);
        panel.add(salirBtn);

        // Agregar panel y área de texto al frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones para los botones
        agregarBtn.addActionListener(e -> agregarContenedor());
        eliminarBtn.addActionListener(e -> eliminarContenedor());
        moverBtn.addActionListener(e -> moverContenedor());
        mostrarBtn.addActionListener(e -> mostrarInformacion());
        salirBtn.addActionListener(e -> System.exit(0));
    }

    private void agregarContenedor() {
        String producto = JOptionPane.showInputDialog("Ingrese el producto:");
        String[] opciones = { "Electrónicos", "Ropa", "Alimentos", "Maquinaria" };
        int seccionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione la sección", "Sección",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        Seccion seccion = obtenerSeccion(seccionSeleccionada + 1);

        if (seccion != null && producto != null) {
            id++;
            seccion.agregarContenedor(new Contenedor(id, producto, seccionSeleccionada + 1));
            displayArea.append("Contenedor agregado exitosamente a la sección " + opciones[seccionSeleccionada] + "\n");
        } else {
            displayArea.append("Error al agregar contenedor.\n");
        }
    }

    private void eliminarContenedor() {
        String[] opciones = { "Eliminar por ID", "Eliminar último contenedor" };
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Eliminar Contenedor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        String[] secciones = { "Electrónicos", "Ropa", "Alimentos", "Maquinaria" };
        int seccionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione la sección", "Sección",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, secciones, secciones[0]);

        Seccion seccion = obtenerSeccion(seccionSeleccionada + 1);

        if (opcion == 0) { // Eliminar por ID
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del contenedor:"));
            Contenedor contenedor = seccion.buscarContenedor(id);
            if (contenedor != null) {
                seccion.eliminarContenedor(contenedor);
                displayArea.append("Contenedor con ID " + id + " eliminado.\n");
            } else {
                displayArea.append("Contenedor no encontrado.\n");
            }
        } else { // Eliminar último
            Contenedor contenedor = seccion.eliminarContenedor();
            if (contenedor != null) {
                displayArea
                        .append("Último contenedor eliminado de la sección " + secciones[seccionSeleccionada] + ".\n");
            } else {
                displayArea.append("No hay contenedores para eliminar.\n");
            }
        }
    }

    private void moverContenedor() {
        int idMover = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del contenedor a mover:"));

        String[] secciones = { "Electrónicos", "Ropa", "Alimentos", "Maquinaria" };
        int seccionOrigen = JOptionPane.showOptionDialog(null, "Seleccione la sección de origen", "Mover Contenedor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, secciones, secciones[0]);
        Seccion origen = obtenerSeccion(seccionOrigen + 1);

        Contenedor contenedor = origen.buscarContenedor(idMover);
        if (contenedor != null) {
            origen.eliminarContenedor(contenedor);

            int seccionDestino = JOptionPane.showOptionDialog(null, "Seleccione la sección de destino",
                    "Mover Contenedor",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, secciones, secciones[0]);
            Seccion destino = obtenerSeccion(seccionDestino + 1);

            contenedor.setSeccion(seccionDestino + 1);
            destino.agregarContenedor(contenedor);
            displayArea.append(
                    "Contenedor movido de " + secciones[seccionOrigen] + " a " + secciones[seccionDestino] + ".\n");
        } else {
            displayArea.append("Contenedor no encontrado.\n");
        }
    }

    private void mostrarInformacion() {
        String[] secciones = { "Electrónicos", "Ropa", "Alimentos", "Maquinaria" };
        int seccionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione la sección", "Mostrar Información",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, secciones, secciones[0]);

        Seccion seccion = obtenerSeccion(seccionSeleccionada + 1);
        StringBuilder info = new StringBuilder("Contenedores en la sección " + secciones[seccionSeleccionada] + ":\n");

        for (ArrayList<Contenedor> fila : seccion.getContenedores()) {
            for (Contenedor contenedor : fila) {
                info.append(contenedor).append("\n");
            }
        }

        displayArea.append(info.toString());
    }

    private Seccion obtenerSeccion(int seccionId) {
        switch (seccionId) {
            case 1:
                return electronicos;
            case 2:
                return ropa;
            case 3:
                return alimentos;
            case 4:
                return maquinaria;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI frame = new MainGUI();
            frame.setVisible(true);
        });
    }
}
