/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.gui.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import prestamofacil.Controller.ClienteManager;
import prestamofacil.entidades.Cliente;

/**
 *
 * @author Junior
 */
public class ClientelTableModel extends AbstractTableModel{

    ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
    String columnas[] = {"DNI","Nombres", "Apellidos"};  
    ClienteManager manager = new ClienteManager(); ; 

    public ClientelTableModel() {        
        clientes = manager.getClientes();         
    }
    
    @Override
    public int getRowCount() {
        return clientes.size(); 
    }

    @Override
    public int getColumnCount() {
        return columnas.length; 
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; 
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :  return clientes.get(rowIndex).getDni(); 
            case 1 :  return clientes.get(rowIndex).getNombre(); 
            case 2 :  return clientes.get(rowIndex).getApellidos(); 
            default:return null; 
        }
        
    }
    
}
