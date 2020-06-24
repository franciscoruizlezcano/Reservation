package com.laikacode.reservation.resource;

import com.laikacode.reservation.dto.ReserveDto;
import com.laikacode.reservation.exception.ClientNotFoundException;
import com.laikacode.reservation.exception.ReserveNotFoundException;

import com.laikacode.reservation.model.Reserve;
import com.laikacode.reservation.resource.util.CrudResource;
import com.laikacode.reservation.service.ReserveService;
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
 * Represent services web for Reserve entity
 * @author Francisco
 * */

@RestController
@Api(tags = "reserve")
@RequestMapping("/reserve")
public class ReserveResource implements CrudResource<Reserve, ReserveDto, Integer> {
    private final ReserveService service;

    public ReserveResource(ReserveService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Find all reserves", notes = "Service of find all reserves")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<List<Reserve>> findAll() {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Find reserve by Id", notes = "Service of find reserve by id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<Reserve> findById(@RequestParam Integer id) {
        return new ResponseEntity<>(this.service.findById(id).orElseThrow(ReserveNotFoundException::new), HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/exists/{id}")
    @ApiOperation(value = "Find reserve by Id", notes = "Service of find reserve by id and response return a boolean operation")
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
    @ApiOperation(value = "Count reserve", notes = "Service of count all reserves")
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
    @ApiOperation(value = "Save reserve", notes = "Service of save reserve")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<Reserve> save(@RequestBody ReserveDto reserveDto) {
        return new ResponseEntity<>(this.service.save(reserveDto.fromDto(reserveDto)), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value = "Find and update reserve", notes = "Service of update reserve")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<Reserve> update(@RequestParam Integer id, @RequestBody ReserveDto reserveDto) {
        return new ResponseEntity<>(this.service.save(reserveDto.fromDto(reserveDto)), HttpStatus.OK);
    }

    @Override
    @DeleteMapping
    @ApiOperation(value = "Find and delete reserve", notes = "Service of delete reserve")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam Integer id) {
        HashMap<String, Boolean> response = new HashMap<>();
        this.service.delete(new Reserve(id));
        response.put("message", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
