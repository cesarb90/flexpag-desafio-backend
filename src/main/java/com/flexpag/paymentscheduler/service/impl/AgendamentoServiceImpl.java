package com.flexpag.paymentscheduler.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.entity.Agendamento;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;
import com.flexpag.paymentscheduler.service.AgendamentoService;
import com.flexpag.paymentscheduler.util.Status;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public Agendamento agendarPagamento(Agendamento agendamento) {
		agendamento.setStatus(Status.PENDING);
		return this.agendamentoRepository.save(agendamento);
	}

	public Agendamento realizarPagamento(Long id) {
		Agendamento agendamento = this.obterAgendamento(id);
		agendamento.setStatus(Status.PAID);
		return this.agendamentoRepository.save(agendamento);
	}

	public Status consultarStatus(Long id) {
		var agendamento = this.obterAgendamento(id);
		return agendamento.getStatus();
	}

	public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
		Agendamento agendamento = this.obterAgendamento(id);

		if (agendamento.getStatus() == Status.PAID)
			agendamento.setDataHora(agendamentoAtualizado.getDataHora());
		agendamento.setValor(agendamentoAtualizado.getValor());
		return this.agendamentoRepository.save(agendamento);
	}

	public Agendamento obterAgendamento(Long id) {
		Optional<Agendamento> agendamento = this.agendamentoRepository.findById(id);
		return agendamento.orElse(null);
	}
}
