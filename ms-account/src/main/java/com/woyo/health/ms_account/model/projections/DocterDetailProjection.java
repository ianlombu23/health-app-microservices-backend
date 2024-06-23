package com.woyo.health.ms_account.model.projections;

public interface DocterDetailProjection {
    String getDocterId();
    String getFullName();
    String getSpecialistName();
    String getGender();
    String getEmail();
    boolean getIsActive();
}
