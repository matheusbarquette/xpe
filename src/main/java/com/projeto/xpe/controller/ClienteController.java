package com.projeto.xpe.controller;
import com.projeto.xpe.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.xpe.model.Cliente;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public List<Cliente> buscarPorNome(@PathVariable String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @GetMapping("/contar")
    public long contarClientes() {
        return clienteService.contarClientes();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}