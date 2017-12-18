package models;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class QueueSystemInput {
    private Double arrivalRate;
    private Double serviceRate;
    private Integer numberOfServers;
    private Integer systemCapacity;

    public QueueSystemInput(@NonNull Double arrivalRate, @NonNull Double serviceRate,
                            @Nullable Integer numberOfServers, @Nullable Integer systemCapacity) {
        this.arrivalRate = arrivalRate;
        this.serviceRate = serviceRate;
        this.numberOfServers = numberOfServers;
        this.systemCapacity = systemCapacity;
    }

    public Double getArrivalRate() {
        return arrivalRate;
    }

    public Double getServiceRate() {
        return serviceRate;
    }

    public Integer getNumberOfServers() {
        return numberOfServers;
    }

    public Integer getSystemCapacity() {
        return systemCapacity;
    }

    @Override
    public String toString() {
        return "QueueSystemInput{" +
                "arrivalRate=" + arrivalRate +
                ", serviceRate=" + serviceRate +
                ", numberOfServers=" + numberOfServers +
                ", systemCapacity=" + systemCapacity +
                '}';
    }
}
