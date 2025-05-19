package com.catskhi.school.infra.presentation;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.core.usecases.guardian.*;
import com.catskhi.school.infra.dtos.guardians.request.GuardianRequest;
import com.catskhi.school.infra.mappers.guardian.GuardianDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/guardian")
@RequiredArgsConstructor
public class GuardianController {
    private final CreateGuardianUseCase createGuardianUseCase;
    private final GetGuardiansUseCase getGuardiansUseCase;
    private final GetGuardianByIdUseCase getGuardianByIdUseCase;
    private final UpdateGuardianUseCase updateGuardianUseCase;
    private final DeleteGuardianUseCase deleteGuardianUseCase;
    private final GuardianDtoMapper dtoMapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody GuardianRequest request) {
        Guardian guardian = createGuardianUseCase.execute(dtoMapper.toGuardian(request));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "guardian successfully created.");
        response.put("data", dtoMapper.toGuardianResponse(guardian));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Guardian>> getGuardians() {
        List<Guardian> guardians = getGuardiansUseCase.execute();
        return ResponseEntity.ok(guardians);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getGuardianById(@PathVariable UUID id) {
        Guardian guardian = getGuardianByIdUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "guardian successfully found.");
        response.put("data", dtoMapper.toGuardianResponse(guardian));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateGuardianById(@PathVariable UUID id, @Valid @RequestBody GuardianRequest request) {
        Guardian updatedGuardian = updateGuardianUseCase.execute(id, dtoMapper.toGuardian(request));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "guardian of id: " + id + " successfully updated.");
        response.put("data", dtoMapper.toGuardianResponse(updatedGuardian));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteGuardian(@PathVariable UUID id) {
        deleteGuardianUseCase.execute(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Guardian of id " + id + " deleted.");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
