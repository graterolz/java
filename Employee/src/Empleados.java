import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Empleados extends javax.swing.JFrame {
	DefaultTableModel modelo;
	//
	public Empleados() {
		initComponents();
		CargarTablaEmpleados("");
		cboGenero.addItem("M");
		cboGenero.addItem("F");
		inhabilitar();
	}
	//
	void CargarTablaEmpleados(String valor) {
		String[] titulos = {"IDEMP", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Fecha Nacimiento", "Sexo"};
		String[] registro = new String[7];
		String sSQL = "";
		modelo = new DefaultTableModel(null, titulos);
		ConexionMySQL mysql = new ConexionMySQL();
		Connection cn = mysql.Conectar();
		sSQL = "SELECT idemp, ape1, ape2, nom1, nom2, fecnac, sexo FROM users " +
				"WHERE CONCAT(ape1, ' ',ape2, ' ',nom1, ' ',nom2) LIKE '%"+valor+"%'";
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next()) {
				registro[0] = rs.getString("idemp");
				registro[1] = rs.getString("ape1");
				registro[2] = rs.getString("ape2");
				registro[3] = rs.getString("nom1");
				registro[4] = rs.getString("nom2");
				registro[5] = rs.getString("fecnac");
				registro[6] = rs.getString("sexo");
				modelo.addRow(registro);
			}
			tblConsultaEmpleado.setModel(modelo);
		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	//
	String id_actualizar = "";
	void BuscarEmpleadoEditar(String id) {
		String sSQL = "";
		String ap1 = "",ap2 = "",nom1 = "",nom2 = "",fn = "",sex = "";
		ConexionMySQL mysql = new ConexionMySQL();
		Connection cn = mysql.Conectar();
		sSQL = "SELECT idemp, ape1, ape2, nom1, nom2, fecnac, sexo FROM users " +
				"WHERE idemp = "+id;
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next()){
				ap1 = rs.getString("ape1");
				ap2 = rs.getString("ape2");
				nom1 = rs.getString("nom1");
				nom2 = rs.getString("nom2");
				fn = rs.getString("fecnac");
				sex = rs.getString("sexo");
			}
			txtPrimerApellido.setText(ap1);
			txtSegundoApellido.setText(ap2);
			txtPrimerNombre.setText(nom1);
			txtSegundoNombre.setText(nom2);
			txtFechaNac.setText(fn);
			id_actualizar = id;
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	//
	void habilitar() {
		txtPrimerApellido.setEnabled(true);
		txtSegundoApellido.setEnabled(true);
		txtPrimerNombre.setEnabled(true);
		txtSegundoNombre.setEnabled(true);
		txtFechaNac.setEnabled(true);
		cboGenero.setEnabled(true);
		txtPrimerApellido.setText("");
		txtSegundoApellido.setText("");
		txtPrimerNombre.setText("");
		txtSegundoNombre.setText("");
		txtFechaNac.setText("");
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		txtPrimerApellido.requestFocus();
	}
	//
	void inhabilitar() {
		txtPrimerApellido.setEnabled(false);
		txtSegundoApellido.setEnabled(false);
		txtPrimerNombre.setEnabled(false);
		txtSegundoNombre.setEnabled(false);
		txtFechaNac.setEnabled(false);
		cboGenero.setEnabled(false);
		txtPrimerApellido.setText("");
		txtSegundoApellido.setText("");
		txtPrimerNombre.setText("");
		txtSegundoNombre.setText("");
		txtFechaNac.setText("");
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
	//
	@SuppressWarnings("unchecked")
	private void initComponents() {
		jPopupMenu1 = new javax.swing.JPopupMenu();
		mnEditar = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtPrimerApellido = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtSegundoApellido = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtPrimerNombre = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtSegundoNombre = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtFechaNac = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		cboGenero = new javax.swing.JComboBox();
		btnNuevo = new javax.swing.JButton();
		btnGuardar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		btnSalir = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblConsultaEmpleado = new javax.swing.JTable();
		jLabel7 = new javax.swing.JLabel();
		txtBuscar = new javax.swing.JTextField();
		btnBuscar = new javax.swing.JButton();
		mnEditar.setText("Modificar");
		mnEditar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnEditarActionPerformed(evt);
			}
		});
		jPopupMenu1.add(mnEditar);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Formulario con Conexión a MySQL");
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado: Datos Personales "));
		jLabel1.setText("Apellido1: ");
		txtPrimerApellido.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtPrimerApellidoActionPerformed(evt);
			}
		});
		jLabel2.setText("Apellido2: ");
		txtSegundoApellido.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSegundoApellidoActionPerformed(evt);
			}
		});
		jLabel3.setText("Nombre1: ");
		txtPrimerNombre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtPrimerNombreActionPerformed(evt);
			}
		});
		jLabel4.setText("Nombre2: ");
		txtSegundoNombre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSegundoNombreActionPerformed(evt);
			}
		});
		jLabel5.setText("Fecha de Nacimiento: ");
		txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtFechaNacActionPerformed(evt);
			}
		});
		jLabel6.setText("Sexo:");
		cboGenero.setMaximumRowCount(2);
		cboGenero.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboGeneroActionPerformed(evt);
			}
		});
		btnNuevo.setText("Habilitar");
		btnNuevo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNuevoActionPerformed(evt);
			}
		});
		btnGuardar.setText("Registrar");
		btnGuardar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGuardarActionPerformed(evt);
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});
		btnSalir.setText("Salir");
		btnSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalirActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup()
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel6)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(44, 44, 44))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel5)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel4)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
					.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNuevo)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnGuardar)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnCancelar)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btnSalir)))
				.addContainerGap(340, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel1)
					.addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel2)
					.addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel3)
					.addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel4)
					.addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel5)
					.addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel6)
					.addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(28, 28, 28)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(btnNuevo)
					.addComponent(btnGuardar)
					.addComponent(btnCancelar)
					.addComponent(btnSalir))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Empleados"));
		tblConsultaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
			new Object [][] {
				{},
				{},
				{},
				{}
			},
			new String [] {

			}
		));
		tblConsultaEmpleado.setComponentPopupMenu(jPopupMenu1);
		jScrollPane1.setViewportView(tblConsultaEmpleado);
		jLabel7.setText("Buscar Empleado : ");
		btnBuscar.setText("Buscar");
		btnBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBuscarActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanel2Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
					.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jLabel7)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btnBuscar)))
				.addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanel2Layout.createSequentialGroup()
				.addGap(25, 25, 25)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel7)
					.addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnBuscar))
				.addGap(18, 18, 18)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
					.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pack();
	}
	//
	private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}
	//
	private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {
		habilitar();
	}
	//
	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		inhabilitar();
	}
	//
	private void txtPrimerApellidoActionPerformed(java.awt.event.ActionEvent evt) {
		txtPrimerApellido.transferFocus();
	}
	//
	private void txtSegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {
		txtSegundoApellido.transferFocus();
	}
	//
	private void txtPrimerNombreActionPerformed(java.awt.event.ActionEvent evt) {
		txtPrimerNombre.transferFocus();
	}
	//
	private void txtSegundoNombreActionPerformed(java.awt.event.ActionEvent evt) {
		txtSegundoNombre.transferFocus();
	}
	//
	private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {
		txtFechaNac.transferFocus();
	}
	//
	String accion = "Insertar";
	private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
		ConexionMySQL mysql = new ConexionMySQL();
		Connection cn = mysql.Conectar();
		String ap1, ap2, nom1, nom2, fn,sex;
		String sSQL = "";
		String mensaje = "";
		ap1 = txtPrimerApellido.getText();
		ap2 = txtSegundoApellido.getText();
		nom1 = txtPrimerNombre.getText();
		nom2 = txtSegundoNombre.getText();
		fn = txtFechaNac.getText();
		sex = cboGenero.getSelectedItem().toString();
		if(accion.equals("Insertar")) {
			sSQL = "INSERT INTO users(ape1, ape2, nom1, nom2, fecnac, sexo)" +
				"VALUES(?, ?, ?, ?, ?, ?)";
			mensaje = "Registro procesado...";
		}
		else if(accion.equals("Modificar")) {
			sSQL = "UPDATE users " +
					"SET ape1 = ?," +
					"ape2 = ?," +
					"nom1 = ?," +
					"nom2 = ?," +
					"fecnac = ?," +
					"sexo = ? " +
					"WHERE idemp = "+id_actualizar;
			mensaje = "Registro Modoficado...";
		}
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setString(1, ap1);
			pst.setString(2, ap2);
			pst.setString(3, nom1);
			pst.setString(4, nom2);
			pst.setString(5, fn);
			pst.setString(6, sex);
			int n = pst.executeUpdate();
			if(n > 0) {
				JOptionPane.showMessageDialog(null, mensaje);
				CargarTablaEmpleados("");
			}
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	//
	private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
		String valor = txtBuscar.getText();
		CargarTablaEmpleados(valor);
	}
	//
	private void mnEditarActionPerformed(java.awt.event.ActionEvent evt) {
		int filasel;
		String id;
		try {
			filasel = tblConsultaEmpleado.getSelectedRow();
			if(filasel == -1) {
				JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
			}
			else {
				accion = "Modificar";
				modelo = (DefaultTableModel) tblConsultaEmpleado.getModel();
				id = (String) modelo.getValueAt(filasel, 0);
				habilitar();
				BuscarEmpleadoEditar(id);
			}
		}
		catch (Exception e) {
		}
	}
	//
	private void cboGeneroActionPerformed(java.awt.event.ActionEvent evt) {}
	//
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Empleados().setVisible(true);
			}
		});
	}
	//
	private javax.swing.JButton btnBuscar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnGuardar;
	private javax.swing.JButton btnNuevo;
	private javax.swing.JButton btnSalir;
	private javax.swing.JComboBox cboGenero;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JMenuItem mnEditar;
	private javax.swing.JTable tblConsultaEmpleado;
	private javax.swing.JTextField txtBuscar;
	private javax.swing.JTextField txtFechaNac;
	private javax.swing.JTextField txtPrimerApellido;
	private javax.swing.JTextField txtPrimerNombre;
	private javax.swing.JTextField txtSegundoApellido;
	private javax.swing.JTextField txtSegundoNombre;
}