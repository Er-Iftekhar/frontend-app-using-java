package com.app.javabackend.dto;

import com.app.model.AnsweredQuestionnaire;
import com.app.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Process {
    private UUID id;
    private String processName;
    private List<User> users = new ArrayList<>();
    private List<AnsweredQuestionnaire> answeredQuestionnaires = new ArrayList<>();
}
