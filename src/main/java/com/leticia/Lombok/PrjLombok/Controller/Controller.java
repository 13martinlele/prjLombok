package com.leticia.Lombok.PrjLombok.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.leticia.Lombok.PrjLombok.entities.Usuario;

import jakarta.validation.Valid;

public class Controller {

		private final Service UsuarioService;

		@Autowired
		public Controller(Service UsuarioService) {
			this.UsuarioService = UsuarioService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<Usuario> findUsuariobyId(@PathVariable Long id) {
			Usuario usuario = UsuarioService.findUsuarioById(id);
			if (usuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		public ResponseEntity<List<Usuario>> findAllUsuarioscontrol() {
			List<Usuario> usuarios = UsuarioService.findAllUsuario();
			return ResponseEntity.ok(usuarios);
		}

		@PostMapping("/{id}")
		public ResponseEntity<Usuario> insertUsuariosControl(@RequestBody @Valid Usuario usuario) {
			Usuario novoUsuario = UsuarioService.insertUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
		}

		@PutMapping("/id")
		public ResponseEntity<Usuario> updateUsuarioControl(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
			Usuario mudausuario = UsuarioService.updateUsuario(id, usuario);
			if (mudausuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/id")
		public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long id) {
			boolean remover = UsuarioService.deleteUsuario(id);
			if (remover) {
				return ResponseEntity.ok().body("usuario Excluido com sucesso");
			} else {
				return ResponseEntity.notFound().build();
			}
		}

	
}
