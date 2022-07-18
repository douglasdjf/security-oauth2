package br.com.securityoauth2.securityoauth2;

import br.com.securityoauth2.securityoauth2.domain.model.Permissao;
import br.com.securityoauth2.securityoauth2.domain.model.Usuario;
import br.com.securityoauth2.securityoauth2.domain.repository.PermissaoRepository;
import br.com.securityoauth2.securityoauth2.domain.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class UsuarioTests {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void deveFazerJoinCollecao() {

		Usuario usuario = new Usuario();

		Set<Permissao> permissoesVazia = new HashSet<>();
		permissoesVazia.add(Permissao.builder().id(1L).build() );
		Assert.assertNotNull(permissoesVazia);

		Set<Permissao> permissoesJPA =	permissaoRepository.findAll().stream().collect(Collectors.toSet());

		Assert.assertNotNull(permissoesJPA);

	 	Set<Permissao> permissaoJoin =	Stream.of(permissoesJPA,permissoesVazia )
				.flatMap(Collection::stream)
				.collect(Collectors.toSet());


		 Assert.assertNotNull(permissaoJoin);

		permissaoJoin.forEach(permissao -> System.out.println("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));


	}

	@Test
	public void buildPermissoesVaziaMock(){

		Set<Permissao> permissoes = new HashSet<>();
		permissoes.add(Permissao.builder().id(1L).build() );
		permissoes.add(Permissao.builder().id(2L).build() );
		permissoes.add(Permissao.builder().id(3L).build() );
		permissoes.add(Permissao.builder().id(4L).build() );

		Assert.assertNotNull(permissoes);
		permissoes.forEach(permissao -> Assert.assertNotNull(permissao.getId()));

	}

	@Test
	public void buildPermissoesJpaMock(){
		Set<Permissao> permissoes =	permissaoRepository.findAll().stream().collect(Collectors.toSet());
		Assert.assertNotNull(permissoes);

		permissoes.forEach(permissao -> Assert.assertNotNull(permissao.getId()));

	}

	@Test
	public void deveCompararDuasListas(){

		Set<Permissao> permissoes = new HashSet<>();
		permissoes.add(Permissao.builder().id(1L).build());
		permissoes.add(Permissao.builder().id(2L).build());


		Set<Permissao> permissoesJpa =	permissaoRepository.findAll().stream().collect(Collectors.toSet());
		Assert.assertNotNull(permissoesJpa);

		Set<Permissao> joinPermissaoComparable=	permissoesJpa.stream()
				   .filter(permiJpa ->  permissoes.stream()
						   .anyMatch(permissao -> permissao.getId().equals(permiJpa.getId()))).collect(Collectors.toSet());

		joinPermissaoComparable.forEach(permissao -> Assert.assertNotNull(permissao.getId()));

		joinPermissaoComparable.forEach(permissao -> System.out.println("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));

	}

	@Test
	void deveObterUmUsuarioPorId(){
		Usuario usuario = usuarioRepository.findById(2L).get();
		Assert.assertNotNull(usuario);
	}

	@Test
	void deveAlterarUsuario(){
		Usuario usuario = usuarioRepository.findById(2L).get();
		Assert.assertNotNull(usuario);
		usuario.setNome("Maria da Silva");

		Usuario usuarioAlterado = usuarioRepository.save(usuario);
		Assert.assertNotNull(usuarioAlterado);
		System.out.println(usuarioAlterado.getNome());

	}


	@Test
	void updateUsuariroRemoverPermissao(){

		/*
			Usuario antes da Alteração
		 */
		Usuario usuarioAntes = usuarioRepository.findById(2L).get();
		Assert.assertNotNull(usuarioAntes);
		Assert.assertNotNull(usuarioAntes.getPermissao());
		System.out.println("PERMISSAO ANTES:");
		usuarioAntes.getPermissao().forEach(permissao -> System.out.println("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));

		/*
			Usuario depois da Alteração
		 */

		System.out.println("PERMISSAO DEPOIS:");
		Usuario usuarioDepois = usuarioRepository.findById(2L).get();
		Set<Permissao> permissaosRemove = new HashSet<>();

		 usuarioDepois.getPermissao().stream().filter(item -> item.getId().equals(2L) || item.getId().equals(3L))
				 .forEach(item -> {

					 permissaosRemove.add(item);
		});

		usuarioDepois.getPermissao().removeAll(permissaosRemove);

		usuarioDepois.getPermissao().forEach(permissao -> System.out.println("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));

		Usuario usuarioAlterado = usuarioRepository.save(usuarioDepois);
		Assert.assertNotNull(usuarioAlterado);

		usuarioAlterado.getPermissao().forEach(permissao -> System.out.println("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));

	}

	@Test
	void sincronizarUsuariroPermissao(){

		/*
			Usuario depois da Alteração
		 */

		System.out.println("PERMISSAO DEPOIS:");
		Usuario usuarioDepois = usuarioRepository.findById(2L).get();
		Set<Permissao> permissaosRemove = new HashSet<>();

		usuarioDepois.getPermissao().stream().filter(item -> item.getId().equals(2L) || item.getId().equals(3L))
				.forEach(item -> {

					permissaosRemove.add(item);
				});

		usuarioDepois.getPermissao().removeAll(permissaosRemove);

		usuarioDepois.getPermissao().forEach(permissao -> System.out.println("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));

	}



}
