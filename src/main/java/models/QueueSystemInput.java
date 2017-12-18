package models;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class QueueSystemInput {
    private Double arrivalRate;
    private Double serviceRate;
    private int numberOfServers;
    private int systemCapacity;

    public QueueSystemInput(@NonNull Double arrivalRate, @NonNull Double serviceRate,
                            @Nullable int numberOfServers, @Nullable int systemCapacity) {
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

    public int getNumberOfServers() {
        return numberOfServers;
    }

    public int getSystemCapacity() {
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
