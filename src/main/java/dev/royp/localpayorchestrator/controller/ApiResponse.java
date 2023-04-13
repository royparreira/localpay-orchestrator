package dev.royp.localpayorchestrator.controller;

import lombok.*;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

  private T data;

  public static <T> Mono<ApiResponse<T>> of(T data) {
    return Mono.just(new ApiResponse<>(data));
  }
}
