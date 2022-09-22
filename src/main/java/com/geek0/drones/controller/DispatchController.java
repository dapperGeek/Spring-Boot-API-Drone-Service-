package com.geek0.drones.controller;

import com.geek0.drones.model.Dispatch;
import com.geek0.drones.service.DispatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dispatch")
@AllArgsConstructor
public class DispatchController {
    private final DispatchService dispatchService;

    @GetMapping
    public List<Dispatch> fetchDispatches() {
        return dispatchService.getDispatches();
    }

    @PostMapping
    public void saveUpdateDispatch(@RequestBody Dispatch dispatch) {
        dispatchService.saveUpdateDispatch(dispatch);
    }
}
