package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;

import java.util.List;

public interface GetGuardiansUseCase {
    List<Guardian> execute();
}
