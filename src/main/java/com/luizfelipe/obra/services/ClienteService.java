package com.luizfelipe.obra.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.domain.Pessoa;
import com.luizfelipe.obra.domain.dtos.ClienteDTO;
import com.luizfelipe.obra.repository.ClienteRepository;
import com.luizfelipe.obra.repository.PessoaRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;
import com.luizfelipe.obra.services.exceptions.ViolacaoIntegracaoDadosException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Cliente não encontrado! ID: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setIdCliente(null);

		validarPorCPF(objDTO);

		Cliente newObj = new Cliente(objDTO);
		newObj.setDataCadastro(LocalDate.now());
		return clienteRepository.save(newObj);
	}

	public Cliente update(Long id, @Valid ClienteDTO objDTO) {
		objDTO.setIdCliente(id);
		Cliente oldObj = findById(id);
		oldObj = new Cliente(objDTO);
		return clienteRepository.save(oldObj);
	}

	public void delete(Long id) {
		Cliente obj = findById(id);
		if (Objects.nonNull(obj))
			clienteRepository.deleteById(id);
	}

	private void validarPorCPF(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getIdPessoa() != objDTO.getIdCliente()) {
			throw new ViolacaoIntegracaoDadosException("CPF já cadastro no sistema!");
		}
	}

}
