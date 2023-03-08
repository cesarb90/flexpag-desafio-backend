package com.flexpag.paymentscheduler.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.paymentscheduler.entity.Agendamento;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
}
