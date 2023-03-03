package io.beansprout.boost.controllers;

import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.beansprout.boost.DTOs.TurboDTO;
import io.beansprout.boost.models.Supercharger;
import io.beansprout.boost.models.SuperchargerDTO;
import io.beansprout.boost.models.Turbo;
import io.beansprout.boost.services.SuperchargerService;
import io.beansprout.boost.services.TurboService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Interface for errors with code
 *
 * @author Kollier Martin
 * @date 1/6/2021
 */
@RefreshScope
@RequestMapping(value = "/api/boost/")
@RestController
public class BoostController {
  private final TurboService turboService;
  private final SuperchargerService superchargerService;

  public BoostController(TurboService turboService, SuperchargerService superchargerService) {
    this.turboService = turboService;
    this.superchargerService = superchargerService;
  }

  public ResponseEntity<String> newTurbo(final String name, final Integer size) {
    Gson json = new Gson();

    String turbo = json.toJson(new TurboDTO());

    return ResponseEntity.ok(turbo);
  }

  // region Turbo Methods
  // TODO: Use Resilience4J instead
  @HystrixCommand(
      fallbackMethod = "nullTurbo",
      commandProperties = {
        @HystrixProperty(
            name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "30000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000")
      },
      threadPoolProperties = {
        @HystrixProperty(name = "coreSize", value = "30"),
        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000")
      })
  @GetMapping("/turbo/{name}/{size}")
  public ResponseEntity<TurboDTO> getTurboByNameAndSize(
      @PathVariable String name, @PathVariable Integer size) {
    return ResponseEntity.ok(TurboDTO.convert(turboService.findByNameAndSizeInMM(name, size)));
  }

  @GetMapping("/turbo/{name}")
  public ResponseEntity<TurboDTO> getTurboByName(@PathVariable String name) {
    return ResponseEntity.ok(TurboDTO.convert(turboService.findByName(name)));
  }

  @GetMapping("/turbo/{manufacturer}")
  public ResponseEntity<TurboDTO> getTurboByManufacturer(@PathVariable String manufacturer) {
    return ResponseEntity.ok(TurboDTO.convert(turboService.findByManufacturer(manufacturer)));
  }

  @GetMapping("/turbo/{rotation}")
  public ResponseEntity<TurboDTO> getTurboByRotation(@PathVariable String rotation) {
    Turbo.Rotation trueRotation = Turbo.Rotation.valueOf(rotation.toUpperCase());
    return ResponseEntity.ok(TurboDTO.convert(turboService.findByRotation(trueRotation)));
  }
  // endregion

  // region Supercharger Methods
  @GetMapping("/supercharger/{name}")
  public ResponseEntity<SuperchargerDTO> getSuperchargerByName(@PathVariable String name) {
    return ResponseEntity.ok(SuperchargerDTO.convert(superchargerService.findByName(name)));
  }

  @GetMapping("/supercharger/{manufacturer}")
  public ResponseEntity<SuperchargerDTO> getSuperchargerByManufacturer(
      @PathVariable String manufacturer) {
    return ResponseEntity.ok(
        SuperchargerDTO.convert(superchargerService.findByManufacturer(manufacturer)));
  }

  @GetMapping("/supercharger/{rotation}")
  public ResponseEntity<SuperchargerDTO> getSuperchargerByManufacturer(
      @PathVariable Supercharger.Rotation rotation) {
    return ResponseEntity.ok(SuperchargerDTO.convert(superchargerService.findByRotation(rotation)));
  }
  // endregion

}
