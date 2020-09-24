package com.bwebb.swingy.model.artifacts;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class Artifact {
    @NotBlank
    public String type;

    @Range(max=Artifacts.artifactBaseStat + Artifacts.artifactStatRange)
    public int buff;

    public Artifact(String type, int buff) {
        this.type = type;
        this.buff = buff;
    }
}
