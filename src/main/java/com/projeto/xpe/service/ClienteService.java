package com.projeto.xpe.service;
import com.projeto.xpe.model.Cliente;
import com.projeto.xpe.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public ResponseEntity<Void> deletar(Long id) {

        // Verifica se o cliente existe
        if (!clienteRepository.existsById(id)) {
            // Retorna 404 Not Found caso o cliente não exista
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    public long contarClientes() {
        return clienteRepository.count();
    }
}
