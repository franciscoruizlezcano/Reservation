package com.laikacode.reservation.dto;

import com.laikacode.reservation.model.Client;
import lombok.Data;

@Data
public class ClientDto {
    private Integer id;

    private String name;

    private String lastname;

    private String identity;

    private String phone;

    private String email;

    public ClientDto() {
    }

    public ClientDto(Integer id) {
        this.id = id;
    }

    public ClientDto(String name, String lastname, String identity, String phone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.phone = phone;
        this.email = email;
    }

    public ClientDto(Integer id, String name, String lastname, String identity, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.phone = phone;
        this.email = email;
    }

    public Client fromDto(ClientDto clientDto){
        Client client = new Client();

        client.setName(clientDto.getName());
        client.setLastname(clientDto.getLastname());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setIdentity(clientDto.getIdentity());

        return client;
    }

    public ClientDto toDto(Client client){
        ClientDto clientDto = new ClientDto();

        clientDto.setName(client.getName());
        clientDto.setLastname(client.getLastname());
        clientDto.setEmail(client.getEmail());
        clientDto.setPhone(client.getPhone());
        clientDto.setIdentity(client.getIdentity());

        return clientDto;
    }
}
