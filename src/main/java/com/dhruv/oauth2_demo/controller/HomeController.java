package com.dhruv.oauth2_demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//this is just a random comment for testing

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OidcUser principal,
                       @RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient authClient,
                       Model model) {

        model.addAttribute("username", principal.getPreferredUsername());
        model.addAttribute("email", principal.getEmail());
        model.addAttribute("name", principal.getFullName());
        model.addAttribute("roles", principal.getAuthorities());

        return "home";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}