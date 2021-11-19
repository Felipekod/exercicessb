package br.com.cod3r.exercicessb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exercicessb.models.Client;

@RestController
@RequestMapping(path="/clients")
public class ClientController {
	
	@GetMapping(path="/any")
	public Client requireClient() {
		return new Client(28, "Felipe", "felipe.kod@gmail.com");
	}
}
