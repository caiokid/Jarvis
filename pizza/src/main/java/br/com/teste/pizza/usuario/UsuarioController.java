package br.com.teste.pizza.usuario;

import br.com.teste.pizza.pizza.PizzaDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")

public class UsuarioController {

       private final UserService userService;

    @PostMapping
    public ResponseEntity<DadosUsuarioCadastro> cadastrar(@RequestBody @Valid DadosUsuarioCadastro dto, UriComponentsBuilder uriBuilder){

        DadosUsuarioCadastro usuarioDTO = userService.criarUsuario(dto);
        URI endereco = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioDTO.getId()).toUri();

        return ResponseEntity.created(endereco).body(usuarioDTO);
    }

}
