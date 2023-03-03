package io.beansprout.spooly.controllers;

import io.beansprout.spooly.clients.MSClient;
import io.beansprout.spooly.models.Manufacturer;
import io.beansprout.spooly.services.ManuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {
  private final ManuService manuService;
  private final MSClient client;

  public ManufacturerController(ManuService manuService, MSClient client) {
    this.manuService = manuService;
    this.client = client;
  }

  @GetMapping("/{name}")
  public ResponseEntity<Manufacturer> getManufacturer(@PathVariable String name) {
    return ResponseEntity.ok(manuService.findByName(name));
  }
}
