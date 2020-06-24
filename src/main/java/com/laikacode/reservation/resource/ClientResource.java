package com.laikacode.reservation.resource;

import com.laikacode.reservation.dto.ClientDto;
import com.laikacode.reservation.exception.ClientNotFoundException;
import com.laikacode.reservation.model.Client;
import com.laikacode.reservation.resource.util.CrudResource;
import com.laikacode.reservation.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Represent services web for Client entity
 * @author Francisco
 * */

@RestController
@Api(tags = "client")
@RequestMapping("/client")
public class ClientResource implements CrudResource<Client, ClientDto,Integer> {

    private final ClientService service;

    public ClientResource(ClientService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Find all clients", notes = "Service of find all clients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Find client by Id", notes = "Service of find client by id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<Client> findById(@RequestParam Integer id) {
        return new ResponseEntity<>(this.service.findById(id).orElseThrow(ClientNotFoundException::new), HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/exists/{id}")
    @ApiOperation(value = "Find client by Id", notes = "Service of find client by id and response return a boolean operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Boolean>> existsById(@RequestParam Integer id) {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("message", this.service.existsById(id));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/count")
    @ApiOperation(value = "Count clients", notes = "Service of count all clients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Long>> count() {
        HashMap<String, Long> response = new HashMap<>();
        response.put("message", this.service.count());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Override
    @PostMapping
    @ApiOperation(value = "Save client", notes = "Service of save client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<Client> save(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(this.service.save(clientDto.fromDto(clientDto)), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value = "Find and update client", notes = "Service of update client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<Client> update(@RequestParam Integer id, @RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(this.service.save(clientDto.fromDto(clientDto)), HttpStatus.OK);
    }

    @Override
    @DeleteMapping
    @ApiOperation(value = "Find and delete client", notes = "Service of delete client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam Integer id) {
        HashMap<String, Boolean> response = new HashMap<>();
        this.service.delete(new Client(id));
        response.put("message", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
