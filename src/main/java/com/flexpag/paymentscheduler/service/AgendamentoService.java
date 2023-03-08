package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.entity.Agendamento;
import com.flexpag.paymentscheduler.util.Status;

public interface AgendamentoService {

	public Agendamento agendarPagamento(Agendamento agendamento);

	public Agendamento realizarPagamento(Long id);

	public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado);

	public Status consultarStatus(Long id);
}
