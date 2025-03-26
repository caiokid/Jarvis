package br.com.teste.pizza.usuario;

import br.com.teste.pizza.pizza.Categoria;
import br.com.teste.pizza.pizza.Sabor;
import br.com.teste.pizza.pizza.Tamanho;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter; 
import org.springframework.web.bind.annotation.PostMapping;


@Getter
@Setter
public class CredenciaisDTO {


    private String login;
    @NotBlank
    private String password;
}
