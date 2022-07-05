/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_1_2;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.lang.Math;

/**
 *
 * @author Zury
 */
public class Calculadora {

    public String Opcion_1 = "";
    public String Operacion = "";
    public String num_1 = "";
    public String num_2 = "";
    public double suma = 0, resta = 0, multiplicacion = 0, division = 0, potencia = 0, raizC = 0;
    public int seguirejecutando = 0;

    DecimalFormat df = new DecimalFormat("#####.##");

    public void Primera_Opcion() {
        Opcion_1 = JOptionPane.showInputDialog("Seleccione una Opcion \n\n 1. Realizar una Operación. \n 2. Salir. \n ");
        if (isInteger(Opcion_1) == true) {
            if (Integer.parseInt(Opcion_1) == 1) {
                do {
                    JOptionPane.showMessageDialog(null, "Resultado de su Operación es: " + df.format(SeleccionarOperacion()));
                    seguirejecutando = 1;
                } while (seguirejecutando != 0);

                //SeleccionarOperacion();
            } else if (Integer.parseInt(Opcion_1) == 2) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Numero ingresado NO válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dígito ingresado NO válido");
        }

    }

    public double SeleccionarOperacion() {
        Operacion = JOptionPane.showInputDialog("Selecione una Operacion \n\n"
                + "1. Suma\n"
                + "2. Resta\n"
                + "3. Multiplicación\n"
                + "4. División\n"
                + "5. Pottencia\n"
                + "6. Raíz Cuadrada\n"
                + "7. Salir\n"
        );
        if (Integer.parseInt(Operacion) > 0 && Integer.parseInt(Operacion) < 8) {
            LeerNumero();
            if (isInteger(Operacion) == true) {

                switch (Integer.parseInt(Operacion)) {
                    case 1: {
                        suma = Double.parseDouble(num_1) + Double.parseDouble(num_2);
                        //break;
                        seguirejecutando = 1;
                        return suma;
                    }
                    case 2: {
                        resta = Double.parseDouble(num_1) - Double.parseDouble(num_2);
                        //break;
                        seguirejecutando = 1;
                        return resta;

                    }
                    case 3: {
                        multiplicacion = Double.parseDouble(num_1) * Double.parseDouble(num_2);
                        //break;
                        seguirejecutando = 1;
                        return multiplicacion;

                    }
                    case 4: {
                        try {
                            division = Double.parseDouble(num_1) / Double.parseDouble(num_2);
                            //break;
                            seguirejecutando = 1;
                            return division;
                        } catch (ArithmeticException e) {
                            // Exception handler
                            JOptionPane.showMessageDialog(null,
                                    "Divided by zero operation cannot possible");
                        }

                    }
                    case 5: {
                        potencia = Math.pow(Integer.parseInt(num_1), Integer.parseInt(num_2));
                        //potencia =Integer.parseInt(num_1)*Integer.parseInt(num_2);
                        //break;
                        seguirejecutando = 1;
                        return potencia;

                    }
                    case 6: {
                        raizC = Math.sqrt(Double.parseDouble(num_1));
                        //break;
                        seguirejecutando = 1;
                        return raizC;

                    }
                    case 7: {
                        Primera_Opcion();

                    }
                    default: {
                        System.exit(0);
                    }

                }
            }

        }
        return 0;
    }

    public void LeerNumero() {
        if (Integer.parseInt(Operacion) == 6) {
            num_1 = JOptionPane.showInputDialog("Ingrese el Primer Numero");
        } else if (Integer.parseInt(Operacion) > 0 && Integer.parseInt(Operacion) < 6) {
            num_1 = JOptionPane.showInputDialog("Ingrese el Primer Numero");
            num_2 = JOptionPane.showInputDialog("Ingrese el Segundo Numero");
        }

    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

}
