package Vista;

import Controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author García García José Ángel
 */
public class Vista_Registro extends JFrame {

    public JLabel etqUsuario, etqContraseña, etqCorreo, etqPermiso, etqSexo, etqEdad, etqNombre, etqCurp, etqRfc, etqTelefono;
    public JTextField txtUsuario, txtCorreo, txtEdad, txtNombre, txtCurp,txtRfc,txtTelefono;
    public JPasswordField txtContraseña;
    public JRadioButton productor, cliente, hombre, mujer;
    public JButton registrar, cancelar, siguiente, atras;
    public JButton limpiar;
    public JPanel pPer,pUser,contenedor;
    private SpringLayout sp;
    public boolean validaNombre,validaCurp,validaEdad,validaHombre,validaMujer,validaUsuario,validaEmail,validaContraseña,validaCliente,validaProductor,validaTelefono,validadRfc;
    private Hilo hilo;
    private int cont = 0;
    class Hilo extends Thread{
        public void run(){
            setSize(400,320);
            setVisible(true);
            setLocationRelativeTo(null);
            add(principal());
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }
    
    public Vista_Registro() {
        hilo = new Hilo();
        hilo.start();
    }

    public Thread getHilo(){
        return hilo;
    }
    
    public JPanel principal() {
        sp = new SpringLayout();
        contenedor = new JPanel(sp);
        contenedor.setBackground(Color.decode("#233D53"));
        pUser = PanelDataUser(); 
        pPer  = PanelDataPer();
        addPanelDataPer(); // Primero mostramos el panel de personas
        siguiente = new JButton("Siguiente");
        siguiente.setActionCommand("siguiente");
        atras = new JButton("Atras");
        atras.setActionCommand("atras");
        contenedor.add(atras);
        sp.putConstraint(SpringLayout.NORTH, atras, 5, SpringLayout.SOUTH, pPer);
        sp.putConstraint(SpringLayout.WEST, atras, 200, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, atras,-2, SpringLayout.SOUTH, contenedor);
        contenedor.add(siguiente);
        sp.putConstraint(SpringLayout.NORTH, siguiente, 5, SpringLayout.SOUTH, pPer);
        sp.putConstraint(SpringLayout.WEST, siguiente, 12, SpringLayout.EAST, atras);
        sp.putConstraint(SpringLayout.EAST, siguiente,-12, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, siguiente,-2, SpringLayout.SOUTH, contenedor);
        pPer.setVisible(true);
        pUser.setVisible(false);
        deshabilitarBotones();
        return contenedor;
    }

    public void deshabilitarBotones(){
        if(pPer.isVisible()){
            atras.setEnabled(false);
            siguiente.setEnabled(true);
        }else if(pUser.isVisible()){
            atras.setEnabled(true);
            siguiente.setEnabled(false);
        }
    }
    // Agregando segundo panel
    public void addPanelDataUser(){
        contenedor.add(pUser);
        sp.putConstraint(SpringLayout.NORTH, pUser, 12, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, pUser, 12, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, pUser,-12, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, pUser, -30, SpringLayout.SOUTH, contenedor);
    }
    
    public void addPanelDataPer(){
        contenedor.add(pPer);
        sp.putConstraint(SpringLayout.NORTH, pPer, 12, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, pPer, 12, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, pPer,-12, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, pPer, -30, SpringLayout.SOUTH, contenedor);
    
    }
    
    public JPanel PanelDataPer(){
        SpringLayout s2 = new SpringLayout();
        JPanel panel = new JPanel(s2);
        //panel.setBackground(Color.decode("#233D53"));
        panel.setBorder(BorderFactory.createTitledBorder("Registro Personal"));
        //panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3),"Datos Personales"));
        etqSexo = new JLabel("Sexo :");
        etqEdad = new JLabel("Edad : ");
        etqNombre = new JLabel("Nombre : ");
        etqCurp = new JLabel("Curp : ");
        txtEdad = new JTextField(5);
        txtEdad.setActionCommand("edad");
        txtNombre = new JTextField(20);
        txtNombre.setActionCommand("nombre");
        txtCurp = new JTextField(20);
        txtCurp.setActionCommand("curp");
        mujer = new JRadioButton("Mujer");
        mujer.setActionCommand("mujer");
        hombre = new JRadioButton("Hombre");
        hombre.setActionCommand("hombre");
        ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/user3.png"));
        ImageIcon icono = new ImageIcon(img.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
        JLabel imagen = new JLabel(icono);
        panel.add(imagen);
        s2.putConstraint(SpringLayout.NORTH,imagen,5,SpringLayout.NORTH,panel);
        s2.putConstraint(SpringLayout.WEST,imagen,120,SpringLayout.WEST,panel);
        panel.add(etqNombre);
        s2.putConstraint(SpringLayout.NORTH,etqNombre,12,SpringLayout.SOUTH,imagen);
        s2.putConstraint(SpringLayout.WEST,etqNombre,12,SpringLayout.WEST,panel);
        panel.add(txtNombre); 
        s2.putConstraint(SpringLayout.NORTH,txtNombre,12,SpringLayout.SOUTH,imagen);
        s2.putConstraint(SpringLayout.WEST,txtNombre,12,SpringLayout.EAST,etqNombre);
        panel.add(etqCurp);
        s2.putConstraint(SpringLayout.NORTH,etqCurp,12,SpringLayout.SOUTH,etqNombre);
        s2.putConstraint(SpringLayout.WEST,etqCurp,12,SpringLayout.WEST,panel);
        panel.add(txtCurp);
        s2.putConstraint(SpringLayout.NORTH,txtCurp,12,SpringLayout.SOUTH,etqNombre);
        s2.putConstraint(SpringLayout.WEST,txtCurp,29,SpringLayout.EAST,etqCurp);
        panel.add(etqEdad);
        s2.putConstraint(SpringLayout.NORTH,etqEdad,12,SpringLayout.SOUTH,etqCurp);
        s2.putConstraint(SpringLayout.WEST,etqEdad,12,SpringLayout.WEST,panel);
        panel.add(txtEdad);
        s2.putConstraint(SpringLayout.NORTH,txtEdad,12,SpringLayout.SOUTH,etqCurp);
        s2.putConstraint(SpringLayout.WEST,txtEdad,28,SpringLayout.EAST,etqEdad);
        panel.add(etqSexo);
        s2.putConstraint(SpringLayout.NORTH,etqSexo,12,SpringLayout.SOUTH,etqEdad);
        s2.putConstraint(SpringLayout.WEST,etqSexo,12,SpringLayout.WEST,panel);
        panel.add(mujer);
        s2.putConstraint(SpringLayout.NORTH,mujer,10,SpringLayout.SOUTH,etqEdad);
        s2.putConstraint(SpringLayout.WEST,mujer,12,SpringLayout.EAST,etqSexo);
        panel.add(hombre);
        s2.putConstraint(SpringLayout.NORTH,hombre,10,SpringLayout.SOUTH,etqEdad);
        s2.putConstraint(SpringLayout.WEST,hombre,10,SpringLayout.EAST,mujer);
        
        return panel;
    }
    // Segundo panel
    public JPanel PanelDataUser(){
        SpringLayout s = new SpringLayout();
        JPanel panel = new JPanel(s);
        panel.setSize(400, 350);
        //panel.setBackground(Color.decode("#064B73"));
        panel.setBorder(BorderFactory.createTitledBorder("Registro Usuario"));
        //panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3),"Registro Usuario"));
        etqUsuario = new JLabel("Usuario : ");
        txtUsuario = new JTextField(15);
        txtUsuario.setActionCommand("usuario");
        panel.add(etqUsuario);
        s.putConstraint(SpringLayout.WEST,etqUsuario,12,SpringLayout.WEST,panel);
        s.putConstraint(SpringLayout.NORTH,etqUsuario,8,SpringLayout.NORTH,panel);
        panel.add(txtUsuario);
        s.putConstraint(SpringLayout.WEST,txtUsuario,12,SpringLayout.EAST,etqUsuario);
        s.putConstraint(SpringLayout.NORTH,txtUsuario,8,SpringLayout.NORTH,panel);
        etqCorreo = new JLabel("Email :");
        txtCorreo = new JTextField(22);
        txtCorreo.setActionCommand("email");
        panel.add(etqCorreo);
        s.putConstraint(SpringLayout.NORTH,etqCorreo,12,SpringLayout.SOUTH,etqUsuario);
        s.putConstraint(SpringLayout.WEST,etqCorreo,12,SpringLayout.WEST,panel);
        panel.add(txtCorreo);
        s.putConstraint(SpringLayout.NORTH,txtCorreo,12,SpringLayout.SOUTH,etqUsuario);
        s.putConstraint(SpringLayout.WEST,txtCorreo,28,SpringLayout.EAST,etqCorreo);
        etqContraseña = new JLabel("Contraseña : ");
        txtContraseña = new JPasswordField(20);
        txtContraseña.setActionCommand("contraseña");
        panel.add(etqContraseña);
        s.putConstraint(SpringLayout.NORTH,etqContraseña,12,SpringLayout.SOUTH,etqCorreo);
        s.putConstraint(SpringLayout.WEST,etqContraseña,12,SpringLayout.WEST,panel);
        panel.add(txtContraseña);
        s.putConstraint(SpringLayout.NORTH,txtContraseña,12,SpringLayout.SOUTH,etqCorreo);
        s.putConstraint(SpringLayout.WEST,txtContraseña,12,SpringLayout.EAST,etqContraseña);
        etqPermiso = new JLabel("Rol :");
        productor = new JRadioButton("Productor");
        productor.setActionCommand("op_productor");
        cliente = new JRadioButton("Cliente");
        cliente.setActionCommand("op_cliente");
        panel.add(etqPermiso);
        s.putConstraint(SpringLayout.NORTH,etqPermiso,12,SpringLayout.SOUTH,etqContraseña);
        s.putConstraint(SpringLayout.WEST,etqPermiso,12,SpringLayout.WEST,panel);
        panel.add(productor);
        s.putConstraint(SpringLayout.NORTH,productor,10,SpringLayout.SOUTH,etqContraseña);
        s.putConstraint(SpringLayout.WEST,productor,28,SpringLayout.EAST,etqPermiso);
        panel.add(cliente);
        s.putConstraint(SpringLayout.NORTH,cliente,10,SpringLayout.SOUTH,etqContraseña);
        s.putConstraint(SpringLayout.WEST,cliente,28,SpringLayout.EAST,productor);
        etqTelefono = new JLabel("Telefono : ");
        txtTelefono = new JTextField(10);
        txtTelefono.setActionCommand("telefono");
        panel.add(etqTelefono);
        s.putConstraint(SpringLayout.NORTH,etqTelefono,12,SpringLayout.SOUTH,etqPermiso);
        s.putConstraint(SpringLayout.WEST,etqTelefono,12,SpringLayout.WEST,panel);
        panel.add(txtTelefono);
        s.putConstraint(SpringLayout.NORTH,txtTelefono,12,SpringLayout.SOUTH,etqPermiso);
        s.putConstraint(SpringLayout.WEST,txtTelefono,12,SpringLayout.EAST,etqTelefono);
        etqTelefono.setVisible(false);
        txtTelefono.setVisible(false);
        etqRfc = new JLabel("RFC : ");
        txtRfc = new JTextField(10);
        txtRfc.setActionCommand("rfc");
        panel.add(etqRfc);
        s.putConstraint(SpringLayout.NORTH,etqRfc,12,SpringLayout.SOUTH,etqTelefono);
        s.putConstraint(SpringLayout.WEST,etqRfc,12,SpringLayout.WEST,panel);
        panel.add(txtRfc);
        s.putConstraint(SpringLayout.NORTH,txtRfc,12,SpringLayout.SOUTH,etqTelefono);
        s.putConstraint(SpringLayout.WEST,txtRfc,38,SpringLayout.EAST,etqRfc);
        txtRfc.setVisible(false);
        etqRfc.setVisible(false);
        limpiar = new JButton("Limpiar");
        limpiar.setActionCommand("limpiar");
        panel.add(limpiar);
        s.putConstraint(SpringLayout.NORTH,limpiar,16,SpringLayout.SOUTH,etqRfc);
        s.putConstraint(SpringLayout.WEST,limpiar,50,SpringLayout.WEST,panel);
        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand("cancelar");
        panel.add(cancelar);
        s.putConstraint(SpringLayout.NORTH,cancelar,16,SpringLayout.SOUTH,etqRfc);
        s.putConstraint(SpringLayout.WEST,cancelar,12,SpringLayout.EAST,limpiar);
        registrar = new JButton("Registrar");
        registrar.setActionCommand("registrar");
        panel.add(registrar);
        s.putConstraint(SpringLayout.NORTH,registrar,16,SpringLayout.SOUTH,etqRfc);
        s.putConstraint(SpringLayout.WEST,registrar,12,SpringLayout.EAST,cancelar);
        s.putConstraint(SpringLayout.EAST,registrar,-12,SpringLayout.EAST,panel);
        return panel;
    }
    
    public void conectarControlador(Controlador c){
        try {
          Thread.sleep(305);
        } catch (Exception e) {}
            txtNombre.addKeyListener(c);
            txtNombre.addActionListener(c);
            txtCurp.addKeyListener(c);
            txtCurp.addActionListener(c);
            txtEdad.addKeyListener(c);
            txtEdad.addActionListener(c);
            mujer.addActionListener(c);
            hombre.addActionListener(c);
            txtUsuario.addActionListener(c);
            txtCorreo.addActionListener(c);
            txtContraseña.addActionListener(c);
            productor.addActionListener(c);
            cliente.addActionListener(c);
            txtTelefono.addActionListener(c);
            txtTelefono.addKeyListener(c);
            txtRfc.addActionListener(c);
            atras.addActionListener(c);
            siguiente.addActionListener(c);
            limpiar.addActionListener(c);
            cancelar.addActionListener(c);
            registrar.addActionListener(c);
    }
}