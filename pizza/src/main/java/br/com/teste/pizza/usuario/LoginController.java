package br.com.teste.pizza.usuario;


import br.com.teste.pizza.config.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller

@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

   @GetMapping("")
	public void login(){
      
   }
	

    private final TokenService tokenService;


    private final AuthenticationManager autenticador;


    @PostMapping
   public ResponseEntity ValidarCredenciais(@RequestBody @Valid CredenciaisDTO credenciais){

      UsernamePasswordAuthenticationToken token  = new UsernamePasswordAuthenticationToken(credenciais.getLogin(), credenciais.getPassword());
      Authentication autenticacao = autenticador.authenticate(token);

      return ResponseEntity.ok(tokenService.criarToken((Usuario) autenticacao.getPrincipal()));
   }
}
