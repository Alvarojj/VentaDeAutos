package PRCOMISIONES;

import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro J
 */
public class Main {
    static int ep;
    static int ec;
    public static void main(String[] args) {
        Auto va[] = new Auto[20];
        Vendedor vv[] = new Vendedor[20];
        Venta ve[] = new Venta[20];
        char cop;
        String menu, placa, marca, color, cedula, nombre, salida;
        int modelo, precio, kil, ei, eta, etv, etve, ett, preciov, swt, comision, comicionActual, precioventa;
        eta = 0;
        etv = 0;
        etve = 0;
        do {
            menu = "*** Menu ***\n1. Registrar auto\n2. Registrar vendedor\n3. Registrar venta\n4. Listar autos\n5. Listar vendedores\n6. Listar ventas registradas\n7. Liquidar comisones\n0. Salir";
            cop = JOptionPane.showInputDialog(menu).charAt(0);
            switch (cop) {
                case '1':
                    ett = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos autos registrar?"));
                    for (ei = (eta + 1); ei <= (eta + ett); ei++) {
                        placa = JOptionPane.showInputDialog("Ingrese la placa del veiculo " + ei);
                        marca = JOptionPane.showInputDialog("Ingrese la marca del veiculo " + ei);
                        modelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese  el modelo del auto " + ei));
                        precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese  el precio del auto " + ei));
                        color = JOptionPane.showInputDialog("Ingrese el color del veiculo " + ei);
                        kil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese  el kilometraje del auto " + ei));
                        va[ei] = new Auto(placa, marca, modelo, precio, color, kil);
                    }
                    eta = eta + ett;
                    break;
                case '2':
                    ett = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos vendedores va a registrar?"));
                    for (ei = (etv + 1); ei <= (etv + ett); ei++) {
                        cedula = JOptionPane.showInputDialog("Ingrese cedula del vendedor " + ei);
                        nombre = JOptionPane.showInputDialog("Ingrese el nombre del vendedor " + ei);
                        vv[ei] = new Vendedor(cedula, nombre);
                    }
                    etv = etv + ett;
                    break;
                case '3':
                    placa = JOptionPane.showInputDialog("Ingrese la placa del veiculo ");
                    cedula = JOptionPane.showInputDialog("Ingrese la cedula del vendedor ");
                    preciov = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de venta"));
                    swt = ValAuto(va, eta, placa, preciov);
                    if (swt == 1) {
                        swt = ValVendedor(vv, etv, cedula);
                        if (swt == 1) {
                            etve = etve + 1;
                            ve[etve] = new Venta(placa, cedula, preciov);
                            va[ep].setCestado('V');
                            vv[ec].setEconmision(preciov - va[ep].getEprecio());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo realizar la venta", "Error de venta", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede realizar la venta", "Error de venta", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case '4':
                    salida = "";
                    if (eta != 0) {
                        for (ei = 1; ei <= eta; ei++) {
                            salida = salida + va[ei].Mostrar() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Lista de autos", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay autos registrados", "Lista de autos", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case '5':
                    salida = "";
                    if (etv != 0) {
                        for (ei = 1; ei <= etv; ei++) {
                            salida = salida + vv[ei].Mostrar() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Lista de vendedores", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay vendedores registrados", "Lista de vendedores", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case '6':
                    salida = "";
                    if (etve != 0) {
                        for (ei = 1; ei <= etve; ei++) {
                            salida = salida + ve[ei].Mostrar() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Lista de ventas", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ventas registradas", "Lista de ventas", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case '7':
                    salida = "";
                    if (etv != 0) {
                        for (ei = 1; ei <= etv; ei++) {
                            salida = salida + vv[ei].MostrarL() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Liquidaciones", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay vendedores registrados", "Liquidaciones", JOptionPane.INFORMATION_MESSAGE);

                    }
                    break;

                case '0':
                    JOptionPane.showMessageDialog(null, "HASTA PRONTO!", "Saliendo...", JOptionPane.CLOSED_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "WARRNING", JOptionPane.WARNING_MESSAGE);
                    break;
            }

        } while (cop != '0');

    } // Validacion de que la placa exista que el precio sea mañor a precio minimo, y que el esta este en disponible

    public static int ValAuto(Auto va[], int et, String placa, int prec) {
        ep = 1;
        do {
            if (placa.equals(va[ep].getSplaca())) {
                if (va[ep].getCestado() == 'D') {
                    if (prec >= va[ep].getEprecio()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                ep++;
            }
        } while (ep <= et);
        return 0;
    }

    //Validacion de que la cedula del vendedor exista
    public static int ValVendedor(Vendedor ve[], int et, String cedula) {
        ec = 1;
        do {
            if (cedula.equals(ve[ec].getScedula())) {
                return 1;
            } else {
                ec++;
            }
        } while (ec <= et);
        return 0;
    }
}
