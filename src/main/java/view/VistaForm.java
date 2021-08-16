package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import controller.Controlador;
import model.vo.Lider;
import model.vo.Proyecto;

public class VistaForm extends JFrame {
    /**********
     * Atributos
     */
    // Label
    private JLabel nombre;
    private JLabel utp;
    private JLabel reto;
    private JLabel lbltitulo;

    // Botones
    private JButton btnreq1;
    private JButton btnreq2;
    private JButton btnreq3;
    private JButton btnreq4;
    private JButton btnreq5;

    // Tabla
    private JTable tabla;
    private JScrollPane paneltabla;

    public VistaForm() {
        this.setTitle("Proyectos Constructora");
        this.setBounds(0, 0, 1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // tITULO
        GridLayout gNorthLayout = new GridLayout(4, 0, 2, 2);
        Container northContainer = new Container();
        northContainer.setLayout(gNorthLayout);
        this.nombre = new JLabel("Nombre: Lucia Castellanos Castillo.");
        nombre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        northContainer.add(this.nombre);
        this.utp = new JLabel("Institución: Universidad Tecnológica de Pereira.");
        utp.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        northContainer.add(this.utp);
        this.reto = new JLabel("Reto 5.");
        reto.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        northContainer.add(this.reto);
        this.lbltitulo = new JLabel("Proyectos Constructora.");
        lbltitulo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 30));
        lbltitulo.setForeground(new java.awt.Color(0, 112, 33));
        lbltitulo.setBackground(Color.LIGHT_GRAY);
        lbltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        northContainer.add(this.lbltitulo);

        // Tabla
        GridLayout gCenterLayout = new GridLayout();
        Container centerContainer = new Container();
        centerContainer.setLayout(gCenterLayout);
        this.paneltabla = new JScrollPane();
        this.tabla = new JTable();
        tabla.setForeground(new java.awt.Color(2, 120, 59));
        tabla.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

        }));
        paneltabla.setViewportView(tabla);
        paneltabla.setBorder(new EmptyBorder(20, 15, 20, 15));
        centerContainer.add(paneltabla);

        // Columna izquierda
        GridLayout gWestLayout = new GridLayout(5, 1, 25, 25);
        Container westContainer = new Container();
        westContainer.setLayout(gWestLayout);
        this.getContentPane().setLayout(new BorderLayout());
        // Agregar los labels
        this.btnreq1 = new JButton("Requerimiento 1");
        btnreq1.setBackground(new java.awt.Color(59, 164, 89));
        btnreq1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 16));
        westContainer.add(btnreq1);

        this.btnreq2 = new JButton("Requerimiento 2");
        btnreq2.setBackground(new java.awt.Color(59, 164, 89));
        btnreq2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 16));
        westContainer.add(btnreq2);

        this.btnreq3 = new JButton("Requerimiento 3");
        btnreq3.setBackground(new java.awt.Color(59, 164, 89));
        btnreq3.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 16));
        westContainer.add(btnreq3);

        this.btnreq4 = new JButton("Requerimiento 4");
        btnreq4.setBackground(new java.awt.Color(59, 164, 89));
        btnreq4.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 16));
        westContainer.add(btnreq4);

        this.btnreq5 = new JButton("Requerimiento 5");
        btnreq5.setBackground(new java.awt.Color(59, 164, 89));
        btnreq5.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 16));
        westContainer.add(btnreq5);

        this.btnreq1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String[] nomColumna = { "Fecha_Inicio", "Numero_Habitaciones", "Clasificacion" };
                Controlador control = new Controlador();
                ArrayList<Proyecto> lista;
                try {
                    lista = control.Solucionar_requerimiento_1();
                    Object[][] datos = new Object[lista.size()][3];
                    int index = 0;

                    for (Proyecto p : lista) {
                        datos[index][0] = p.getFecha_inicio();
                        datos[index][1] = p.getNum_habitaciones();
                        datos[index][2] = p.getClasificacion();
                        index++;
                    }
                    DefaultTableModel model = new DefaultTableModel(datos, nomColumna);
                    tabla.setModel(model);
                    ;
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }

            }
        });
        this.btnreq2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String[] nomColumna = { "Fecha_Inicio", "Numero_Habitaciones", "Clasificacion", "Nombre",
                        "Primer_Apellido", "Estrato" };
                Controlador control = new Controlador();
                ArrayList<Proyecto> lista;
                try {
                    lista = control.Solucionar_requerimiento_2();
                    Object[][] datos = new Object[lista.size()][6];
                    int index = 0;

                    for (Proyecto p : lista) {
                        datos[index][0] = p.getFecha_inicio();
                        datos[index][1] = p.getNum_habitaciones();
                        datos[index][2] = p.getClasificacion();
                        datos[index][3] = p.getLider().getNombre();
                        datos[index][4] = p.getLider().getApellido();
                        datos[index][5] = p.getEstrato_proyecto();
                        index++;
                    }
                    DefaultTableModel model = new DefaultTableModel(datos, nomColumna);
                    tabla.setModel(model);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }

            }
        });
        this.btnreq3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String[] nomColumna = { "Constructora", "Condominios" };
                Controlador control = new Controlador();
                ArrayList<Proyecto> lista;
                try {
                    lista = control.Solucionar_requerimiento_3();
                    Object[][] datos = new Object[lista.size()][2];
                    int index = 0;

                    for (Proyecto p : lista) {
                        datos[index][0] = p.getNombre_constructora();
                        datos[index][1] = p.getNum_condominios();
                        index++;
                    }
                    DefaultTableModel model = new DefaultTableModel(datos, nomColumna);
                    tabla.setModel(model);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }

            }
        });

        this.btnreq4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String[] nomColumna = { "Nombre", "Apellido" };
                Controlador control = new Controlador();
                ArrayList<Lider> lista;
                try {
                    lista = control.Solucionar_requerimiento_4();
                    Object[][] datos = new Object[lista.size()][2];
                    int index = 0;

                    for (Lider l : lista) {
                        datos[index][0] = l.getNombre();
                        datos[index][1] = l.getApellido();
                        index++;
                    }
                    DefaultTableModel model = new DefaultTableModel(datos, nomColumna);
                    tabla.setModel(model);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }

            }
        });

        this.btnreq5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String[] nomColumna = { "Constructora", "Condominios" };
                Controlador control = new Controlador();
                ArrayList<Proyecto> lista;
                try {
                    lista = control.Solucionar_requerimiento_5();
                    Object[][] datos = new Object[lista.size()][3];
                    int index = 0;

                    for (Proyecto p : lista) {
                        datos[index][0] = p.getNombre_constructora();
                        datos[index][1] = p.getNum_condominios();
                        index++;
                    }
                    DefaultTableModel model = new DefaultTableModel(datos, nomColumna);
                    tabla.setModel(model);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }

            }
        });

        this.add(centerContainer, BorderLayout.CENTER);
        this.add(northContainer, BorderLayout.NORTH);
        this.add(westContainer, BorderLayout.WEST);

    }

}
