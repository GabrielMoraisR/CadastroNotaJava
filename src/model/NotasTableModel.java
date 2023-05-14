package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class NotasTableModel extends AbstractTableModel {

    private List<Notas> dados = new ArrayList<>();
    private String[] colunas = {"Turma", "Nome", "Materia", "Nota 1", "Nota 2"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dados.get(rowIndex).getTurma();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getMateria();
            case 3:
                return dados.get(rowIndex).getNota1();
            case 4:
                return dados.get(rowIndex).getNota2();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                dados.get(rowIndex).setTurma((String) aValue);
                break;
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setMateria((String) aValue);
                break;
            case 3:
                dados.get(rowIndex).setNota1(Integer.parseInt((String) aValue));
                break;
            case 4:
                dados.get(rowIndex).setNota2(Integer.parseInt((String) aValue));
                break;
        }

        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addRow(Notas n) {
        this.dados.add(n);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Notas getDados(int linha) {
        return dados.get(linha);
    }

}
