package com.example.application.views.registodeempleados;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.páginaprincipal.PáginaPrincipalView;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Registro de empleados")
@Route("my-view3")
@Menu(order = 1, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class RegistodeempleadosView extends Composite<VerticalLayout> {


    private final Grid<SamplePerson> basicGrid = new Grid<>(SamplePerson.class);

    public RegistodeempleadosView() {
        RouterLink routerLink = new RouterLink();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TextField nombreCompleto = new TextField("Nombre Completo");
        TextField codigoEmpleado = new TextField("Código del Empleado");
        TextField numeroTelefono = new TextField("Número de Teléfono");
        EmailField correoElectronico = new EmailField("Correo Electrónico");
        ComboBox<SampleItem> departamento = new ComboBox<>("Departamento");
        ComboBox<SampleItem> puesto = new ComboBox<>("Puesto");
        DatePicker fechaIngreso = new DatePicker("Fecha de Ingreso");
        TextField salario = new TextField("Salario");
        CheckboxGroup<String> tipoContrato = new CheckboxGroup<>();
        Button limpiar = new Button("Limpiar");
        Button actualizar = new Button("Actualizar");
        Button agregar = new Button("Agregar");
        Button eliminar = new Button("Eliminar");

        getContent().setWidth("100%");
getContent().getStyle().set("flex-grow", "1").setHeight("1px");
        routerLink.setText("Página Principal");
        routerLink.setRoute(PáginaPrincipalView.class);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
layoutRow.getStyle().set("flex-grow", "1").setWidth("1px");
        layoutColumn2.setWidth("100%");
        basicGrid.setWidth("100%");
        basicGrid.setHeight("1200px");
basicGrid.getStyle().set("flex-grow", "0").setHeight("1140px").setWidth("1200px").setMaxWidth("1200px");
        setGridSampleData(basicGrid);
        layoutColumn3.setHeight("800px");

        tipoContrato.setLabel("Tipo de contrato");
        tipoContrato.setItems("PERMANENTE", "TEMPORAL", "PASANTÍA", "INDEFINIDO");
        tipoContrato.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        agregar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        getContent().add(routerLink);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(basicGrid);
layoutColumn2.getStyle().setWidth("12000px");
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(nombreCompleto, codigoEmpleado, numeroTelefono, correoElectronico, departamento, puesto, fechaIngreso, salario, tipoContrato, agregar, actualizar, limpiar, eliminar);





        configureGrid();
        setComboBoxDepartamento(departamento);
        setComboBoxPuesto(puesto);
    }

    private void configureGrid() {
        basicGrid.removeAllColumns();
        basicGrid.addColumn(SamplePerson::getFirstName).setHeader("Nombre Completo");
        basicGrid.addColumn(SamplePerson::getLastName).setHeader("Código del Empleado");
        basicGrid.addColumn(SamplePerson::getPhone).setHeader("Número de Teléfono");
        basicGrid.addColumn(SamplePerson::getEmail).setHeader("Correo Electrónico");
        basicGrid.addColumn(SamplePerson::getOccupation).setHeader("Departamento");
        basicGrid.addColumn(SamplePerson::getRole).setHeader("Puesto");
        basicGrid.addColumn(SamplePerson::getDateOfBirth).setHeader("Fecha de Ingreso");
        basicGrid.addColumn(SamplePerson::isImportant).setHeader("Salario");
        basicGrid.addColumn(SamplePerson::isImportant).setHeader("Tipo de contrato");
    }

    private void setGridSampleData(Grid<SamplePerson> grid) {
        grid.setItems(query -> samplePersonService.list(VaadinSpringDataHelpers.toSpringPageRequest(query)).stream());
    }

    @Autowired
    private SamplePersonService samplePersonService;

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxDepartamento(ComboBox<SampleItem> comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("mantenimiento", "Mantenimiento", null));
        sampleItems.add(new SampleItem("operaciones", "Operaciones", null));
        sampleItems.add(new SampleItem("recursosHumanos", "Recursos Humanos", null));
        sampleItems.add(new SampleItem("importacionExportacion", "Importación y Exportación", null));
        sampleItems.add(new SampleItem("planeacion", "Planeación", null));
        sampleItems.add(new SampleItem("ingenieria", "Ingeniería", null));
        comboBox.setItems(new ArrayList<>(sampleItems));
        comboBox.setItemLabelGenerator(SampleItem::label);
    }

    private void setComboBoxPuesto(ComboBox<SampleItem> comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("gerente", "Gerente", null));
        sampleItems.add(new SampleItem("jefe", "Jefe", null));
        sampleItems.add(new SampleItem("supervisor", "Supervisor", null));
        sampleItems.add(new SampleItem("tecnico", "Técnico", null));
        sampleItems.add(new SampleItem("operador", "Operador", null));
        sampleItems.add(new SampleItem("asistente", "Asistente", null));
        sampleItems.add(new SampleItem("auxiliar", "Auxiliar", null));
        sampleItems.add(new SampleItem("planificador", "Planificador", null));
        sampleItems.add(new SampleItem("coordinador", "Coordinador", null));
        sampleItems.add(new SampleItem("analista", "Analista", null));
        comboBox.setItems(new ArrayList<>(sampleItems));
        comboBox.setItemLabelGenerator(SampleItem::label);
    }
}
