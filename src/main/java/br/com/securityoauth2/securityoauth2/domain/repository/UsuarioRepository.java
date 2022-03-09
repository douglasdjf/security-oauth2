package br.com.securityoauth2.securityoauth2.domain.repository;

import br.com.securityoauth2.securityoauth2.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
