package br.com.server.api.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.server.api.dao.Usuario;
import br.com.server.api.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable String id, @RequestBody Usuario usuario) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Usuário com o ID fornecido não existe.");
        }
        usuario.setId(id); // Garante que o ID seja configurado corretamente
        return repository.save(usuario);
    }

}
