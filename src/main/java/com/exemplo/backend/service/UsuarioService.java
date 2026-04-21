package com.exemplo.backend.service;

import com.exemplo.backend.dto.UsuarioRequest;
import com.exemplo.backend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {

    private final Map<Long, Usuario> usuarios = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<Usuario> listar() {
        return new ArrayList<>(usuarios.values());
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarios.get(id);
        if (usuario == null) {
            throw new NoSuchElementException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario criar(UsuarioRequest request) {
        Long id = sequence.incrementAndGet();
        Usuario usuario = new Usuario(id, request.getNome(), request.getEmail());
        usuarios.put(id, usuario);
        return usuario;
    }

    public Usuario atualizar(Long id, UsuarioRequest request) {
        Usuario existente = buscarPorId(id);
        existente.setNome(request.getNome());
        existente.setEmail(request.getEmail());
        return existente;
    }

    public void deletar(Long id) {
        if (usuarios.remove(id) == null) {
            throw new NoSuchElementException("Usuário não encontrado");
        }
    }
}
