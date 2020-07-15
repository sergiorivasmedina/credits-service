package com.bootcamp.credit.controllers;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.credit.models.CreditType;
import com.bootcamp.credit.repositories.CreditTypeRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CreditTypeController.class)
public class CreditTypeControllerTest {
    @MockBean
    CreditTypeRepository repository;

    @Autowired
    private WebTestClient webclient;
    
    @Test
    public void getAllCreditTypes() {
        CreditType creditType = new CreditType("1","tarjeta de credito");

        List<CreditType> list = new ArrayList<CreditType>();
        list.add(creditType);
         
        Flux<CreditType> transactionTypeFlux = Flux.fromIterable(list);

        Mockito
            .when(repository.findAll())
            .thenReturn(transactionTypeFlux);

        webclient.get()
            .uri("/credit/types")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(CreditType.class);

            Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void newCurrency() {
        CreditType creditType = new CreditType("1","tarjeta de credito");

        Mockito
            .when(repository.save(creditType))
            .thenReturn(Mono.just(creditType));
        
        webclient.post()
            .uri("/credit/type/new")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(creditType))
            .exchange()
            .expectStatus().isOk()
            .expectBody(CreditType.class);
    }

    @Test
    public void deleteAccountType() {
        CreditType creditType = new CreditType("1","tarjeta de credito");

        Mockito
            .when(repository.findById("1"))
            .thenReturn(Mono.just(creditType));

        Mono<Void> voidReturn  = Mono.empty();
        Mockito
            .when(repository.delete(creditType))
            .thenReturn(voidReturn);

	    webclient.delete()
                .uri("/credit/type/{currencyId}", creditType.getIdCreditType())
                .exchange()
                .expectStatus().isOk();
    }
}