package com.example.application.views.login;

import com.example.application.security.AuthenticatedUser;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.internal.RouteUtil;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("Inicio de sesión")
@Route(value = "login")
public class LoginView extends LoginOverlay implements BeforeEnterObserver {

    private final AuthenticatedUser authenticatedUser;

    public LoginView(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
        setAction(RouteUtil.getRoutePath(VaadinService.getCurrent().getContext(), getClass()));

        LoginI18n i18n = LoginI18n.createDefault();
        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Inicio de Sesión");
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Proyecto Final Grupo 6");
        i18n.getHeader().setDescription("Iniciar sesión con tu usuario y contraseña de UTH");
        i18n.setAdditionalInformation(null);
        i18n.getForm().setUsername("Usuario");
        i18n.getForm().setPassword("Contraseña");
        i18n.getForm().setSubmit("Iniciar sesión");
        i18n.getForm().setForgotPassword("Olvidé mi contraseña");
        i18n.getErrorMessage().setTitle("Usuario/Contraseña incorrectos");
        i18n.getErrorMessage().setMessage("Por favor, verifica tu usuario y contraseña e intenta nuevamente.");
        setI18n(i18n);

        setForgotPasswordButtonVisible(true); // Hacer visible el botón de "Olvidé mi contraseña"
        addForgotPasswordListener(event -> {
            // Redirigir a la página de recuperación de contraseña
            getUI().ifPresent(ui -> ui.navigate("forgot-password"));
        });

        setOpened(true);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (authenticatedUser.get().isPresent()) {
            // Ya está logueado
            setOpened(false);
            event.forwardTo("");
        }

        setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
    }
}