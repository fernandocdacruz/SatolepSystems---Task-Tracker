package com.satolepsystems.task_tracker.service;

import com.satolepsystems.task_tracker.dto.external.AdviceSlipResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdviceService {

    private final RestClient adviceRestClient;

    public String obterConselhoAleatorio() {

        try {
            AdviceSlipResponseDTO response = adviceRestClient.get()
                    .uri("/advice")
                    .retrieve()
                    .body(AdviceSlipResponseDTO.class);

            if (response != null && response.slip() != null) {
                return response.slip().advice();
            }

        } catch (Exception e) {
            log.error("Erro ao consumir API externa de conselhos: {}", e.getMessage());
        }

        return "Mantenha o foco e conclua suas tarefas com disciplina.";

    }

}
