package com.example.application.views.registodeempleados;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Registo de empleados")
@Route("my-view3")
@Menu(order = 1, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class RegistodeempleadosView extends Composite<VerticalLayout> {

    public RegistodeempleadosView() {
        RouterLink routerLink = new RouterLink();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid basicGrid = new Grid(SamplePerson.class);
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        EmailField emailField = new EmailField();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        DatePicker datePicker = new DatePicker();
        TextField textField4 = new TextField();
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        Button buttonSecondary = new Button();
        Button buttonSecondary2 = new Button();
        Button buttonPrimary = new Button();
        Button buttonSecondary3 = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        routerLink.setText("Página Principal");
        routerLink.setRoute(RegistodeempleadosView.class);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        basicGrid.setWidth("100%");
        basicGrid.setHeight("1000px");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid);
        layoutColumn3.setHeight("800px");
        textField.setLabel("Nombre Completo");
        textField.setWidth("min-content");
        textField.setHeight("50px");
        textField2.setLabel("Código del Empleado");
        textField2.setWidth("min-content");
        textField2.setHeight("50px");
        textField3.setLabel("Número de Teléfono");
        textField3.setWidth("min-content");
        textField3.setHeight("50px");
        emailField.setLabel("Correo Electrónico");
        emailField.setWidth("min-content");
        emailField.setHeight("50px");
        comboBox.setLabel("Departamento");
        comboBox.setWidth("min-content");
        comboBox.setHeight("50px");
        setComboBoxSampleData(comboBox);
        comboBox2.setLabel("Puesto");
        comboBox2.setWidth("min-content");
        comboBox2.setHeight("50px");
        setComboBoxSampleData(comboBox2);
        datePicker.setLabel("Fecha de Ingreso");
        datePicker.setWidth("min-content");
        datePicker.setHeight("50px");
        textField4.setLabel("Salario");
        textField4.setWidth("min-content");
        textField4.setHeight("50px");
        checkboxGroup.setLabel("Tipo de contrato");
        checkboxGroup.setWidth("min-content");
        checkboxGroup.setItems("Order ID", "Product Name", "Customer", "Status");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        buttonSecondary.setText("Limpiar");
        buttonSecondary.setWidth("min-content");
        buttonSecondary2.setText("Actualizar");
        buttonSecondary2.setWidth("min-content");
        buttonPrimary.setText("Agregar");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary3.setText("Eliminar");
        buttonSecondary3.setWidth("min-content");
        getContent().add(routerLink);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(basicGrid);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(textField);
        layoutColumn3.add(textField2);
        layoutColumn3.add(textField3);
        layoutColumn3.add(emailField);
        layoutColumn3.add(comboBox);
        layoutColumn3.add(comboBox2);
        layoutColumn3.add(datePicker);
        layoutColumn3.add(textField4);
        layoutColumn3.add(checkboxGroup);
        layoutColumn3.add(buttonSecondary);
        layoutColumn3.add(buttonSecondary2);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary3);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(VaadinSpringDataHelpers.toSpringPageRequest(query)).stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
