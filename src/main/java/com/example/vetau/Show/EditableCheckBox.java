package com.example.vetau.Show;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

public class EditableCheckBox<S, T> extends CheckBoxTableCell<S, T> {

    private final CheckBox checkBox;

    public EditableCheckBox() {
        this.checkBox = new CheckBox();
        this.checkBox.setDisable(false);
        this.checkBox.setOnAction(event -> {
            if (getTableRow() != null) {
                TableView<S> tableView = getTableView();
                S rowData = tableView.getItems().get(getIndex());
                TableColumn<S, T> column = getTableColumn();
                Callback<TableColumn.CellDataFeatures<S, T>, ObservableValue<T>> cellValueFactory = column.getCellValueFactory();
                ObservableValue<T> cellObservableValue = cellValueFactory.call(new TableColumn.CellDataFeatures<>(tableView, column, rowData));
                if (cellObservableValue instanceof SimpleBooleanProperty) {
                    SimpleBooleanProperty booleanProperty = (SimpleBooleanProperty) cellObservableValue;
                    booleanProperty.set(this.checkBox.isSelected());
                }
            }
        });
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            setGraphic(checkBox);
            checkBox.setSelected((Boolean) item);
        }
    }
}

