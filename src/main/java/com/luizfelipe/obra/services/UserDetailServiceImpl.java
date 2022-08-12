package com.luizfelipe.obra.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Pessoa;
import com.luizfelipe.obra.repository.PessoaRepository;
import com.luizfelipe.obra.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Pessoa> user = pessoaRepository.findByLogin(login);
		if (user.isPresent()) {
			return new UserSS(user.get().getIdPessoa(), user.get().getLogin(), user.get().getSenha(), user.get().getPerfis());
		}
		
		throw new UsernameNotFoundException(login);
	}

}
