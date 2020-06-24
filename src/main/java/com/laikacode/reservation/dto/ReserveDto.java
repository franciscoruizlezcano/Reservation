package com.laikacode.reservation.dto;

import com.laikacode.reservation.model.Client;
import com.laikacode.reservation.model.Reserve;
import lombok.Data;

import java.util.Date;

@Data
public class ReserveDto {

    private Integer id;

    private String description;

    private Date checkInDate;

    private Date egressDate;

    private ClientDto client;

    public ReserveDto() {
    }

    public ReserveDto(Integer id) {
        this.id = id;
    }

    public ReserveDto(String description, Date checkInDate, Date egressDate, ClientDto client) {
        this.description = description;
        this.checkInDate = checkInDate;
        this.egressDate = egressDate;
        this.client = client;
    }

    public ReserveDto(Integer id, String description, Date checkInDate, Date egressDate, ClientDto client) {
        this.id = id;
        this.description = description;
        this.checkInDate = checkInDate;
        this.egressDate = egressDate;
        this.client = client;
    }

    public Reserve fromDto(ReserveDto reserveDto){
        Reserve reserve = new Reserve();

        reserve.setDescription(reserveDto.getDescription());
        reserve.setCheckInDate(reserveDto.getCheckInDate());
        reserve.setEgressDate(reserveDto.getEgressDate());

        ClientDto clientDto = new ClientDto();

        reserve.setClient(clientDto.fromDto(reserveDto.client));

        return reserve;
    }

    public ReserveDto toDto(Reserve reserve){
        ReserveDto reserveDto = new ReserveDto();

        reserveDto.setDescription(reserve.getDescription());
        reserveDto.setCheckInDate(reserve.getCheckInDate());
        reserveDto.setEgressDate(reserve.getEgressDate());

        ClientDto clientDto = new ClientDto();

        reserveDto.setClient(clientDto.toDto(reserve.getClient()));

        return reserveDto;
    }
}
