package br.com.cod3r.exercicessb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exercicessb.models.entities.Client;

@RestController
@RequestMapping(path="/clients")
public class ClientController {
	
	@GetMapping(path="/any")
	public Client requireClient() {
		return new Client(28, "Felipe", "felipe.kod@gmail.com");
	}
	
	@GetMapping("/{id}")
	public Client obtenirClientParId(@PathVariable int id) {
		return new Client(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping
	public Client obtenirClientParId2 (@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Client(id, "Julius Cezar", "111.222.111-66");
	}
}
