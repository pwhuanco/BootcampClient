package com.bootcamp.bankclient.service.Impl;

import com.bootcamp.bankclient.model.entities.Client;
import com.bootcamp.bankclient.model.dto.ClientDto;
import com.bootcamp.bankclient.repository.ClientRepository;
import com.bootcamp.bankclient.service.ClientService;
import com.bootcamp.bankclient.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Flux<ClientDto> getClients(){
        return clientRepository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ClientDto> getClientById(String id) {
        return clientRepository.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ClientDto> getClientByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Mono<ClientDto> getClientByClientIdNumber(String clientIdNumber) {
        return clientRepository.findByClientIdNumber(clientIdNumber)
                .switchIfEmpty(Mono.just(ClientDto.builder()
                        .clientIdNumber(null).build()));
    }



    public Mono<ClientDto> saveClients(Mono<ClientDto> clientDtoMono){
        return clientDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(clientRepository::insert)
                .map(AppUtils::entityToDto);
    }







    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }

    public Mono<ClientDto> updateClients(Mono<ClientDto> clientDtoMono,String id){
        return clientRepository.findById(id)
                .flatMap(p->clientDtoMono.map(AppUtils::dtoToEntity)
                .doOnNext(e->e.setId(id)))
                .flatMap(clientRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteClient(String id){
        return clientRepository.deleteById(id);
    }
}
