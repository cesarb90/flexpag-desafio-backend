package com.flexpag.paymentscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.entity.Agendamento;
import com.flexpag.paymentscheduler.service.AgendamentoService;
import com.flexpag.paymentscheduler.service.impl.AgendamentoServiceImpl;
import com.flexpag.paymentscheduler.util.Status;

@RestController
public class AgendamentoController {

	@Autowired
	private AgendamentoServiceImpl service;

	@PostMapping("/agendamento")
	public ResponseEntity<Agendamento> agendarPagamento(@RequestBody Agendamento agendamento) {
		Agendamento novoAgendamento = this.service.agendarPagamento(agendamento);
		return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
	}

	@GetMapping("/status/{id}")
	public ResponseEntity<Status> consultarStatus(@PathVariable Long id) {
		Status statusAgendamento = this.service.consultarStatus(id);
		return new ResponseEntity<>(statusAgendamento, HttpStatus.OK);
	}

	@PatchMapping("/pagamento/{id}")
	public ResponseEntity<Agendamento> realizarPagamento(@PathVariable Long id) {
		Agendamento mudarPendentePagamento = this.service.realizarPagamento(id);
		return new ResponseEntity<>(mudarPendentePagamento, HttpStatus.ACCEPTED);
	}

	@PutMapping("/agendamento/{id}")
	public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
		Agendamento agendamentoAtualizado = this.service.atualizarAgendamento(id, agendamento);
		return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
	}

}