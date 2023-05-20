package com.nitesh.appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ProviderAppointment {
    public LocalDateTime appointmentTime;
    public String patientID;

    public ProviderAppointment(LocalDateTime appointmentTime, String patientID) {
        this.appointmentTime = appointmentTime;
        this.patientID = patientID;

    }
}

class PatientAppointment {
    public LocalDateTime appointmentTime;
    public String providerID;

    public PatientAppointment(LocalDateTime appointmentTime, String providerID) {
        this.appointmentTime = appointmentTime;
        this.providerID = providerID;

    }
}

public class VaccineScheduler {

    Map<LocalDate, Map<LocalDateTime, List<String>>> availableAppointments = new HashMap<>();
    Map<String, PatientAppointment> patientAppointmentMap = new HashMap<>();
    Map<LocalDate, Map<String, List<ProviderAppointment>>> bookedProvidersAppointments = new HashMap<>();

    public void scheduleAppointment(String patientID, String providerID, LocalDateTime appointmentTime) {
        if (patientAppointmentMap.containsKey(patientID)) {
            throw new RuntimeException("Already Booked");
        }

        LocalDate date = appointmentTime.toLocalDate();
        List<String> availableProviders = availableAppointments.get(date).get(appointmentTime);
        if (!availableProviders.contains(providerID)) {
            throw new RuntimeException("No Providers available");
        }
        removeAppointment(providerID, appointmentTime);
        PatientAppointment patientAppointment = new PatientAppointment(appointmentTime, providerID);
        patientAppointmentMap.put(patientID, patientAppointment);
        addToBookedAppointments(providerID, new ProviderAppointment(appointmentTime, patientID));
    }

    public void cancelAppointment(String patientID) {
        PatientAppointment patientAppointment = patientAppointmentMap.getOrDefault(patientID, null);
        if (patientAppointment != null) {
            patientAppointmentMap.remove(patientID);
            addAppointment(patientAppointment.providerID, patientAppointment.appointmentTime);
            removeBookedAppointments(patientAppointment);
        }
    }

    public PatientAppointment getPatientAppointment(String patientID) {
        return patientAppointmentMap.getOrDefault(patientID, null);
    }

    public Map<LocalDateTime, List<String>> getAvailableAppointments(LocalDate day) {
        return availableAppointments.getOrDefault(day, null);
    }

    public void addAppointment(String providerID, LocalDateTime appointmentTime) {
        LocalDate date = appointmentTime.toLocalDate();
        availableAppointments.putIfAbsent(appointmentTime.toLocalDate(), new HashMap<>());
        availableAppointments.get(date).putIfAbsent(appointmentTime, new ArrayList<>());
        availableAppointments.get(date).get(appointmentTime).add(providerID);
    }

    public void removeAppointment(String providerID, LocalDateTime appointmentTime) {
        LocalDate date = appointmentTime.toLocalDate();
        List<String> providers = availableAppointments.get(date).getOrDefault(appointmentTime, null);
        if (providers != null && !providers.isEmpty()) {
            providers.remove(providerID);
        }
    }

    public List<ProviderAppointment> getProviderSchedule(String providerID, LocalDate day) {
        return bookedProvidersAppointments.getOrDefault(day, new HashMap<>())
                .getOrDefault(providerID, new ArrayList<>());
    }

    private void addToBookedAppointments(String providerID, ProviderAppointment providerAppointment) {
        LocalDate localDate = providerAppointment.appointmentTime.toLocalDate();

        bookedProvidersAppointments.putIfAbsent(localDate, new HashMap<>());
        bookedProvidersAppointments.get(localDate).putIfAbsent(providerID, new ArrayList<>());

        bookedProvidersAppointments.get(localDate).get(providerID).add(providerAppointment);
    }

    private void removeBookedAppointments(PatientAppointment patientAppointment) {
        LocalDate localDate = patientAppointment.appointmentTime.toLocalDate();
        String provider = patientAppointment.providerID;

        Map<String, List<ProviderAppointment>> bookedMap = bookedProvidersAppointments.getOrDefault(localDate, new HashMap<>());
        List<ProviderAppointment> bookedSlots = bookedMap.getOrDefault(provider, new ArrayList<>());
        ProviderAppointment toBeRemoved = null;
        for (ProviderAppointment appointment : bookedSlots) {
            if (appointment.appointmentTime.equals(patientAppointment.appointmentTime)) {
                toBeRemoved = appointment;
                break;
            }
        }
        bookedSlots.remove(toBeRemoved);
    }
}
