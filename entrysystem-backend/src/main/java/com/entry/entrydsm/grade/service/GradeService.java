package com.entry.entrydsm.grade.service;

import com.entry.entrydsm.common.response.ResponseModel;
import com.entry.entrydsm.grade.domain.Grade;
import com.entry.entrydsm.user.User;

public interface GradeService {

    ResponseModel<Grade> getGrade(User user);
}
