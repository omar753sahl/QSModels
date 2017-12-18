package models;

/**
 * Data class for Performance Metrics {L, Lq, W, Wq}
 */
public class PerformanceMetrics {
    private double L;
    private double Lq;
    private double W;
    private double Wq;

    public PerformanceMetrics() {
    }

    public PerformanceMetrics(double l, double lq, double w, double wq) {
        L = l;
        Lq = lq;
        W = w;
        Wq = wq;
    }

    public double getL() {
        return L;
    }

    public double getLq() {
        return Lq;
    }

    public double getW() {
        return W;
    }

    public double getWq() {
        return Wq;
    }
}
